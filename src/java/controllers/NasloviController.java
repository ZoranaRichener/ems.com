package controllers;

import beans.Naslovi;
import controllers.util.JsfUtil;
import controllers.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("nasloviController")
@SessionScoped
public class NasloviController implements Serializable {

    private Naslovi current;
    private DataModel items = null;
    @EJB
    private controllers.NasloviFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public NasloviController() {
    }

    public Naslovi getSelected() {
        if (current == null) {
            current = new Naslovi();
            current.setNasloviPK(new beans.NasloviPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private NasloviFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Naslovi) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Naslovi();
        current.setNasloviPK(new beans.NasloviPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getNasloviPK().setZaposleniBr(current.getZaposleni().getZaposleniBr());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("NasloviCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Naslovi) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getNasloviPK().setZaposleniBr(current.getZaposleni().getZaposleniBr());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("NasloviUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Naslovi) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("NasloviDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Naslovi getNaslovi(beans.NasloviPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Naslovi.class)
    public static class NasloviControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NasloviController controller = (NasloviController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "nasloviController");
            return controller.getNaslovi(getKey(value));
        }

        beans.NasloviPK getKey(String value) {
            beans.NasloviPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new beans.NasloviPK();
            key.setZaposleniBr(Integer.parseInt(values[0]));
            key.setNaslov(values[1]);
            key.setOdDatuma(java.sql.Date.valueOf(values[2]));
            return key;
        }

        String getStringKey(beans.NasloviPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getZaposleniBr());
            sb.append(SEPARATOR);
            sb.append(value.getNaslov());
            sb.append(SEPARATOR);
            sb.append(value.getOdDatuma());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Naslovi) {
                Naslovi o = (Naslovi) object;
                return getStringKey(o.getNasloviPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Naslovi.class.getName());
            }
        }

    }

}

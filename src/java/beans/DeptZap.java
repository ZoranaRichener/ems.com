/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "dept_zap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeptZap.findAll", query = "SELECT d FROM DeptZap d")
    , @NamedQuery(name = "DeptZap.findByZaposleniBr", query = "SELECT d FROM DeptZap d WHERE d.deptZapPK.zaposleniBr = :zaposleniBr")
    , @NamedQuery(name = "DeptZap.findByDeptBr", query = "SELECT d FROM DeptZap d WHERE d.deptZapPK.deptBr = :deptBr")
    , @NamedQuery(name = "DeptZap.findByOdDatuma", query = "SELECT d FROM DeptZap d WHERE d.odDatuma = :odDatuma")
    , @NamedQuery(name = "DeptZap.findByDoDatuma", query = "SELECT d FROM DeptZap d WHERE d.doDatuma = :doDatuma")})
public class DeptZap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeptZapPK deptZapPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "od_datuma")
    @Temporal(TemporalType.DATE)
    private Date odDatuma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "do_datuma")
    @Temporal(TemporalType.DATE)
    private Date doDatuma;
    @JoinColumn(name = "zaposleni_br", referencedColumnName = "zaposleni_br", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zaposleni zaposleni;
    @JoinColumn(name = "dept_br", referencedColumnName = "dept_br", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departmani departmani;

    public DeptZap() {
    }

    public DeptZap(DeptZapPK deptZapPK) {
        this.deptZapPK = deptZapPK;
    }

    public DeptZap(DeptZapPK deptZapPK, Date odDatuma, Date doDatuma) {
        this.deptZapPK = deptZapPK;
        this.odDatuma = odDatuma;
        this.doDatuma = doDatuma;
    }

    public DeptZap(int zaposleniBr, String deptBr) {
        this.deptZapPK = new DeptZapPK(zaposleniBr, deptBr);
    }

    public DeptZapPK getDeptZapPK() {
        return deptZapPK;
    }

    public void setDeptZapPK(DeptZapPK deptZapPK) {
        this.deptZapPK = deptZapPK;
    }

    public Date getOdDatuma() {
        return odDatuma;
    }

    public void setOdDatuma(Date odDatuma) {
        this.odDatuma = odDatuma;
    }

    public Date getDoDatuma() {
        return doDatuma;
    }

    public void setDoDatuma(Date doDatuma) {
        this.doDatuma = doDatuma;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Departmani getDepartmani() {
        return departmani;
    }

    public void setDepartmani(Departmani departmani) {
        this.departmani = departmani;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptZapPK != null ? deptZapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptZap)) {
            return false;
        }
        DeptZap other = (DeptZap) object;
        if ((this.deptZapPK == null && other.deptZapPK != null) || (this.deptZapPK != null && !this.deptZapPK.equals(other.deptZapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.DeptZap[ deptZapPK=" + deptZapPK + " ]";
    }
    
}

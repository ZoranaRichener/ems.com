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
@Table(name = "dept_menadzer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeptMenadzer.findAll", query = "SELECT d FROM DeptMenadzer d")
    , @NamedQuery(name = "DeptMenadzer.findByDeptBr", query = "SELECT d FROM DeptMenadzer d WHERE d.deptMenadzerPK.deptBr = :deptBr")
    , @NamedQuery(name = "DeptMenadzer.findByZaposleniBr", query = "SELECT d FROM DeptMenadzer d WHERE d.deptMenadzerPK.zaposleniBr = :zaposleniBr")
    , @NamedQuery(name = "DeptMenadzer.findByOdDatuma", query = "SELECT d FROM DeptMenadzer d WHERE d.odDatuma = :odDatuma")
    , @NamedQuery(name = "DeptMenadzer.findByDoDatuma", query = "SELECT d FROM DeptMenadzer d WHERE d.doDatuma = :doDatuma")})
public class DeptMenadzer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeptMenadzerPK deptMenadzerPK;
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

    public DeptMenadzer() {
    }

    public DeptMenadzer(DeptMenadzerPK deptMenadzerPK) {
        this.deptMenadzerPK = deptMenadzerPK;
    }

    public DeptMenadzer(DeptMenadzerPK deptMenadzerPK, Date odDatuma, Date doDatuma) {
        this.deptMenadzerPK = deptMenadzerPK;
        this.odDatuma = odDatuma;
        this.doDatuma = doDatuma;
    }

    public DeptMenadzer(String deptBr, int zaposleniBr) {
        this.deptMenadzerPK = new DeptMenadzerPK(deptBr, zaposleniBr);
    }

    public DeptMenadzerPK getDeptMenadzerPK() {
        return deptMenadzerPK;
    }

    public void setDeptMenadzerPK(DeptMenadzerPK deptMenadzerPK) {
        this.deptMenadzerPK = deptMenadzerPK;
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
        hash += (deptMenadzerPK != null ? deptMenadzerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptMenadzer)) {
            return false;
        }
        DeptMenadzer other = (DeptMenadzer) object;
        if ((this.deptMenadzerPK == null && other.deptMenadzerPK != null) || (this.deptMenadzerPK != null && !this.deptMenadzerPK.equals(other.deptMenadzerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.DeptMenadzer[ deptMenadzerPK=" + deptMenadzerPK + " ]";
    }
    
}

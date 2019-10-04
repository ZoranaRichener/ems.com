/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "departmani")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departmani.findAll", query = "SELECT d FROM Departmani d")
    , @NamedQuery(name = "Departmani.findByDeptBr", query = "SELECT d FROM Departmani d WHERE d.deptBr = :deptBr")
    , @NamedQuery(name = "Departmani.findByDeptNaziv", query = "SELECT d FROM Departmani d WHERE d.deptNaziv = :deptNaziv")})
public class Departmani implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "dept_br")
    private String deptBr;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "dept_naziv")
    private String deptNaziv;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmani")
    private Collection<DeptZap> deptZapCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmani")
    private Collection<DeptMenadzer> deptMenadzerCollection;

    public Departmani() {
    }

    public Departmani(String deptBr) {
        this.deptBr = deptBr;
    }

    public Departmani(String deptBr, String deptNaziv) {
        this.deptBr = deptBr;
        this.deptNaziv = deptNaziv;
    }

    public String getDeptBr() {
        return deptBr;
    }

    public void setDeptBr(String deptBr) {
        this.deptBr = deptBr;
    }

    public String getDeptNaziv() {
        return deptNaziv;
    }

    public void setDeptNaziv(String deptNaziv) {
        this.deptNaziv = deptNaziv;
    }

    @XmlTransient
    public Collection<DeptZap> getDeptZapCollection() {
        return deptZapCollection;
    }

    public void setDeptZapCollection(Collection<DeptZap> deptZapCollection) {
        this.deptZapCollection = deptZapCollection;
    }

    @XmlTransient
    public Collection<DeptMenadzer> getDeptMenadzerCollection() {
        return deptMenadzerCollection;
    }

    public void setDeptMenadzerCollection(Collection<DeptMenadzer> deptMenadzerCollection) {
        this.deptMenadzerCollection = deptMenadzerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptBr != null ? deptBr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departmani)) {
            return false;
        }
        Departmani other = (Departmani) object;
        if ((this.deptBr == null && other.deptBr != null) || (this.deptBr != null && !this.deptBr.equals(other.deptBr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Departmani[ deptBr=" + deptBr + " ]";
    }
    
}

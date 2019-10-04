/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Lenovo
 */
@Embeddable
public class DeptMenadzerPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "dept_br")
    private String deptBr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zaposleni_br")
    private int zaposleniBr;

    public DeptMenadzerPK() {
    }

    public DeptMenadzerPK(String deptBr, int zaposleniBr) {
        this.deptBr = deptBr;
        this.zaposleniBr = zaposleniBr;
    }

    public String getDeptBr() {
        return deptBr;
    }

    public void setDeptBr(String deptBr) {
        this.deptBr = deptBr;
    }

    public int getZaposleniBr() {
        return zaposleniBr;
    }

    public void setZaposleniBr(int zaposleniBr) {
        this.zaposleniBr = zaposleniBr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptBr != null ? deptBr.hashCode() : 0);
        hash += (int) zaposleniBr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptMenadzerPK)) {
            return false;
        }
        DeptMenadzerPK other = (DeptMenadzerPK) object;
        if ((this.deptBr == null && other.deptBr != null) || (this.deptBr != null && !this.deptBr.equals(other.deptBr))) {
            return false;
        }
        if (this.zaposleniBr != other.zaposleniBr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.DeptMenadzerPK[ deptBr=" + deptBr + ", zaposleniBr=" + zaposleniBr + " ]";
    }
    
}

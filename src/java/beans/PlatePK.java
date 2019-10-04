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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lenovo
 */
@Embeddable
public class PlatePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "zaposleni_br")
    private int zaposleniBr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "od_datuma")
    @Temporal(TemporalType.DATE)
    private Date odDatuma;

    public PlatePK() {
    }

    public PlatePK(int zaposleniBr, Date odDatuma) {
        this.zaposleniBr = zaposleniBr;
        this.odDatuma = odDatuma;
    }

    public int getZaposleniBr() {
        return zaposleniBr;
    }

    public void setZaposleniBr(int zaposleniBr) {
        this.zaposleniBr = zaposleniBr;
    }

    public Date getOdDatuma() {
        return odDatuma;
    }

    public void setOdDatuma(Date odDatuma) {
        this.odDatuma = odDatuma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) zaposleniBr;
        hash += (odDatuma != null ? odDatuma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatePK)) {
            return false;
        }
        PlatePK other = (PlatePK) object;
        if (this.zaposleniBr != other.zaposleniBr) {
            return false;
        }
        if ((this.odDatuma == null && other.odDatuma != null) || (this.odDatuma != null && !this.odDatuma.equals(other.odDatuma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.PlatePK[ zaposleniBr=" + zaposleniBr + ", odDatuma=" + odDatuma + " ]";
    }
    
}

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
@Table(name = "plate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plate.findAll", query = "SELECT p FROM Plate p")
    , @NamedQuery(name = "Plate.findByZaposleniBr", query = "SELECT p FROM Plate p WHERE p.platePK.zaposleniBr = :zaposleniBr")
    , @NamedQuery(name = "Plate.findByPlata", query = "SELECT p FROM Plate p WHERE p.plata = :plata")
    , @NamedQuery(name = "Plate.findByOdDatuma", query = "SELECT p FROM Plate p WHERE p.platePK.odDatuma = :odDatuma")
    , @NamedQuery(name = "Plate.findByDoDatuma", query = "SELECT p FROM Plate p WHERE p.doDatuma = :doDatuma")})
public class Plate implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlatePK platePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plata")
    private int plata;
    @Basic(optional = false)
    @NotNull
    @Column(name = "do_datuma")
    @Temporal(TemporalType.DATE)
    private Date doDatuma;
    @JoinColumn(name = "zaposleni_br", referencedColumnName = "zaposleni_br", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zaposleni zaposleni;

    public Plate() {
    }

    public Plate(PlatePK platePK) {
        this.platePK = platePK;
    }

    public Plate(PlatePK platePK, int plata, Date doDatuma) {
        this.platePK = platePK;
        this.plata = plata;
        this.doDatuma = doDatuma;
    }

    public Plate(int zaposleniBr, Date odDatuma) {
        this.platePK = new PlatePK(zaposleniBr, odDatuma);
    }

    public PlatePK getPlatePK() {
        return platePK;
    }

    public void setPlatePK(PlatePK platePK) {
        this.platePK = platePK;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platePK != null ? platePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plate)) {
            return false;
        }
        Plate other = (Plate) object;
        if ((this.platePK == null && other.platePK != null) || (this.platePK != null && !this.platePK.equals(other.platePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Plate[ platePK=" + platePK + " ]";
    }
    
}

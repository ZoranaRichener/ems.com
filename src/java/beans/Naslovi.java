/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "naslovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naslovi.findAll", query = "SELECT n FROM Naslovi n")
    , @NamedQuery(name = "Naslovi.findByZaposleniBr", query = "SELECT n FROM Naslovi n WHERE n.nasloviPK.zaposleniBr = :zaposleniBr")
    , @NamedQuery(name = "Naslovi.findByNaslov", query = "SELECT n FROM Naslovi n WHERE n.nasloviPK.naslov = :naslov")
    , @NamedQuery(name = "Naslovi.findByOdDatuma", query = "SELECT n FROM Naslovi n WHERE n.nasloviPK.odDatuma = :odDatuma")
    , @NamedQuery(name = "Naslovi.findByDoDatuma", query = "SELECT n FROM Naslovi n WHERE n.doDatuma = :doDatuma")})
public class Naslovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NasloviPK nasloviPK;
    @Column(name = "do_datuma")
    @Temporal(TemporalType.DATE)
    private Date doDatuma;
    @JoinColumn(name = "zaposleni_br", referencedColumnName = "zaposleni_br", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zaposleni zaposleni;

    public Naslovi() {
    }

    public Naslovi(NasloviPK nasloviPK) {
        this.nasloviPK = nasloviPK;
    }

    public Naslovi(int zaposleniBr, String naslov, Date odDatuma) {
        this.nasloviPK = new NasloviPK(zaposleniBr, naslov, odDatuma);
    }

    public NasloviPK getNasloviPK() {
        return nasloviPK;
    }

    public void setNasloviPK(NasloviPK nasloviPK) {
        this.nasloviPK = nasloviPK;
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
        hash += (nasloviPK != null ? nasloviPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Naslovi)) {
            return false;
        }
        Naslovi other = (Naslovi) object;
        if ((this.nasloviPK == null && other.nasloviPK != null) || (this.nasloviPK != null && !this.nasloviPK.equals(other.nasloviPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Naslovi[ nasloviPK=" + nasloviPK + " ]";
    }
    
}

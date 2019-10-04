/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z")
    , @NamedQuery(name = "Zaposleni.findByZaposleniBr", query = "SELECT z FROM Zaposleni z WHERE z.zaposleniBr = :zaposleniBr")
    , @NamedQuery(name = "Zaposleni.findByDatumRodjenja", query = "SELECT z FROM Zaposleni z WHERE z.datumRodjenja = :datumRodjenja")
    , @NamedQuery(name = "Zaposleni.findByIme", query = "SELECT z FROM Zaposleni z WHERE z.ime = :ime")
    , @NamedQuery(name = "Zaposleni.findByPrezime", query = "SELECT z FROM Zaposleni z WHERE z.prezime = :prezime")
    , @NamedQuery(name = "Zaposleni.findByPol", query = "SELECT z FROM Zaposleni z WHERE z.pol = :pol")
    , @NamedQuery(name = "Zaposleni.findByAngazovanOd", query = "SELECT z FROM Zaposleni z WHERE z.angazovanOd = :angazovanOd")})
public class Zaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "zaposleni_br")
    private Integer zaposleniBr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum_rodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "pol")
    private String pol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "angazovan_od")
    @Temporal(TemporalType.DATE)
    private Date angazovanOd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleni")
    private Collection<DeptZap> deptZapCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleni")
    private Collection<DeptMenadzer> deptMenadzerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleni")
    private Collection<Plate> plateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleni")
    private Collection<Naslovi> nasloviCollection;

    public Zaposleni() {
    }

    public Zaposleni(Integer zaposleniBr) {
        this.zaposleniBr = zaposleniBr;
    }

    public Zaposleni(Integer zaposleniBr, Date datumRodjenja, String ime, String prezime, String pol, Date angazovanOd) {
        this.zaposleniBr = zaposleniBr;
        this.datumRodjenja = datumRodjenja;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.angazovanOd = angazovanOd;
    }

    public Integer getZaposleniBr() {
        return zaposleniBr;
    }

    public void setZaposleniBr(Integer zaposleniBr) {
        this.zaposleniBr = zaposleniBr;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Date getAngazovanOd() {
        return angazovanOd;
    }

    public void setAngazovanOd(Date angazovanOd) {
        this.angazovanOd = angazovanOd;
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

    @XmlTransient
    public Collection<Plate> getPlateCollection() {
        return plateCollection;
    }

    public void setPlateCollection(Collection<Plate> plateCollection) {
        this.plateCollection = plateCollection;
    }

    @XmlTransient
    public Collection<Naslovi> getNasloviCollection() {
        return nasloviCollection;
    }

    public void setNasloviCollection(Collection<Naslovi> nasloviCollection) {
        this.nasloviCollection = nasloviCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zaposleniBr != null ? zaposleniBr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.zaposleniBr == null && other.zaposleniBr != null) || (this.zaposleniBr != null && !this.zaposleniBr.equals(other.zaposleniBr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Zaposleni[ zaposleniBr=" + zaposleniBr + " ]";
    }
    
}

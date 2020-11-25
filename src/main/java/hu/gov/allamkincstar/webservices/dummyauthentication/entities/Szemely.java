package hu.gov.allamkincstar.webservices.dummyauthentication.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "szemely")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Szemely.findAll", query = "SELECT s FROM Szemely s")
        , @NamedQuery(name = "Szemely.findByAzon", query = "SELECT s FROM Szemely s WHERE s.azon = :azon")
        , @NamedQuery(name = "Szemely.listByAdoAzon", query = "SELECT s FROM Szemely s WHERE s.adoazon IN :adoAzon")
        , @NamedQuery(name = "Szemely.findByAdoazon", query = "SELECT s FROM Szemely s WHERE s.adoazon = :adoazon")
        , @NamedQuery(name = "Szemely.findByElonev", query = "SELECT s FROM Szemely s WHERE s.elonev = :elonev")
        , @NamedQuery(name = "Szemely.findByInev", query = "SELECT s FROM Szemely s WHERE s.inev = :inev")})
public class Szemely implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "A mező nem lehet üres.")
    @Column(name = "azon")
    private Long azon;
    @Size(max = 10, message = "A méret maximum {max} lehet.")
    @Column(name = "adoazon")
    private String adoazon;
    @Size(max = 10, message = "A méret maximum {max} lehet.")
    @Column(name = "elonev")
    private String elonev;
    @Size(max = 100, message = "A méret maximum {max} lehet.")
    @Column(name = "inev")
    private String inev;

    public Szemely() {
    }

    public Szemely(Long azon) {
        this.azon = azon;
    }

    public Long getAzon() {
        return azon;
    }

    public void setAzon(Long azon) {
        this.azon = azon;
    }

    public String getAdoazon() {
        return adoazon;
    }

    public void setAdoazon(String adoazon) {
        this.adoazon = adoazon;
    }

    public String getElonev() {
        return elonev;
    }

    public void setElonev(String elonev) {
        this.elonev = elonev;
    }

    public String getInev() {
        return inev;
    }

    public void setInev(String inev) {
        this.inev = inev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (azon != null ? azon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Szemely)) {
            return false;
        }
        Szemely other = (Szemely) object;
        return (this.azon != null || other.azon == null) && (this.azon == null || this.azon.equals(other.azon));
    }

    @Override
    public String toString() {
        return "hu.gov.allamkincstar.ikl.entity.Szemely[ azon=" + azon + " ]";
    }

}

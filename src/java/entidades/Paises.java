/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FAMILIA ALDANA
 */
@Entity
@Table(name = "paises")
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findByPaisId", query = "SELECT p FROM Paises p WHERE p.paisId = :paisId"),
    @NamedQuery(name = "Paises.findByPaisNombre", query = "SELECT p FROM Paises p WHERE p.paisNombre = :paisNombre"),
    @NamedQuery(name = "Paises.findByPaisContinente", query = "SELECT p FROM Paises p WHERE p.paisContinente = :paisContinente")})
public class Paises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pais_id")
    private Integer paisId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pais_nombre")
    private String paisNombre;
    @Size(max = 100)
    @Column(name = "pais_continente")
    private String paisContinente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisId")
    private List<Instituciones> institucionesList;
    @JoinColumn(name = "conti_id", referencedColumnName = "conti_id")
    @ManyToOne(optional = false)
    private Continentes contiId;

    public Paises() {
    }

    public Paises(Integer paisId) {
        this.paisId = paisId;
    }

    public Paises(Integer paisId, String paisNombre) {
        this.paisId = paisId;
        this.paisNombre = paisNombre;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }

    public String getPaisContinente() {
        return paisContinente;
    }

    public void setPaisContinente(String paisContinente) {
        this.paisContinente = paisContinente;
    }

    public List<Instituciones> getInstitucionesList() {
        return institucionesList;
    }

    public void setInstitucionesList(List<Instituciones> institucionesList) {
        this.institucionesList = institucionesList;
    }

    public Continentes getContiId() {
        return contiId;
    }

    public void setContiId(Continentes contiId) {
        this.contiId = contiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisId != null ? paisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.paisId == null && other.paisId != null) || (this.paisId != null && !this.paisId.equals(other.paisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Paises[ paisId=" + paisId + " ]";
    }
    
}

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
@Table(name = "continentes")
@NamedQueries({
    @NamedQuery(name = "Continentes.findAll", query = "SELECT c FROM Continentes c"),
    @NamedQuery(name = "Continentes.findByContiId", query = "SELECT c FROM Continentes c WHERE c.contiId = :contiId"),
    @NamedQuery(name = "Continentes.findByContiNombre", query = "SELECT c FROM Continentes c WHERE c.contiNombre = :contiNombre")})
public class Continentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conti_id")
    private Integer contiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "conti_nombre")
    private String contiNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contiId")
    private List<Paises> paisesList;

    public Continentes() {
    }

    public Continentes(Integer contiId) {
        this.contiId = contiId;
    }

    public Continentes(Integer contiId, String contiNombre) {
        this.contiId = contiId;
        this.contiNombre = contiNombre;
    }

    public Integer getContiId() {
        return contiId;
    }

    public void setContiId(Integer contiId) {
        this.contiId = contiId;
    }

    public String getContiNombre() {
        return contiNombre;
    }

    public void setContiNombre(String contiNombre) {
        this.contiNombre = contiNombre;
    }

    public List<Paises> getPaisesList() {
        return paisesList;
    }

    public void setPaisesList(List<Paises> paisesList) {
        this.paisesList = paisesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contiId != null ? contiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continentes)) {
            return false;
        }
        Continentes other = (Continentes) object;
        if ((this.contiId == null && other.contiId != null) || (this.contiId != null && !this.contiId.equals(other.contiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Continentes[ contiId=" + contiId + " ]";
    }
    
}

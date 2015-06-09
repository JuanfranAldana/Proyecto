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
@Table(name = "fuentes_financiamiento")
@NamedQueries({
    @NamedQuery(name = "FuentesFinanciamiento.findAll", query = "SELECT f FROM FuentesFinanciamiento f"),
    @NamedQuery(name = "FuentesFinanciamiento.findByFuenteId", query = "SELECT f FROM FuentesFinanciamiento f WHERE f.fuenteId = :fuenteId"),
    @NamedQuery(name = "FuentesFinanciamiento.findByFuenteNombre", query = "SELECT f FROM FuentesFinanciamiento f WHERE f.fuenteNombre = :fuenteNombre"),
    @NamedQuery(name = "FuentesFinanciamiento.findByFuenteDescripcion", query = "SELECT f FROM FuentesFinanciamiento f WHERE f.fuenteDescripcion = :fuenteDescripcion")})
public class FuentesFinanciamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fuente_id")
    private Integer fuenteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fuente_nombre")
    private String fuenteNombre;
    @Size(max = 500)
    @Column(name = "fuente_descripcion")
    private String fuenteDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuenteId")
    private List<Proyectos> proyectosList;

    public FuentesFinanciamiento() {
    }

    public FuentesFinanciamiento(Integer fuenteId) {
        this.fuenteId = fuenteId;
    }

    public FuentesFinanciamiento(Integer fuenteId, String fuenteNombre) {
        this.fuenteId = fuenteId;
        this.fuenteNombre = fuenteNombre;
    }

    public Integer getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(Integer fuenteId) {
        this.fuenteId = fuenteId;
    }

    public String getFuenteNombre() {
        return fuenteNombre;
    }

    public void setFuenteNombre(String fuenteNombre) {
        this.fuenteNombre = fuenteNombre;
    }

    public String getFuenteDescripcion() {
        return fuenteDescripcion;
    }

    public void setFuenteDescripcion(String fuenteDescripcion) {
        this.fuenteDescripcion = fuenteDescripcion;
    }

    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fuenteId != null ? fuenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuentesFinanciamiento)) {
            return false;
        }
        FuentesFinanciamiento other = (FuentesFinanciamiento) object;
        if ((this.fuenteId == null && other.fuenteId != null) || (this.fuenteId != null && !this.fuenteId.equals(other.fuenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FuentesFinanciamiento[ fuenteId=" + fuenteId + " ]";
    }
    
}

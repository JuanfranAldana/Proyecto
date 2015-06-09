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
@Table(name = "estados")
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e"),
    @NamedQuery(name = "Estados.findByEstadoId", query = "SELECT e FROM Estados e WHERE e.estadoId = :estadoId"),
    @NamedQuery(name = "Estados.findByEstadoNombre", query = "SELECT e FROM Estados e WHERE e.estadoNombre = :estadoNombre"),
    @NamedQuery(name = "Estados.findByEstadoDescripcion", query = "SELECT e FROM Estados e WHERE e.estadoDescripcion = :estadoDescripcion")})
public class Estados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_id")
    private Integer estadoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estado_nombre")
    private String estadoNombre;
    @Size(max = 500)
    @Column(name = "estado_descripcion")
    private String estadoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private List<Proyectos> proyectosList;

    public Estados() {
    }

    public Estados(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public Estados(Integer estadoId, String estadoNombre) {
        this.estadoId = estadoId;
        this.estadoNombre = estadoNombre;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
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
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estados[ estadoId=" + estadoId + " ]";
    }
    
}

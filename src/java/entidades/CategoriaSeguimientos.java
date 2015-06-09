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
@Table(name = "categoria_seguimientos")
@NamedQueries({
    @NamedQuery(name = "CategoriaSeguimientos.findAll", query = "SELECT c FROM CategoriaSeguimientos c"),
    @NamedQuery(name = "CategoriaSeguimientos.findByCatsegId", query = "SELECT c FROM CategoriaSeguimientos c WHERE c.catsegId = :catsegId"),
    @NamedQuery(name = "CategoriaSeguimientos.findByCatsegNombre", query = "SELECT c FROM CategoriaSeguimientos c WHERE c.catsegNombre = :catsegNombre"),
    @NamedQuery(name = "CategoriaSeguimientos.findByCatsegDescripcion", query = "SELECT c FROM CategoriaSeguimientos c WHERE c.catsegDescripcion = :catsegDescripcion")})
public class CategoriaSeguimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catseg_id")
    private Integer catsegId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "catseg_nombre")
    private String catsegNombre;
    @Size(max = 2147483647)
    @Column(name = "catseg_descripcion")
    private String catsegDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catsegId")
    private List<Seguimientos> seguimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catsegId")
    private List<SubCatseguimientos> subCatseguimientosList;

    public CategoriaSeguimientos() {
    }

    public CategoriaSeguimientos(Integer catsegId) {
        this.catsegId = catsegId;
    }

    public CategoriaSeguimientos(Integer catsegId, String catsegNombre) {
        this.catsegId = catsegId;
        this.catsegNombre = catsegNombre;
    }

    public Integer getCatsegId() {
        return catsegId;
    }

    public void setCatsegId(Integer catsegId) {
        this.catsegId = catsegId;
    }

    public String getCatsegNombre() {
        return catsegNombre;
    }

    public void setCatsegNombre(String catsegNombre) {
        this.catsegNombre = catsegNombre;
    }

    public String getCatsegDescripcion() {
        return catsegDescripcion;
    }

    public void setCatsegDescripcion(String catsegDescripcion) {
        this.catsegDescripcion = catsegDescripcion;
    }

    public List<Seguimientos> getSeguimientosList() {
        return seguimientosList;
    }

    public void setSeguimientosList(List<Seguimientos> seguimientosList) {
        this.seguimientosList = seguimientosList;
    }

    public List<SubCatseguimientos> getSubCatseguimientosList() {
        return subCatseguimientosList;
    }

    public void setSubCatseguimientosList(List<SubCatseguimientos> subCatseguimientosList) {
        this.subCatseguimientosList = subCatseguimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catsegId != null ? catsegId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaSeguimientos)) {
            return false;
        }
        CategoriaSeguimientos other = (CategoriaSeguimientos) object;
        if ((this.catsegId == null && other.catsegId != null) || (this.catsegId != null && !this.catsegId.equals(other.catsegId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CategoriaSeguimientos[ catsegId=" + catsegId + " ]";
    }
    
}

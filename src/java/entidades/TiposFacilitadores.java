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
@Table(name = "tipos_facilitadores")
@NamedQueries({
    @NamedQuery(name = "TiposFacilitadores.findAll", query = "SELECT t FROM TiposFacilitadores t"),
    @NamedQuery(name = "TiposFacilitadores.findByTipofId", query = "SELECT t FROM TiposFacilitadores t WHERE t.tipofId = :tipofId"),
    @NamedQuery(name = "TiposFacilitadores.findByTipofNombre", query = "SELECT t FROM TiposFacilitadores t WHERE t.tipofNombre = :tipofNombre"),
    @NamedQuery(name = "TiposFacilitadores.findByTipofDescripcion", query = "SELECT t FROM TiposFacilitadores t WHERE t.tipofDescripcion = :tipofDescripcion")})
public class TiposFacilitadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipof_id")
    private Integer tipofId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipof_nombre")
    private String tipofNombre;
    @Size(max = 500)
    @Column(name = "tipof_descripcion")
    private String tipofDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipofId")
    private List<FacilitadoresTecnicos> facilitadoresTecnicosList;

    public TiposFacilitadores() {
    }

    public TiposFacilitadores(Integer tipofId) {
        this.tipofId = tipofId;
    }

    public TiposFacilitadores(Integer tipofId, String tipofNombre) {
        this.tipofId = tipofId;
        this.tipofNombre = tipofNombre;
    }

    public Integer getTipofId() {
        return tipofId;
    }

    public void setTipofId(Integer tipofId) {
        this.tipofId = tipofId;
    }

    public String getTipofNombre() {
        return tipofNombre;
    }

    public void setTipofNombre(String tipofNombre) {
        this.tipofNombre = tipofNombre;
    }

    public String getTipofDescripcion() {
        return tipofDescripcion;
    }

    public void setTipofDescripcion(String tipofDescripcion) {
        this.tipofDescripcion = tipofDescripcion;
    }

    public List<FacilitadoresTecnicos> getFacilitadoresTecnicosList() {
        return facilitadoresTecnicosList;
    }

    public void setFacilitadoresTecnicosList(List<FacilitadoresTecnicos> facilitadoresTecnicosList) {
        this.facilitadoresTecnicosList = facilitadoresTecnicosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipofId != null ? tipofId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposFacilitadores)) {
            return false;
        }
        TiposFacilitadores other = (TiposFacilitadores) object;
        if ((this.tipofId == null && other.tipofId != null) || (this.tipofId != null && !this.tipofId.equals(other.tipofId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TiposFacilitadores[ tipofId=" + tipofId + " ]";
    }
    
}

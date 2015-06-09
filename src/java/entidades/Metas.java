/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FAMILIA ALDANA
 */
@Entity
@Table(name = "metas")
@NamedQueries({
    @NamedQuery(name = "Metas.findAll", query = "SELECT m FROM Metas m"),
    @NamedQuery(name = "Metas.findByMetaId", query = "SELECT m FROM Metas m WHERE m.metaId = :metaId"),
    @NamedQuery(name = "Metas.findByMetaNombre", query = "SELECT m FROM Metas m WHERE m.metaNombre = :metaNombre"),
    @NamedQuery(name = "Metas.findByMetaMtoSec", query = "SELECT m FROM Metas m WHERE m.metaMtoSec = :metaMtoSec"),
    @NamedQuery(name = "Metas.findByMetaMtoContraparte", query = "SELECT m FROM Metas m WHERE m.metaMtoContraparte = :metaMtoContraparte"),
    @NamedQuery(name = "Metas.findByMetaFechaReg", query = "SELECT m FROM Metas m WHERE m.metaFechaReg = :metaFechaReg")})
public class Metas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meta_id")
    private Integer metaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "meta_nombre")
    private String metaNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "meta_mto_sec")
    private Double metaMtoSec;
    @Column(name = "meta_mto_contraparte")
    private Double metaMtoContraparte;
    @Column(name = "meta_fecha_reg")
    @Temporal(TemporalType.DATE)
    private Date metaFechaReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metaId")
    private List<Actividades> actividadesList;
    @JoinColumn(name = "proye_id", referencedColumnName = "proye_id")
    @ManyToOne
    private Proyectos proyeId;

    public Metas() {
    }

    public Metas(Integer metaId) {
        this.metaId = metaId;
    }

    public Metas(Integer metaId, String metaNombre) {
        this.metaId = metaId;
        this.metaNombre = metaNombre;
    }

    public Integer getMetaId() {
        return metaId;
    }

    public void setMetaId(Integer metaId) {
        this.metaId = metaId;
    }

    public String getMetaNombre() {
        return metaNombre;
    }

    public void setMetaNombre(String metaNombre) {
        this.metaNombre = metaNombre;
    }

    public Double getMetaMtoSec() {
        return metaMtoSec;
    }

    public void setMetaMtoSec(Double metaMtoSec) {
        this.metaMtoSec = metaMtoSec;
    }

    public Double getMetaMtoContraparte() {
        return metaMtoContraparte;
    }

    public void setMetaMtoContraparte(Double metaMtoContraparte) {
        this.metaMtoContraparte = metaMtoContraparte;
    }

    public Date getMetaFechaReg() {
        return metaFechaReg;
    }

    public void setMetaFechaReg(Date metaFechaReg) {
        this.metaFechaReg = metaFechaReg;
    }

    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    public Proyectos getProyeId() {
        return proyeId;
    }

    public void setProyeId(Proyectos proyeId) {
        this.proyeId = proyeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metaId != null ? metaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metas)) {
            return false;
        }
        Metas other = (Metas) object;
        if ((this.metaId == null && other.metaId != null) || (this.metaId != null && !this.metaId.equals(other.metaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Metas[ metaId=" + metaId + " ]";
    }
    
}

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "actividades")
@NamedQueries({
    @NamedQuery(name = "Actividades.buscarMeta", query = "SELECT a FROM Actividades a WHERE a.metaId.metaId =:meta"),
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a"),
    @NamedQuery(name = "Actividades.findByActiId", query = "SELECT a FROM Actividades a WHERE a.actiId = :actiId"),
    @NamedQuery(name = "Actividades.findByActiNombre", query = "SELECT a FROM Actividades a WHERE a.actiNombre = :actiNombre"),
    @NamedQuery(name = "Actividades.findByActiDescripcion", query = "SELECT a FROM Actividades a WHERE a.actiDescripcion = :actiDescripcion"),
    @NamedQuery(name = "Actividades.findByActiFechaReg", query = "SELECT a FROM Actividades a WHERE a.actiFechaReg = :actiFechaReg")})
public class Actividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acti_id")
    private Integer actiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "acti_nombre")
    private String actiNombre;
    @Size(max = 500)
    @Column(name = "acti_descripcion")
    private String actiDescripcion;
    @Column(name = "acti_fecha_reg")
    @Temporal(TemporalType.DATE)
    private Date actiFechaReg;
    @JoinTable(name = "actividades_por_meses", joinColumns = {
        @JoinColumn(name = "acti_id", referencedColumnName = "acti_id")}, inverseJoinColumns = {
        @JoinColumn(name = "mes_id", referencedColumnName = "mes_id")})
    @ManyToMany
    private List<Meses> mesesList;
    @JoinColumn(name = "meta_id", referencedColumnName = "meta_id")
    @ManyToOne(optional = false)
    private Metas metaId;

    public Actividades() {
    }

    public Actividades(Integer actiId) {
        this.actiId = actiId;
    }

    public Actividades(Integer actiId, String actiNombre) {
        this.actiId = actiId;
        this.actiNombre = actiNombre;
    }

    public Integer getActiId() {
        return actiId;
    }

    public void setActiId(Integer actiId) {
        this.actiId = actiId;
    }

    public String getActiNombre() {
        return actiNombre;
    }

    public void setActiNombre(String actiNombre) {
        this.actiNombre = actiNombre;
    }

    public String getActiDescripcion() {
        return actiDescripcion;
    }

    public void setActiDescripcion(String actiDescripcion) {
        this.actiDescripcion = actiDescripcion;
    }

    public Date getActiFechaReg() {
        return actiFechaReg;
    }

    public void setActiFechaReg(Date actiFechaReg) {
        this.actiFechaReg = actiFechaReg;
    }

    public List<Meses> getMesesList() {
        return mesesList;
    }

    public void setMesesList(List<Meses> mesesList) {
        this.mesesList = mesesList;
    }

    public Metas getMetaId() {
        return metaId;
    }

    public void setMetaId(Metas metaId) {
        this.metaId = metaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actiId != null ? actiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.actiId == null && other.actiId != null) || (this.actiId != null && !this.actiId.equals(other.actiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Actividades[ actiId=" + actiId + " ]";
    }
    
}

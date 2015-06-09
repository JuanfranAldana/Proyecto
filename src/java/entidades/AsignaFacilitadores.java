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

/**
 *
 * @author FAMILIA ALDANA
 */
@Entity
@Table(name = "asigna_facilitadores")
@NamedQueries({
    @NamedQuery(name = "AsignaFacilitadores.findAll", query = "SELECT a FROM AsignaFacilitadores a"),
    @NamedQuery(name = "AsignaFacilitadores.findByAsigId", query = "SELECT a FROM AsignaFacilitadores a WHERE a.asigId = :asigId")})
public class AsignaFacilitadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asig_id")
    private Integer asigId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asigId")
    private List<Documentos> documentosList;
    @JoinColumn(name = "proye_id", referencedColumnName = "proye_id")
    @ManyToOne(optional = false)
    private Proyectos proyeId;
    @JoinColumn(name = "faci_id", referencedColumnName = "faci_id")
    @ManyToOne
    private FacilitadoresTecnicos faciId;

    public AsignaFacilitadores() {
    }

    public AsignaFacilitadores(Integer asigId) {
        this.asigId = asigId;
    }

    public Integer getAsigId() {
        return asigId;
    }

    public void setAsigId(Integer asigId) {
        this.asigId = asigId;
    }

    public List<Documentos> getDocumentosList() {
        return documentosList;
    }

    public void setDocumentosList(List<Documentos> documentosList) {
        this.documentosList = documentosList;
    }

    public Proyectos getProyeId() {
        return proyeId;
    }

    public void setProyeId(Proyectos proyeId) {
        this.proyeId = proyeId;
    }

    public FacilitadoresTecnicos getFaciId() {
        return faciId;
    }

    public void setFaciId(FacilitadoresTecnicos faciId) {
        this.faciId = faciId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asigId != null ? asigId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignaFacilitadores)) {
            return false;
        }
        AsignaFacilitadores other = (AsignaFacilitadores) object;
        if ((this.asigId == null && other.asigId != null) || (this.asigId != null && !this.asigId.equals(other.asigId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AsignaFacilitadores[ asigId=" + asigId + " ]";
    }
    
}

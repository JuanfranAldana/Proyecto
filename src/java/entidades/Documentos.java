/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FAMILIA ALDANA
 */
@Entity
@Table(name = "documentos")
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d"),
    @NamedQuery(name = "Documentos.findByDocuId", query = "SELECT d FROM Documentos d WHERE d.docuId = :docuId"),
    @NamedQuery(name = "Documentos.findByDocuNombre", query = "SELECT d FROM Documentos d WHERE d.docuNombre = :docuNombre"),
    @NamedQuery(name = "Documentos.findByDocuUrl", query = "SELECT d FROM Documentos d WHERE d.docuUrl = :docuUrl")})
public class Documentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "docu_id")
    private Integer docuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "docu_nombre")
    private String docuNombre;
    @Size(max = 300)
    @Column(name = "docu_url")
    private String docuUrl;
    @JoinColumn(name = "segui_id", referencedColumnName = "segui_id")
    @ManyToOne(optional = false)
    private Seguimientos seguiId;
    @JoinColumn(name = "proye_id", referencedColumnName = "proye_id")
    @ManyToOne(optional = false)
    private Proyectos proyeId;
    @JoinColumn(name = "asig_id", referencedColumnName = "asig_id")
    @ManyToOne(optional = false)
    private AsignaFacilitadores asigId;
    @JoinColumn(name = "apro_id", referencedColumnName = "apro_id")
    @ManyToOne(optional = false)
    private Aprobados aproId;

    public Documentos() {
    }

    public Documentos(Integer docuId) {
        this.docuId = docuId;
    }

    public Documentos(Integer docuId, String docuNombre) {
        this.docuId = docuId;
        this.docuNombre = docuNombre;
    }

    public Integer getDocuId() {
        return docuId;
    }

    public void setDocuId(Integer docuId) {
        this.docuId = docuId;
    }

    public String getDocuNombre() {
        return docuNombre;
    }

    public void setDocuNombre(String docuNombre) {
        this.docuNombre = docuNombre;
    }

    public String getDocuUrl() {
        return docuUrl;
    }

    public void setDocuUrl(String docuUrl) {
        this.docuUrl = docuUrl;
    }

    public Seguimientos getSeguiId() {
        return seguiId;
    }

    public void setSeguiId(Seguimientos seguiId) {
        this.seguiId = seguiId;
    }

    public Proyectos getProyeId() {
        return proyeId;
    }

    public void setProyeId(Proyectos proyeId) {
        this.proyeId = proyeId;
    }

    public AsignaFacilitadores getAsigId() {
        return asigId;
    }

    public void setAsigId(AsignaFacilitadores asigId) {
        this.asigId = asigId;
    }

    public Aprobados getAproId() {
        return aproId;
    }

    public void setAproId(Aprobados aproId) {
        this.aproId = aproId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docuId != null ? docuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.docuId == null && other.docuId != null) || (this.docuId != null && !this.docuId.equals(other.docuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Documentos[ docuId=" + docuId + " ]";
    }
    
}

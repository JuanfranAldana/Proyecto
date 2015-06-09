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
@Table(name = "aprobados")
@NamedQueries({
    @NamedQuery(name = "Aprobados.findAll", query = "SELECT a FROM Aprobados a"),
    @NamedQuery(name = "Aprobados.findByAproId", query = "SELECT a FROM Aprobados a WHERE a.aproId = :aproId"),
    @NamedQuery(name = "Aprobados.findByAproAutorizadoPor", query = "SELECT a FROM Aprobados a WHERE a.aproAutorizadoPor = :aproAutorizadoPor"),
    @NamedQuery(name = "Aprobados.findByAproMontosec", query = "SELECT a FROM Aprobados a WHERE a.aproMontosec = :aproMontosec"),
    @NamedQuery(name = "Aprobados.findByAproMontocontraparte", query = "SELECT a FROM Aprobados a WHERE a.aproMontocontraparte = :aproMontocontraparte"),
    @NamedQuery(name = "Aprobados.findByAproFechaAprueba", query = "SELECT a FROM Aprobados a WHERE a.aproFechaAprueba = :aproFechaAprueba"),
    @NamedQuery(name = "Aprobados.findByAproFechaObs", query = "SELECT a FROM Aprobados a WHERE a.aproFechaObs = :aproFechaObs"),
    @NamedQuery(name = "Aprobados.findByAproDescrObs", query = "SELECT a FROM Aprobados a WHERE a.aproDescrObs = :aproDescrObs"),
    @NamedQuery(name = "Aprobados.findByAproFinalizado", query = "SELECT a FROM Aprobados a WHERE a.aproFinalizado = :aproFinalizado")})
public class Aprobados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "apro_id")
    private Integer aproId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "apro_autorizado_por")
    private String aproAutorizadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apro_montosec")
    private double aproMontosec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apro_montocontraparte")
    private double aproMontocontraparte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apro_fecha_aprueba")
    @Temporal(TemporalType.DATE)
    private Date aproFechaAprueba;
    @Column(name = "apro_fecha_obs")
    @Temporal(TemporalType.DATE)
    private Date aproFechaObs;
    @Size(max = 500)
    @Column(name = "apro_descr_obs")
    private String aproDescrObs;
    @Size(max = 10)
    @Column(name = "apro_finalizado")
    private String aproFinalizado;
    @JoinColumn(name = "proye_id", referencedColumnName = "proye_id")
    @ManyToOne(optional = false)
    private Proyectos proyeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aproId")
    private List<Documentos> documentosList;

    public Aprobados() {
    }

    public Aprobados(Integer aproId) {
        this.aproId = aproId;
    }

    public Aprobados(Integer aproId, String aproAutorizadoPor, double aproMontosec, double aproMontocontraparte, Date aproFechaAprueba) {
        this.aproId = aproId;
        this.aproAutorizadoPor = aproAutorizadoPor;
        this.aproMontosec = aproMontosec;
        this.aproMontocontraparte = aproMontocontraparte;
        this.aproFechaAprueba = aproFechaAprueba;
    }

    public Integer getAproId() {
        return aproId;
    }

    public void setAproId(Integer aproId) {
        this.aproId = aproId;
    }

    public String getAproAutorizadoPor() {
        return aproAutorizadoPor;
    }

    public void setAproAutorizadoPor(String aproAutorizadoPor) {
        this.aproAutorizadoPor = aproAutorizadoPor;
    }

    public double getAproMontosec() {
        return aproMontosec;
    }

    public void setAproMontosec(double aproMontosec) {
        this.aproMontosec = aproMontosec;
    }

    public double getAproMontocontraparte() {
        return aproMontocontraparte;
    }

    public void setAproMontocontraparte(double aproMontocontraparte) {
        this.aproMontocontraparte = aproMontocontraparte;
    }

    public Date getAproFechaAprueba() {
        return aproFechaAprueba;
    }

    public void setAproFechaAprueba(Date aproFechaAprueba) {
        this.aproFechaAprueba = aproFechaAprueba;
    }

    public Date getAproFechaObs() {
        return aproFechaObs;
    }

    public void setAproFechaObs(Date aproFechaObs) {
        this.aproFechaObs = aproFechaObs;
    }

    public String getAproDescrObs() {
        return aproDescrObs;
    }

    public void setAproDescrObs(String aproDescrObs) {
        this.aproDescrObs = aproDescrObs;
    }

    public String getAproFinalizado() {
        return aproFinalizado;
    }

    public void setAproFinalizado(String aproFinalizado) {
        this.aproFinalizado = aproFinalizado;
    }

    public Proyectos getProyeId() {
        return proyeId;
    }

    public void setProyeId(Proyectos proyeId) {
        this.proyeId = proyeId;
    }

    public List<Documentos> getDocumentosList() {
        return documentosList;
    }

    public void setDocumentosList(List<Documentos> documentosList) {
        this.documentosList = documentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aproId != null ? aproId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprobados)) {
            return false;
        }
        Aprobados other = (Aprobados) object;
        if ((this.aproId == null && other.aproId != null) || (this.aproId != null && !this.aproId.equals(other.aproId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Aprobados[ aproId=" + aproId + " ]";
    }
    
}

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
@Table(name = "seguimientos")
@NamedQueries({
    @NamedQuery(name = "Seguimientos.findByProyecto", query = "SELECT r FROM Seguimientos r WHERE r.proyeId.proyeId = :proyectoId"),
    @NamedQuery(name = "Seguimientos.findAll", query = "SELECT s FROM Seguimientos s"),
    @NamedQuery(name = "Seguimientos.findBySeguiId", query = "SELECT s FROM Seguimientos s WHERE s.seguiId = :seguiId"),
    @NamedQuery(name = "Seguimientos.findBySeguiFechaIni", query = "SELECT s FROM Seguimientos s WHERE s.seguiFechaIni = :seguiFechaIni"),
    @NamedQuery(name = "Seguimientos.findBySeguiFechaFin", query = "SELECT s FROM Seguimientos s WHERE s.seguiFechaFin = :seguiFechaFin"),
    @NamedQuery(name = "Seguimientos.findBySeguiObserva", query = "SELECT s FROM Seguimientos s WHERE s.seguiObserva = :seguiObserva"),
    @NamedQuery(name = "Seguimientos.findBySeguiFechaObs", query = "SELECT s FROM Seguimientos s WHERE s.seguiFechaObs = :seguiFechaObs"),
    @NamedQuery(name = "Seguimientos.findBySeguiFechaAlerta", query = "SELECT s FROM Seguimientos s WHERE s.seguiFechaAlerta = :seguiFechaAlerta"),
    @NamedQuery(name = "Seguimientos.findBySeguiActiAlerta", query = "SELECT s FROM Seguimientos s WHERE s.seguiActiAlerta = :seguiActiAlerta"),
    @NamedQuery(name = "Seguimientos.findBySeguiAlerta", query = "SELECT s FROM Seguimientos s WHERE s.seguiAlerta = :seguiAlerta")})
public class Seguimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "segui_id")
    private Integer seguiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "segui_fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date seguiFechaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "segui_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date seguiFechaFin;
    @Size(max = 400)
    @Column(name = "segui_observa")
    private String seguiObserva;
    @Column(name = "segui_fecha_obs")
    @Temporal(TemporalType.DATE)
    private Date seguiFechaObs;
    @Column(name = "segui_fecha_alerta")
    @Temporal(TemporalType.DATE)
    private Date seguiFechaAlerta;
    @Column(name = "segui_acti_alerta")
    private Boolean seguiActiAlerta;
    @Column(name = "segui_alerta")
    private Integer seguiAlerta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguiId")
    private List<Documentos> documentosList;
    @JoinColumn(name = "proye_id", referencedColumnName = "proye_id")
    @ManyToOne(optional = false)
    private Proyectos proyeId;
    @JoinColumn(name = "catseg_id", referencedColumnName = "catseg_id")
    @ManyToOne(optional = false)
    private CategoriaSeguimientos catsegId;
    @OneToMany(mappedBy = "seguiId")
    private List<Alertas> alertasList;

    public Seguimientos() {
    }

    public Seguimientos(Integer seguiId) {
        this.seguiId = seguiId;
    }

    public Seguimientos(Integer seguiId, Date seguiFechaIni, Date seguiFechaFin) {
        this.seguiId = seguiId;
        this.seguiFechaIni = seguiFechaIni;
        this.seguiFechaFin = seguiFechaFin;
    }

    public Integer getSeguiId() {
        return seguiId;
    }

    public void setSeguiId(Integer seguiId) {
        this.seguiId = seguiId;
    }

    public Date getSeguiFechaIni() {
        return seguiFechaIni;
    }

    public void setSeguiFechaIni(Date seguiFechaIni) {
        this.seguiFechaIni = seguiFechaIni;
    }

    public Date getSeguiFechaFin() {
        return seguiFechaFin;
    }

    public void setSeguiFechaFin(Date seguiFechaFin) {
        this.seguiFechaFin = seguiFechaFin;
    }

    public String getSeguiObserva() {
        return seguiObserva;
    }

    public void setSeguiObserva(String seguiObserva) {
        this.seguiObserva = seguiObserva;
    }

    public Date getSeguiFechaObs() {
        return seguiFechaObs;
    }

    public void setSeguiFechaObs(Date seguiFechaObs) {
        this.seguiFechaObs = seguiFechaObs;
    }

    public Date getSeguiFechaAlerta() {
        return seguiFechaAlerta;
    }

    public void setSeguiFechaAlerta(Date seguiFechaAlerta) {
        this.seguiFechaAlerta = seguiFechaAlerta;
    }

    public Boolean getSeguiActiAlerta() {
        return seguiActiAlerta;
    }

    public void setSeguiActiAlerta(Boolean seguiActiAlerta) {
        this.seguiActiAlerta = seguiActiAlerta;
    }

    public Integer getSeguiAlerta() {
        return seguiAlerta;
    }

    public void setSeguiAlerta(Integer seguiAlerta) {
        this.seguiAlerta = seguiAlerta;
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

    public CategoriaSeguimientos getCatsegId() {
        return catsegId;
    }

    public void setCatsegId(CategoriaSeguimientos catsegId) {
        this.catsegId = catsegId;
    }

    public List<Alertas> getAlertasList() {
        return alertasList;
    }

    public void setAlertasList(List<Alertas> alertasList) {
        this.alertasList = alertasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguiId != null ? seguiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimientos)) {
            return false;
        }
        Seguimientos other = (Seguimientos) object;
        if ((this.seguiId == null && other.seguiId != null) || (this.seguiId != null && !this.seguiId.equals(other.seguiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Seguimientos[ seguiId=" + seguiId + " ]";
    }
    
}

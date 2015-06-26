/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FAMILIA ALDANA
 */
@Entity
@Table(name = "representantes")
@NamedQueries({
    //@NamedQuery(name = "Representantes.buscarRep", query = "SELECT r FROM Representantes r WHERE r.instId.repId =:repre"),
    @NamedQuery(name = "Representantes.findAll", query = "SELECT r FROM Representantes r"),
    @NamedQuery(name = "Representantes.findByRepId", query = "SELECT r FROM Representantes r WHERE r.repId = :repId"),
    @NamedQuery(name = "Representantes.findByRepNombre", query = "SELECT r FROM Representantes r WHERE r.repNombre = :repNombre"),
    @NamedQuery(name = "Representantes.findByRepCorreo", query = "SELECT r FROM Representantes r WHERE r.repCorreo = :repCorreo"),
    @NamedQuery(name = "Representantes.findByRepTelefono", query = "SELECT r FROM Representantes r WHERE r.repTelefono = :repTelefono"),
    @NamedQuery(name = "Representantes.findByRepActivo", query = "SELECT r FROM Representantes r WHERE r.repActivo = :repActivo"),
    @NamedQuery(name = "Representantes.findByRepFechaIngreso", query = "SELECT r FROM Representantes r WHERE r.repFechaIngreso = :repFechaIngreso"),
    @NamedQuery(name = "Representantes.findByRepDui", query = "SELECT r FROM Representantes r WHERE r.repDui = :repDui"),
    @NamedQuery(name = "Representantes.findByRepNit", query = "SELECT r FROM Representantes r WHERE r.repNit = :repNit"),
    @NamedQuery(name = "Representantes.findByRepNacionalidad", query = "SELECT r FROM Representantes r WHERE r.repNacionalidad = :repNacionalidad"),
    @NamedQuery(name = "Representantes.findByRepPasaporte", query = "SELECT r FROM Representantes r WHERE r.repPasaporte = :repPasaporte")})
public class Representantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rep_id")
    private Integer repId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rep_nombre")
    private String repNombre;
    @Size(max = 100)
    @Column(name = "rep_correo")
    private String repCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rep_telefono")
    private String repTelefono;
    @Column(name = "rep_activo")
    private Boolean repActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rep_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date repFechaIngreso;
    @Size(max = 12)
    @Column(name = "rep_dui")
    private String repDui;
    @Size(max = 16)
    @Column(name = "rep_nit")
    private String repNit;
    @Size(max = 50)
    @Column(name = "rep_nacionalidad")
    private String repNacionalidad;
    @Size(max = 15)
    @Column(name = "rep_pasaporte")
    private String repPasaporte;
    @JoinColumn(name = "inst_id", referencedColumnName = "inst_id")
    @ManyToOne(optional = false)
    private Instituciones instId;

    public Representantes() {
    }

    public Representantes(Integer repId) {
        this.repId = repId;
    }

    public Representantes(Integer repId, String repNombre, String repTelefono, Date repFechaIngreso) {
        this.repId = repId;
        this.repNombre = repNombre;
        this.repTelefono = repTelefono;
        this.repFechaIngreso = repFechaIngreso;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public String getRepNombre() {
        return repNombre;
    }

    public void setRepNombre(String repNombre) {
        this.repNombre = repNombre;
    }

    public String getRepCorreo() {
        return repCorreo;
    }

    public void setRepCorreo(String repCorreo) {
        this.repCorreo = repCorreo;
    }

    public String getRepTelefono() {
        return repTelefono;
    }

    public void setRepTelefono(String repTelefono) {
        this.repTelefono = repTelefono;
    }

    public Boolean getRepActivo() {
        return repActivo;
    }

    public void setRepActivo(Boolean repActivo) {
        this.repActivo = repActivo;
    }

    public Date getRepFechaIngreso() {
        return repFechaIngreso;
    }

    public void setRepFechaIngreso(Date repFechaIngreso) {
        this.repFechaIngreso = repFechaIngreso;
    }

    public String getRepDui() {
        return repDui;
    }

    public void setRepDui(String repDui) {
        this.repDui = repDui;
    }

    public String getRepNit() {
        return repNit;
    }

    public void setRepNit(String repNit) {
        this.repNit = repNit;
    }

    public String getRepNacionalidad() {
        return repNacionalidad;
    }

    public void setRepNacionalidad(String repNacionalidad) {
        this.repNacionalidad = repNacionalidad;
    }

    public String getRepPasaporte() {
        return repPasaporte;
    }

    public void setRepPasaporte(String repPasaporte) {
        this.repPasaporte = repPasaporte;
    }

    public Instituciones getInstId() {
        return instId;
    }

    public void setInstId(Instituciones instId) {
        this.instId = instId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repId != null ? repId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representantes)) {
            return false;
        }
        Representantes other = (Representantes) object;
        if ((this.repId == null && other.repId != null) || (this.repId != null && !this.repId.equals(other.repId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Representantes[ repId=" + repId + " ]";
    }
    
}

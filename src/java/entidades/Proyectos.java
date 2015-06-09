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
@Table(name = "proyectos")
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByProyeId", query = "SELECT p FROM Proyectos p WHERE p.proyeId = :proyeId"),
    @NamedQuery(name = "Proyectos.findByProyeNombre", query = "SELECT p FROM Proyectos p WHERE p.proyeNombre = :proyeNombre"),
    @NamedQuery(name = "Proyectos.findByProyeFechaIngreso", query = "SELECT p FROM Proyectos p WHERE p.proyeFechaIngreso = :proyeFechaIngreso"),
    @NamedQuery(name = "Proyectos.findByProyeFechaIni", query = "SELECT p FROM Proyectos p WHERE p.proyeFechaIni = :proyeFechaIni"),
    @NamedQuery(name = "Proyectos.findByProyeFechaFin", query = "SELECT p FROM Proyectos p WHERE p.proyeFechaFin = :proyeFechaFin"),
    @NamedQuery(name = "Proyectos.findByProyeObjetivo", query = "SELECT p FROM Proyectos p WHERE p.proyeObjetivo = :proyeObjetivo"),
    @NamedQuery(name = "Proyectos.findByProyeAlcance", query = "SELECT p FROM Proyectos p WHERE p.proyeAlcance = :proyeAlcance"),
    @NamedQuery(name = "Proyectos.findByProyeBeneficiados", query = "SELECT p FROM Proyectos p WHERE p.proyeBeneficiados = :proyeBeneficiados"),
    @NamedQuery(name = "Proyectos.findByProyeMontoSolicitado", query = "SELECT p FROM Proyectos p WHERE p.proyeMontoSolicitado = :proyeMontoSolicitado"),
    @NamedQuery(name = "Proyectos.findByProyeContactoInst", query = "SELECT p FROM Proyectos p WHERE p.proyeContactoInst = :proyeContactoInst"),
    @NamedQuery(name = "Proyectos.findByProyeCorreoContacto", query = "SELECT p FROM Proyectos p WHERE p.proyeCorreoContacto = :proyeCorreoContacto"),
    @NamedQuery(name = "Proyectos.findByProyeAnio", query = "SELECT p FROM Proyectos p WHERE p.proyeAnio = :proyeAnio"),
    @NamedQuery(name = "Proyectos.findByProyeDescripcion", query = "SELECT p FROM Proyectos p WHERE p.proyeDescripcion = :proyeDescripcion"),
    @NamedQuery(name = "Proyectos.findByProyeNumConvenio", query = "SELECT p FROM Proyectos p WHERE p.proyeNumConvenio = :proyeNumConvenio"),
    @NamedQuery(name = "Proyectos.findByProyeNum", query = "SELECT p FROM Proyectos p WHERE p.proyeNum = :proyeNum"),
    @NamedQuery(name = "Proyectos.findByProyeMontoContraparte", query = "SELECT p FROM Proyectos p WHERE p.proyeMontoContraparte = :proyeMontoContraparte")})
public class Proyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proye_id")
    private Integer proyeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "proye_nombre")
    private String proyeNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proye_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date proyeFechaIngreso;
    @Column(name = "proye_fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date proyeFechaIni;
    @Column(name = "proye_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date proyeFechaFin;
    @Size(max = 1024)
    @Column(name = "proye_objetivo")
    private String proyeObjetivo;
    @Size(max = 1024)
    @Column(name = "proye_alcance")
    private String proyeAlcance;
    @Size(max = 1024)
    @Column(name = "proye_beneficiados")
    private String proyeBeneficiados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "proye_monto_solicitado")
    private Double proyeMontoSolicitado;
    @Size(max = 100)
    @Column(name = "proye_contacto_inst")
    private String proyeContactoInst;
    @Size(max = 100)
    @Column(name = "proye_correo_contacto")
    private String proyeCorreoContacto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proye_anio")
    private int proyeAnio;
    @Size(max = 1024)
    @Column(name = "proye_descripcion")
    private String proyeDescripcion;
    @Size(max = 15)
    @Column(name = "proye_num_convenio")
    private String proyeNumConvenio;
    @Size(max = 10)
    @Column(name = "proye_num")
    private String proyeNum;
    @Column(name = "proye_monto_contraparte")
    private Double proyeMontoContraparte;
    @JoinColumn(name = "usuario_usuario", referencedColumnName = "usuario_usuario")
    @ManyToOne(optional = false)
    private Usuarios usuarioUsuario;
    @JoinColumn(name = "inst_id", referencedColumnName = "inst_id")
    @ManyToOne(optional = false)
    private Instituciones instId;
    @JoinColumn(name = "fuente_id", referencedColumnName = "fuente_id")
    @ManyToOne(optional = false)
    private FuentesFinanciamiento fuenteId;
    @JoinColumn(name = "estado_id", referencedColumnName = "estado_id")
    @ManyToOne(optional = false)
    private Estados estadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyeId")
    private List<Aprobados> aprobadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyeId")
    private List<Documentos> documentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyeId")
    private List<Seguimientos> seguimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyeId")
    private List<AsignaFacilitadores> asignaFacilitadoresList;
    @OneToMany(mappedBy = "proyeId")
    private List<Metas> metasList;

    public Proyectos() {
    }

    public Proyectos(Integer proyeId) {
        this.proyeId = proyeId;
    }

    public Proyectos(Integer proyeId, String proyeNombre, Date proyeFechaIngreso, int proyeAnio) {
        this.proyeId = proyeId;
        this.proyeNombre = proyeNombre;
        this.proyeFechaIngreso = proyeFechaIngreso;
        this.proyeAnio = proyeAnio;
    }

    public Integer getProyeId() {
        return proyeId;
    }

    public void setProyeId(Integer proyeId) {
        this.proyeId = proyeId;
    }

    public String getProyeNombre() {
        return proyeNombre;
    }

    public void setProyeNombre(String proyeNombre) {
        this.proyeNombre = proyeNombre;
    }

    public Date getProyeFechaIngreso() {
        return proyeFechaIngreso;
    }

    public void setProyeFechaIngreso(Date proyeFechaIngreso) {
        this.proyeFechaIngreso = proyeFechaIngreso;
    }

    public Date getProyeFechaIni() {
        return proyeFechaIni;
    }

    public void setProyeFechaIni(Date proyeFechaIni) {
        this.proyeFechaIni = proyeFechaIni;
    }

    public Date getProyeFechaFin() {
        return proyeFechaFin;
    }

    public void setProyeFechaFin(Date proyeFechaFin) {
        this.proyeFechaFin = proyeFechaFin;
    }

    public String getProyeObjetivo() {
        return proyeObjetivo;
    }

    public void setProyeObjetivo(String proyeObjetivo) {
        this.proyeObjetivo = proyeObjetivo;
    }

    public String getProyeAlcance() {
        return proyeAlcance;
    }

    public void setProyeAlcance(String proyeAlcance) {
        this.proyeAlcance = proyeAlcance;
    }

    public String getProyeBeneficiados() {
        return proyeBeneficiados;
    }

    public void setProyeBeneficiados(String proyeBeneficiados) {
        this.proyeBeneficiados = proyeBeneficiados;
    }

    public Double getProyeMontoSolicitado() {
        return proyeMontoSolicitado;
    }

    public void setProyeMontoSolicitado(Double proyeMontoSolicitado) {
        this.proyeMontoSolicitado = proyeMontoSolicitado;
    }

    public String getProyeContactoInst() {
        return proyeContactoInst;
    }

    public void setProyeContactoInst(String proyeContactoInst) {
        this.proyeContactoInst = proyeContactoInst;
    }

    public String getProyeCorreoContacto() {
        return proyeCorreoContacto;
    }

    public void setProyeCorreoContacto(String proyeCorreoContacto) {
        this.proyeCorreoContacto = proyeCorreoContacto;
    }

    public int getProyeAnio() {
        return proyeAnio;
    }

    public void setProyeAnio(int proyeAnio) {
        this.proyeAnio = proyeAnio;
    }

    public String getProyeDescripcion() {
        return proyeDescripcion;
    }

    public void setProyeDescripcion(String proyeDescripcion) {
        this.proyeDescripcion = proyeDescripcion;
    }

    public String getProyeNumConvenio() {
        return proyeNumConvenio;
    }

    public void setProyeNumConvenio(String proyeNumConvenio) {
        this.proyeNumConvenio = proyeNumConvenio;
    }

    public String getProyeNum() {
        return proyeNum;
    }

    public void setProyeNum(String proyeNum) {
        this.proyeNum = proyeNum;
    }

    public Double getProyeMontoContraparte() {
        return proyeMontoContraparte;
    }

    public void setProyeMontoContraparte(Double proyeMontoContraparte) {
        this.proyeMontoContraparte = proyeMontoContraparte;
    }

    public Usuarios getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public void setUsuarioUsuario(Usuarios usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public Instituciones getInstId() {
        return instId;
    }

    public void setInstId(Instituciones instId) {
        this.instId = instId;
    }

    public FuentesFinanciamiento getFuenteId() {
        return fuenteId;
    }

    public void setFuenteId(FuentesFinanciamiento fuenteId) {
        this.fuenteId = fuenteId;
    }

    public Estados getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estados estadoId) {
        this.estadoId = estadoId;
    }

    public List<Aprobados> getAprobadosList() {
        return aprobadosList;
    }

    public void setAprobadosList(List<Aprobados> aprobadosList) {
        this.aprobadosList = aprobadosList;
    }

    public List<Documentos> getDocumentosList() {
        return documentosList;
    }

    public void setDocumentosList(List<Documentos> documentosList) {
        this.documentosList = documentosList;
    }

    public List<Seguimientos> getSeguimientosList() {
        return seguimientosList;
    }

    public void setSeguimientosList(List<Seguimientos> seguimientosList) {
        this.seguimientosList = seguimientosList;
    }

    public List<AsignaFacilitadores> getAsignaFacilitadoresList() {
        return asignaFacilitadoresList;
    }

    public void setAsignaFacilitadoresList(List<AsignaFacilitadores> asignaFacilitadoresList) {
        this.asignaFacilitadoresList = asignaFacilitadoresList;
    }

    public List<Metas> getMetasList() {
        return metasList;
    }

    public void setMetasList(List<Metas> metasList) {
        this.metasList = metasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyeId != null ? proyeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.proyeId == null && other.proyeId != null) || (this.proyeId != null && !this.proyeId.equals(other.proyeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Proyectos[ proyeId=" + proyeId + " ]";
    }
    
}

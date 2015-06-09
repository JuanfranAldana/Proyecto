/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FAMILIA ALDANA
 */
@Entity
@Table(name = "facilitadores_tecnicos")
@NamedQueries({
    @NamedQuery(name = "FacilitadoresTecnicos.findAll", query = "SELECT f FROM FacilitadoresTecnicos f"),
    @NamedQuery(name = "FacilitadoresTecnicos.findByFaciId", query = "SELECT f FROM FacilitadoresTecnicos f WHERE f.faciId = :faciId"),
    @NamedQuery(name = "FacilitadoresTecnicos.findByFaciNombre", query = "SELECT f FROM FacilitadoresTecnicos f WHERE f.faciNombre = :faciNombre"),
    @NamedQuery(name = "FacilitadoresTecnicos.findByFaciCorreo", query = "SELECT f FROM FacilitadoresTecnicos f WHERE f.faciCorreo = :faciCorreo"),
    @NamedQuery(name = "FacilitadoresTecnicos.findByFaciTelefono", query = "SELECT f FROM FacilitadoresTecnicos f WHERE f.faciTelefono = :faciTelefono"),
    @NamedQuery(name = "FacilitadoresTecnicos.findByFaciDescripcion", query = "SELECT f FROM FacilitadoresTecnicos f WHERE f.faciDescripcion = :faciDescripcion"),
    @NamedQuery(name = "FacilitadoresTecnicos.findByFaciCargo", query = "SELECT f FROM FacilitadoresTecnicos f WHERE f.faciCargo = :faciCargo")})
public class FacilitadoresTecnicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "faci_id")
    private Integer faciId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "faci_nombre")
    private String faciNombre;
    @Size(max = 100)
    @Column(name = "faci_correo")
    private String faciCorreo;
    @Size(max = 10)
    @Column(name = "faci_telefono")
    private String faciTelefono;
    @Size(max = 500)
    @Column(name = "faci_descripcion")
    private String faciDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "faci_cargo")
    private String faciCargo;
    @OneToMany(mappedBy = "faciId")
    private List<AsignaFacilitadores> asignaFacilitadoresList;
    @JoinColumn(name = "utec_id", referencedColumnName = "utec_id")
    @ManyToOne(optional = false)
    private UnidadesTecnicas utecId;
    @JoinColumn(name = "tipof_id", referencedColumnName = "tipof_id")
    @ManyToOne(optional = false)
    private TiposFacilitadores tipofId;
    @JoinColumn(name = "inst_id", referencedColumnName = "inst_id")
    @ManyToOne
    private Instituciones instId;

    public FacilitadoresTecnicos() {
    }

    public FacilitadoresTecnicos(Integer faciId) {
        this.faciId = faciId;
    }

    public FacilitadoresTecnicos(Integer faciId, String faciNombre, String faciCargo) {
        this.faciId = faciId;
        this.faciNombre = faciNombre;
        this.faciCargo = faciCargo;
    }

    public Integer getFaciId() {
        return faciId;
    }

    public void setFaciId(Integer faciId) {
        this.faciId = faciId;
    }

    public String getFaciNombre() {
        return faciNombre;
    }

    public void setFaciNombre(String faciNombre) {
        this.faciNombre = faciNombre;
    }

    public String getFaciCorreo() {
        return faciCorreo;
    }

    public void setFaciCorreo(String faciCorreo) {
        this.faciCorreo = faciCorreo;
    }

    public String getFaciTelefono() {
        return faciTelefono;
    }

    public void setFaciTelefono(String faciTelefono) {
        this.faciTelefono = faciTelefono;
    }

    public String getFaciDescripcion() {
        return faciDescripcion;
    }

    public void setFaciDescripcion(String faciDescripcion) {
        this.faciDescripcion = faciDescripcion;
    }

    public String getFaciCargo() {
        return faciCargo;
    }

    public void setFaciCargo(String faciCargo) {
        this.faciCargo = faciCargo;
    }

    public List<AsignaFacilitadores> getAsignaFacilitadoresList() {
        return asignaFacilitadoresList;
    }

    public void setAsignaFacilitadoresList(List<AsignaFacilitadores> asignaFacilitadoresList) {
        this.asignaFacilitadoresList = asignaFacilitadoresList;
    }

    public UnidadesTecnicas getUtecId() {
        return utecId;
    }

    public void setUtecId(UnidadesTecnicas utecId) {
        this.utecId = utecId;
    }

    public TiposFacilitadores getTipofId() {
        return tipofId;
    }

    public void setTipofId(TiposFacilitadores tipofId) {
        this.tipofId = tipofId;
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
        hash += (faciId != null ? faciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacilitadoresTecnicos)) {
            return false;
        }
        FacilitadoresTecnicos other = (FacilitadoresTecnicos) object;
        if ((this.faciId == null && other.faciId != null) || (this.faciId != null && !this.faciId.equals(other.faciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FacilitadoresTecnicos[ faciId=" + faciId + " ]";
    }
    
}

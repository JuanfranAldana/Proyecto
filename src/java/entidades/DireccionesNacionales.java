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
@Table(name = "direcciones_nacionales")
@NamedQueries({
    @NamedQuery(name = "DireccionesNacionales.findAll", query = "SELECT d FROM DireccionesNacionales d"),
    @NamedQuery(name = "DireccionesNacionales.findByDnacId", query = "SELECT d FROM DireccionesNacionales d WHERE d.dnacId = :dnacId"),
    @NamedQuery(name = "DireccionesNacionales.findByDnacNombre", query = "SELECT d FROM DireccionesNacionales d WHERE d.dnacNombre = :dnacNombre"),
    @NamedQuery(name = "DireccionesNacionales.findByDnacDirector", query = "SELECT d FROM DireccionesNacionales d WHERE d.dnacDirector = :dnacDirector"),
    @NamedQuery(name = "DireccionesNacionales.findByDnacCorreoDir", query = "SELECT d FROM DireccionesNacionales d WHERE d.dnacCorreoDir = :dnacCorreoDir"),
    @NamedQuery(name = "DireccionesNacionales.findByDnacTelefono", query = "SELECT d FROM DireccionesNacionales d WHERE d.dnacTelefono = :dnacTelefono"),
    @NamedQuery(name = "DireccionesNacionales.findByDnacDescripcion", query = "SELECT d FROM DireccionesNacionales d WHERE d.dnacDescripcion = :dnacDescripcion")})
public class DireccionesNacionales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dnac_id")
    private Integer dnacId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dnac_nombre")
    private String dnacNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dnac_director")
    private String dnacDirector;
    @Size(max = 100)
    @Column(name = "dnac_correo_dir")
    private String dnacCorreoDir;
    @Size(max = 10)
    @Column(name = "dnac_telefono")
    private String dnacTelefono;
    @Size(max = 500)
    @Column(name = "dnac_descripcion")
    private String dnacDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dnacId")
    private List<UnidadesTecnicas> unidadesTecnicasList;
    @OneToMany(mappedBy = "dnacId")
    private List<Historicos> historicosList;

    public DireccionesNacionales() {
    }

    public DireccionesNacionales(Integer dnacId) {
        this.dnacId = dnacId;
    }

    public DireccionesNacionales(Integer dnacId, String dnacNombre, String dnacDirector) {
        this.dnacId = dnacId;
        this.dnacNombre = dnacNombre;
        this.dnacDirector = dnacDirector;
    }

    public Integer getDnacId() {
        return dnacId;
    }

    public void setDnacId(Integer dnacId) {
        this.dnacId = dnacId;
    }

    public String getDnacNombre() {
        return dnacNombre;
    }

    public void setDnacNombre(String dnacNombre) {
        this.dnacNombre = dnacNombre;
    }

    public String getDnacDirector() {
        return dnacDirector;
    }

    public void setDnacDirector(String dnacDirector) {
        this.dnacDirector = dnacDirector;
    }

    public String getDnacCorreoDir() {
        return dnacCorreoDir;
    }

    public void setDnacCorreoDir(String dnacCorreoDir) {
        this.dnacCorreoDir = dnacCorreoDir;
    }

    public String getDnacTelefono() {
        return dnacTelefono;
    }

    public void setDnacTelefono(String dnacTelefono) {
        this.dnacTelefono = dnacTelefono;
    }

    public String getDnacDescripcion() {
        return dnacDescripcion;
    }

    public void setDnacDescripcion(String dnacDescripcion) {
        this.dnacDescripcion = dnacDescripcion;
    }

    public List<UnidadesTecnicas> getUnidadesTecnicasList() {
        return unidadesTecnicasList;
    }

    public void setUnidadesTecnicasList(List<UnidadesTecnicas> unidadesTecnicasList) {
        this.unidadesTecnicasList = unidadesTecnicasList;
    }

    public List<Historicos> getHistoricosList() {
        return historicosList;
    }

    public void setHistoricosList(List<Historicos> historicosList) {
        this.historicosList = historicosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnacId != null ? dnacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionesNacionales)) {
            return false;
        }
        DireccionesNacionales other = (DireccionesNacionales) object;
        if ((this.dnacId == null && other.dnacId != null) || (this.dnacId != null && !this.dnacId.equals(other.dnacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DireccionesNacionales[ dnacId=" + dnacId + " ]";
    }
    
}

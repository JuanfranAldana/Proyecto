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
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "meses")
@NamedQueries({
    @NamedQuery(name = "Meses.findAll", query = "SELECT m FROM Meses m"),
    @NamedQuery(name = "Meses.findByMesId", query = "SELECT m FROM Meses m WHERE m.mesId = :mesId"),
    @NamedQuery(name = "Meses.findByMesNombre", query = "SELECT m FROM Meses m WHERE m.mesNombre = :mesNombre")})
public class Meses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes_id")
    private Integer mesId;
    @Size(max = 25)
    @Column(name = "mes_nombre")
    private String mesNombre;
    @ManyToMany(mappedBy = "mesesList")
    private List<Actividades> actividadesList;

    public Meses() {
    }

    public Meses(Integer mesId) {
        this.mesId = mesId;
    }

    public Integer getMesId() {
        return mesId;
    }

    public void setMesId(Integer mesId) {
        this.mesId = mesId;
    }

    public String getMesNombre() {
        return mesNombre;
    }

    public void setMesNombre(String mesNombre) {
        this.mesNombre = mesNombre;
    }

    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mesId != null ? mesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meses)) {
            return false;
        }
        Meses other = (Meses) object;
        if ((this.mesId == null && other.mesId != null) || (this.mesId != null && !this.mesId.equals(other.mesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Meses[ mesId=" + mesId + " ]";
    }
    
}

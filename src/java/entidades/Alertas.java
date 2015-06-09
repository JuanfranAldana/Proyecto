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
@Table(name = "alertas")
@NamedQueries({
    @NamedQuery(name = "Alertas.findAll", query = "SELECT a FROM Alertas a"),
    @NamedQuery(name = "Alertas.findByAlerId", query = "SELECT a FROM Alertas a WHERE a.alerId = :alerId"),
    @NamedQuery(name = "Alertas.findByAlerMensaje", query = "SELECT a FROM Alertas a WHERE a.alerMensaje = :alerMensaje")})
public class Alertas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aler_id")
    private Integer alerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "aler_mensaje")
    private String alerMensaje;
    @JoinColumn(name = "segui_id", referencedColumnName = "segui_id")
    @ManyToOne
    private Seguimientos seguiId;

    public Alertas() {
    }

    public Alertas(Integer alerId) {
        this.alerId = alerId;
    }

    public Alertas(Integer alerId, String alerMensaje) {
        this.alerId = alerId;
        this.alerMensaje = alerMensaje;
    }

    public Integer getAlerId() {
        return alerId;
    }

    public void setAlerId(Integer alerId) {
        this.alerId = alerId;
    }

    public String getAlerMensaje() {
        return alerMensaje;
    }

    public void setAlerMensaje(String alerMensaje) {
        this.alerMensaje = alerMensaje;
    }

    public Seguimientos getSeguiId() {
        return seguiId;
    }

    public void setSeguiId(Seguimientos seguiId) {
        this.seguiId = seguiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alerId != null ? alerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alertas)) {
            return false;
        }
        Alertas other = (Alertas) object;
        if ((this.alerId == null && other.alerId != null) || (this.alerId != null && !this.alerId.equals(other.alerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Alertas[ alerId=" + alerId + " ]";
    }
    
}

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
@Table(name = "movimientos")
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m"),
    @NamedQuery(name = "Movimientos.findByMoviId", query = "SELECT m FROM Movimientos m WHERE m.moviId = :moviId"),
    @NamedQuery(name = "Movimientos.findByMoviTipo", query = "SELECT m FROM Movimientos m WHERE m.moviTipo = :moviTipo"),
    @NamedQuery(name = "Movimientos.findByMoviUser", query = "SELECT m FROM Movimientos m WHERE m.moviUser = :moviUser"),
    @NamedQuery(name = "Movimientos.findByMoviFecha", query = "SELECT m FROM Movimientos m WHERE m.moviFecha = :moviFecha"),
    @NamedQuery(name = "Movimientos.findByMoviHora", query = "SELECT m FROM Movimientos m WHERE m.moviHora = :moviHora"),
    @NamedQuery(name = "Movimientos.findByMoviTabla", query = "SELECT m FROM Movimientos m WHERE m.moviTabla = :moviTabla")})
public class Movimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movi_id")
    private Integer moviId;
    @Size(max = 100)
    @Column(name = "movi_tipo")
    private String moviTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "movi_user")
    private String moviUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movi_fecha")
    @Temporal(TemporalType.DATE)
    private Date moviFecha;
    @Column(name = "movi_hora")
    @Temporal(TemporalType.TIME)
    private Date moviHora;
    @Size(max = 25)
    @Column(name = "movi_tabla")
    private String moviTabla;

    public Movimientos() {
    }

    public Movimientos(Integer moviId) {
        this.moviId = moviId;
    }

    public Movimientos(Integer moviId, String moviUser, Date moviFecha) {
        this.moviId = moviId;
        this.moviUser = moviUser;
        this.moviFecha = moviFecha;
    }

    public Integer getMoviId() {
        return moviId;
    }

    public void setMoviId(Integer moviId) {
        this.moviId = moviId;
    }

    public String getMoviTipo() {
        return moviTipo;
    }

    public void setMoviTipo(String moviTipo) {
        this.moviTipo = moviTipo;
    }

    public String getMoviUser() {
        return moviUser;
    }

    public void setMoviUser(String moviUser) {
        this.moviUser = moviUser;
    }

    public Date getMoviFecha() {
        return moviFecha;
    }

    public void setMoviFecha(Date moviFecha) {
        this.moviFecha = moviFecha;
    }

    public Date getMoviHora() {
        return moviHora;
    }

    public void setMoviHora(Date moviHora) {
        this.moviHora = moviHora;
    }

    public String getMoviTabla() {
        return moviTabla;
    }

    public void setMoviTabla(String moviTabla) {
        this.moviTabla = moviTabla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviId != null ? moviId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.moviId == null && other.moviId != null) || (this.moviId != null && !this.moviId.equals(other.moviId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Movimientos[ moviId=" + moviId + " ]";
    }
    
}

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
@Table(name = "sub_catseguimientos")
@NamedQueries({
    @NamedQuery(name = "SubCatseguimientos.findAll", query = "SELECT s FROM SubCatseguimientos s"),
    @NamedQuery(name = "SubCatseguimientos.findBySubcatId", query = "SELECT s FROM SubCatseguimientos s WHERE s.subcatId = :subcatId"),
    @NamedQuery(name = "SubCatseguimientos.findBySubcatNombre", query = "SELECT s FROM SubCatseguimientos s WHERE s.subcatNombre = :subcatNombre"),
    @NamedQuery(name = "SubCatseguimientos.findBySubcatDuracion", query = "SELECT s FROM SubCatseguimientos s WHERE s.subcatDuracion = :subcatDuracion")})
public class SubCatseguimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subcat_id")
    private Integer subcatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "subcat_nombre")
    private String subcatNombre;
    @Size(max = 10)
    @Column(name = "subcat_duracion")
    private String subcatDuracion;
    @JoinColumn(name = "catseg_id", referencedColumnName = "catseg_id")
    @ManyToOne(optional = false)
    private CategoriaSeguimientos catsegId;

    public SubCatseguimientos() {
    }

    public SubCatseguimientos(Integer subcatId) {
        this.subcatId = subcatId;
    }

    public SubCatseguimientos(Integer subcatId, String subcatNombre) {
        this.subcatId = subcatId;
        this.subcatNombre = subcatNombre;
    }

    public Integer getSubcatId() {
        return subcatId;
    }

    public void setSubcatId(Integer subcatId) {
        this.subcatId = subcatId;
    }

    public String getSubcatNombre() {
        return subcatNombre;
    }

    public void setSubcatNombre(String subcatNombre) {
        this.subcatNombre = subcatNombre;
    }

    public String getSubcatDuracion() {
        return subcatDuracion;
    }

    public void setSubcatDuracion(String subcatDuracion) {
        this.subcatDuracion = subcatDuracion;
    }

    public CategoriaSeguimientos getCatsegId() {
        return catsegId;
    }

    public void setCatsegId(CategoriaSeguimientos catsegId) {
        this.catsegId = catsegId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subcatId != null ? subcatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCatseguimientos)) {
            return false;
        }
        SubCatseguimientos other = (SubCatseguimientos) object;
        if ((this.subcatId == null && other.subcatId != null) || (this.subcatId != null && !this.subcatId.equals(other.subcatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.SubCatseguimientos[ subcatId=" + subcatId + " ]";
    }
    
}

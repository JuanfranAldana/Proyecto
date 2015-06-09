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
@Table(name = "historicos")
@NamedQueries({
    @NamedQuery(name = "Historicos.findAll", query = "SELECT h FROM Historicos h"),
    @NamedQuery(name = "Historicos.findByHistoId", query = "SELECT h FROM Historicos h WHERE h.histoId = :histoId"),
    @NamedQuery(name = "Historicos.findByHistoProyecto", query = "SELECT h FROM Historicos h WHERE h.histoProyecto = :histoProyecto"),
    @NamedQuery(name = "Historicos.findByHistoAno", query = "SELECT h FROM Historicos h WHERE h.histoAno = :histoAno"),
    @NamedQuery(name = "Historicos.findByHistoMonto", query = "SELECT h FROM Historicos h WHERE h.histoMonto = :histoMonto"),
    @NamedQuery(name = "Historicos.findByHistoNotas", query = "SELECT h FROM Historicos h WHERE h.histoNotas = :histoNotas")})
public class Historicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "histo_id")
    private Integer histoId;
    @Size(max = 500)
    @Column(name = "histo_proyecto")
    private String histoProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "histo_ano")
    private int histoAno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "histo_monto")
    private double histoMonto;
    @Size(max = 1000)
    @Column(name = "histo_notas")
    private String histoNotas;
    @JoinColumn(name = "inst_id", referencedColumnName = "inst_id")
    @ManyToOne(optional = false)
    private Instituciones instId;
    @JoinColumn(name = "dnac_id", referencedColumnName = "dnac_id")
    @ManyToOne
    private DireccionesNacionales dnacId;

    public Historicos() {
    }

    public Historicos(Integer histoId) {
        this.histoId = histoId;
    }

    public Historicos(Integer histoId, int histoAno, double histoMonto) {
        this.histoId = histoId;
        this.histoAno = histoAno;
        this.histoMonto = histoMonto;
    }

    public Integer getHistoId() {
        return histoId;
    }

    public void setHistoId(Integer histoId) {
        this.histoId = histoId;
    }

    public String getHistoProyecto() {
        return histoProyecto;
    }

    public void setHistoProyecto(String histoProyecto) {
        this.histoProyecto = histoProyecto;
    }

    public int getHistoAno() {
        return histoAno;
    }

    public void setHistoAno(int histoAno) {
        this.histoAno = histoAno;
    }

    public double getHistoMonto() {
        return histoMonto;
    }

    public void setHistoMonto(double histoMonto) {
        this.histoMonto = histoMonto;
    }

    public String getHistoNotas() {
        return histoNotas;
    }

    public void setHistoNotas(String histoNotas) {
        this.histoNotas = histoNotas;
    }

    public Instituciones getInstId() {
        return instId;
    }

    public void setInstId(Instituciones instId) {
        this.instId = instId;
    }

    public DireccionesNacionales getDnacId() {
        return dnacId;
    }

    public void setDnacId(DireccionesNacionales dnacId) {
        this.dnacId = dnacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histoId != null ? histoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historicos)) {
            return false;
        }
        Historicos other = (Historicos) object;
        if ((this.histoId == null && other.histoId != null) || (this.histoId != null && !this.histoId.equals(other.histoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Historicos[ histoId=" + histoId + " ]";
    }
    
}

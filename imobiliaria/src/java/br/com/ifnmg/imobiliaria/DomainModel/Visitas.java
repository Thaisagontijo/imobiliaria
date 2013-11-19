/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

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

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "visitas")
@NamedQueries({
    @NamedQuery(name = "Visitas.findAll", query = "SELECT v FROM Visitas v"),
    @NamedQuery(name = "Visitas.findByIdVisitas", query = "SELECT v FROM Visitas v WHERE v.idVisitas = :idVisitas"),
    @NamedQuery(name = "Visitas.findByDataHora", query = "SELECT v FROM Visitas v WHERE v.dataHora = :dataHora"),
    @NamedQuery(name = "Visitas.findByStatus", query = "SELECT v FROM Visitas v WHERE v.status = :status"),
    @NamedQuery(name = "Visitas.findByDataRegistro", query = "SELECT v FROM Visitas v WHERE v.dataRegistro = :dataRegistro")})
public class Visitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVisitas")
    private Integer idVisitas;
    @Column(name = "dataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "dataRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;
    @JoinColumn(name = "idClientes", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private Clientes idClientes;

    public Visitas() {
    }

    public Visitas(Integer idVisitas) {
        this.idVisitas = idVisitas;
    }

    public Integer getIdVisitas() {
        return idVisitas;
    }

    public void setIdVisitas(Integer idVisitas) {
        this.idVisitas = idVisitas;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Clientes getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Clientes idClientes) {
        this.idClientes = idClientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisitas != null ? idVisitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitas)) {
            return false;
        }
        Visitas other = (Visitas) object;
        if ((this.idVisitas == null && other.idVisitas != null) || (this.idVisitas != null && !this.idVisitas.equals(other.idVisitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Visitas[ idVisitas=" + idVisitas + " ]";
    }
    
}

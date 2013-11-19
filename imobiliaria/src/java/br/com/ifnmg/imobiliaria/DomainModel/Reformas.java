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
import javax.validation.constraints.Size;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "reformas")
@NamedQueries({
    @NamedQuery(name = "Reformas.findAll", query = "SELECT r FROM Reformas r"),
    @NamedQuery(name = "Reformas.findByIdReformas", query = "SELECT r FROM Reformas r WHERE r.idReformas = :idReformas"),
    @NamedQuery(name = "Reformas.findByDataInicio", query = "SELECT r FROM Reformas r WHERE r.dataInicio = :dataInicio"),
    @NamedQuery(name = "Reformas.findByDataTermino", query = "SELECT r FROM Reformas r WHERE r.dataTermino = :dataTermino"),
    @NamedQuery(name = "Reformas.findByValor", query = "SELECT r FROM Reformas r WHERE r.valor = :valor"),
    @NamedQuery(name = "Reformas.findByObservacoes", query = "SELECT r FROM Reformas r WHERE r.observacoes = :observacoes"),
    @NamedQuery(name = "Reformas.findByStatus", query = "SELECT r FROM Reformas r WHERE r.status = :status")})
public class Reformas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReformas")
    private Integer idReformas;
    @Column(name = "dataInicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "dataTermino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Size(max = 200)
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "idImoveis", referencedColumnName = "idImoveis")
    @ManyToOne(optional = false)
    private Imoveis idImoveis;

    public Reformas() {
    }

    public Reformas(Integer idReformas) {
        this.idReformas = idReformas;
    }

    public Integer getIdReformas() {
        return idReformas;
    }

    public void setIdReformas(Integer idReformas) {
        this.idReformas = idReformas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Imoveis getIdImoveis() {
        return idImoveis;
    }

    public void setIdImoveis(Imoveis idImoveis) {
        this.idImoveis = idImoveis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReformas != null ? idReformas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reformas)) {
            return false;
        }
        Reformas other = (Reformas) object;
        if ((this.idReformas == null && other.idReformas != null) || (this.idReformas != null && !this.idReformas.equals(other.idReformas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Reformas[ idReformas=" + idReformas + " ]";
    }
    
}

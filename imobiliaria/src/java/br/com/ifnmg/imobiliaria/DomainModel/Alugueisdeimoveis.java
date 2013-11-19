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
@Table(name = "alugueisdeimoveis")
@NamedQueries({
    @NamedQuery(name = "Alugueisdeimoveis.findAll", query = "SELECT a FROM Alugueisdeimoveis a"),
    @NamedQuery(name = "Alugueisdeimoveis.findByIdAlugueisDeImoveis", query = "SELECT a FROM Alugueisdeimoveis a WHERE a.idAlugueisDeImoveis = :idAlugueisDeImoveis"),
    @NamedQuery(name = "Alugueisdeimoveis.findByDataInicio", query = "SELECT a FROM Alugueisdeimoveis a WHERE a.dataInicio = :dataInicio"),
    @NamedQuery(name = "Alugueisdeimoveis.findByDataTermino", query = "SELECT a FROM Alugueisdeimoveis a WHERE a.dataTermino = :dataTermino"),
    @NamedQuery(name = "Alugueisdeimoveis.findByDataRegistro", query = "SELECT a FROM Alugueisdeimoveis a WHERE a.dataRegistro = :dataRegistro"),
    @NamedQuery(name = "Alugueisdeimoveis.findByObservacoes", query = "SELECT a FROM Alugueisdeimoveis a WHERE a.observacoes = :observacoes"),
    @NamedQuery(name = "Alugueisdeimoveis.findByStatus", query = "SELECT a FROM Alugueisdeimoveis a WHERE a.status = :status"),
    @NamedQuery(name = "Alugueisdeimoveis.findByPercentualComissao", query = "SELECT a FROM Alugueisdeimoveis a WHERE a.percentualComissao = :percentualComissao")})
public class Alugueisdeimoveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlugueisDeImoveis")
    private Integer idAlugueisDeImoveis;
    @Column(name = "dataInicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "dataTermino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @Column(name = "dataRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;
    @Size(max = 200)
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "status")
    private Boolean status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentualComissao")
    private Float percentualComissao;
    @JoinColumn(name = "idImoveis", referencedColumnName = "idImoveis")
    @ManyToOne(optional = false)
    private Imoveis idImoveis;
    @JoinColumn(name = "idFuncionarios", referencedColumnName = "idFuncionarios")
    @ManyToOne(optional = false)
    private Funcionarios idFuncionarios;
    @JoinColumn(name = "idClientes", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private Clientes idClientes;
    @JoinColumn(name = "idFormasDePagamento", referencedColumnName = "idFormasDePagamento")
    @ManyToOne(optional = false)
    private Formasdepagamento idFormasDePagamento;

    public Alugueisdeimoveis() {
    }

    public Alugueisdeimoveis(Integer idAlugueisDeImoveis) {
        this.idAlugueisDeImoveis = idAlugueisDeImoveis;
    }

    public Integer getIdAlugueisDeImoveis() {
        return idAlugueisDeImoveis;
    }

    public void setIdAlugueisDeImoveis(Integer idAlugueisDeImoveis) {
        this.idAlugueisDeImoveis = idAlugueisDeImoveis;
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

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
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

    public Float getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Float percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public Imoveis getIdImoveis() {
        return idImoveis;
    }

    public void setIdImoveis(Imoveis idImoveis) {
        this.idImoveis = idImoveis;
    }

    public Funcionarios getIdFuncionarios() {
        return idFuncionarios;
    }

    public void setIdFuncionarios(Funcionarios idFuncionarios) {
        this.idFuncionarios = idFuncionarios;
    }

    public Clientes getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Clientes idClientes) {
        this.idClientes = idClientes;
    }

    public Formasdepagamento getIdFormasDePagamento() {
        return idFormasDePagamento;
    }

    public void setIdFormasDePagamento(Formasdepagamento idFormasDePagamento) {
        this.idFormasDePagamento = idFormasDePagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlugueisDeImoveis != null ? idAlugueisDeImoveis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alugueisdeimoveis)) {
            return false;
        }
        Alugueisdeimoveis other = (Alugueisdeimoveis) object;
        if ((this.idAlugueisDeImoveis == null && other.idAlugueisDeImoveis != null) || (this.idAlugueisDeImoveis != null && !this.idAlugueisDeImoveis.equals(other.idAlugueisDeImoveis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Alugueisdeimoveis[ idAlugueisDeImoveis=" + idAlugueisDeImoveis + " ]";
    }
    
}

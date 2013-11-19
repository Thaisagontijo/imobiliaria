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
@Table(name = "vendadeimoveis")
@NamedQueries({
    @NamedQuery(name = "Vendadeimoveis.findAll", query = "SELECT v FROM Vendadeimoveis v"),
    @NamedQuery(name = "Vendadeimoveis.findByIdVendaDeImoveis", query = "SELECT v FROM Vendadeimoveis v WHERE v.idVendaDeImoveis = :idVendaDeImoveis"),
    @NamedQuery(name = "Vendadeimoveis.findByDataVenda", query = "SELECT v FROM Vendadeimoveis v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Vendadeimoveis.findByDataRegistro", query = "SELECT v FROM Vendadeimoveis v WHERE v.dataRegistro = :dataRegistro"),
    @NamedQuery(name = "Vendadeimoveis.findByObservacoes", query = "SELECT v FROM Vendadeimoveis v WHERE v.observacoes = :observacoes"),
    @NamedQuery(name = "Vendadeimoveis.findByPercentualComissao", query = "SELECT v FROM Vendadeimoveis v WHERE v.percentualComissao = :percentualComissao")})
public class Vendadeimoveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVendaDeImoveis")
    private Integer idVendaDeImoveis;
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Column(name = "dataRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;
    @Size(max = 200)
    @Column(name = "observacoes")
    private String observacoes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentualComissao")
    private Float percentualComissao;
    @JoinColumn(name = "idImoveis", referencedColumnName = "idImoveis")
    @ManyToOne(optional = false)
    private Imoveis idImoveis;
    @JoinColumn(name = "idFuncionarios", referencedColumnName = "idFuncionarios")
    @ManyToOne(optional = false)
    private Funcionarios idFuncionarios;
    @JoinColumn(name = "idClienteComprador", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private Clientes idClienteComprador;
    @JoinColumn(name = "idClienteVendedor", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private Clientes idClienteVendedor;
    @JoinColumn(name = "idFormasDePagamento", referencedColumnName = "idFormasDePagamento")
    @ManyToOne(optional = false)
    private Formasdepagamento idFormasDePagamento;

    public Vendadeimoveis() {
    }

    public Vendadeimoveis(Integer idVendaDeImoveis) {
        this.idVendaDeImoveis = idVendaDeImoveis;
    }

    public Integer getIdVendaDeImoveis() {
        return idVendaDeImoveis;
    }

    public void setIdVendaDeImoveis(Integer idVendaDeImoveis) {
        this.idVendaDeImoveis = idVendaDeImoveis;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
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

    public Clientes getIdClienteComprador() {
        return idClienteComprador;
    }

    public void setIdClienteComprador(Clientes idClienteComprador) {
        this.idClienteComprador = idClienteComprador;
    }

    public Clientes getIdClienteVendedor() {
        return idClienteVendedor;
    }

    public void setIdClienteVendedor(Clientes idClienteVendedor) {
        this.idClienteVendedor = idClienteVendedor;
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
        hash += (idVendaDeImoveis != null ? idVendaDeImoveis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendadeimoveis)) {
            return false;
        }
        Vendadeimoveis other = (Vendadeimoveis) object;
        if ((this.idVendaDeImoveis == null && other.idVendaDeImoveis != null) || (this.idVendaDeImoveis != null && !this.idVendaDeImoveis.equals(other.idVendaDeImoveis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Vendadeimoveis[ idVendaDeImoveis=" + idVendaDeImoveis + " ]";
    }
    
}

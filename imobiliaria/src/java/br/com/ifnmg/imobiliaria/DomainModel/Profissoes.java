/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "profissoes")
@NamedQueries({
    @NamedQuery(name = "Profissoes.findAll", query = "SELECT p FROM Profissoes p"),
    @NamedQuery(name = "Profissoes.findByIdProfissoes", query = "SELECT p FROM Profissoes p WHERE p.idProfissoes = :idProfissoes"),
    @NamedQuery(name = "Profissoes.findByNome", query = "SELECT p FROM Profissoes p WHERE p.nome = :nome"),
    @NamedQuery(name = "Profissoes.findByStatus", query = "SELECT p FROM Profissoes p WHERE p.status = :status")})
public class Profissoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfissoes")
    private Integer idProfissoes;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfissaoCongugue")
    private List<Clientes> clientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfissoes")
    private List<Clientes> clientesList1;

    public Profissoes() {
    }

    public Profissoes(Integer idProfissoes) {
        this.idProfissoes = idProfissoes;
    }

    public Integer getIdProfissoes() {
        return idProfissoes;
    }

    public void setIdProfissoes(Integer idProfissoes) {
        this.idProfissoes = idProfissoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public List<Clientes> getClientesList1() {
        return clientesList1;
    }

    public void setClientesList1(List<Clientes> clientesList1) {
        this.clientesList1 = clientesList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfissoes != null ? idProfissoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissoes)) {
            return false;
        }
        Profissoes other = (Profissoes) object;
        if ((this.idProfissoes == null && other.idProfissoes != null) || (this.idProfissoes != null && !this.idProfissoes.equals(other.idProfissoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Profissoes[ idProfissoes=" + idProfissoes + " ]";
    }
    
}

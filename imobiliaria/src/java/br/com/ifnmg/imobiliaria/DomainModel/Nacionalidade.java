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
@Table(name = "nacionalidade")
@NamedQueries({
    @NamedQuery(name = "Nacionalidade.findAll", query = "SELECT n FROM Nacionalidade n"),
    @NamedQuery(name = "Nacionalidade.findByIdNacionalidade", query = "SELECT n FROM Nacionalidade n WHERE n.idNacionalidade = :idNacionalidade"),
    @NamedQuery(name = "Nacionalidade.findByNome", query = "SELECT n FROM Nacionalidade n WHERE n.nome = :nome")})
public class Nacionalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNacionalidade")
    private Integer idNacionalidade;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conjugueidNacionalidade")
    private List<Clientes> clientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNacionalidade")
    private List<Pessoas> pessoasList;

    public Nacionalidade() {
    }

    public Nacionalidade(Integer idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public Integer getIdNacionalidade() {
        return idNacionalidade;
    }

    public void setIdNacionalidade(Integer idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public List<Pessoas> getPessoasList() {
        return pessoasList;
    }

    public void setPessoasList(List<Pessoas> pessoasList) {
        this.pessoasList = pessoasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNacionalidade != null ? idNacionalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidade)) {
            return false;
        }
        Nacionalidade other = (Nacionalidade) object;
        if ((this.idNacionalidade == null && other.idNacionalidade != null) || (this.idNacionalidade != null && !this.idNacionalidade.equals(other.idNacionalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Nacionalidade[ idNacionalidade=" + idNacionalidade + " ]";
    }
    
}

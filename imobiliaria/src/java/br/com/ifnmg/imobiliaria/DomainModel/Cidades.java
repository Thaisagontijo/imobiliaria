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
@Table(name = "cidades")
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findByIdCidades", query = "SELECT c FROM Cidades c WHERE c.idCidades = :idCidades"),
    @NamedQuery(name = "Cidades.findByIdEstado", query = "SELECT c FROM Cidades c WHERE c.idEstado = :idEstado"),
    @NamedQuery(name = "Cidades.findByNome", query = "SELECT c FROM Cidades c WHERE c.nome = :nome")})
public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCidades")
    private Integer idCidades;
    @Column(name = "idEstado")
    private Integer idEstado;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidades")
    private List<Imoveis> imoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidades")
    private List<Pessoas> pessoasList;

    public Cidades() {
    }

    public Cidades(Integer idCidades) {
        this.idCidades = idCidades;
    }

    public Integer getIdCidades() {
        return idCidades;
    }

    public void setIdCidades(Integer idCidades) {
        this.idCidades = idCidades;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Imoveis> getImoveisList() {
        return imoveisList;
    }

    public void setImoveisList(List<Imoveis> imoveisList) {
        this.imoveisList = imoveisList;
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
        hash += (idCidades != null ? idCidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.idCidades == null && other.idCidades != null) || (this.idCidades != null && !this.idCidades.equals(other.idCidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Cidades[ idCidades=" + idCidades + " ]";
    }
    
}

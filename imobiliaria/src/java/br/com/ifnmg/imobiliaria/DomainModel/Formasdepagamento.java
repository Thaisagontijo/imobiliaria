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
@Table(name = "formasdepagamento")
@NamedQueries({
    @NamedQuery(name = "Formasdepagamento.findAll", query = "SELECT f FROM Formasdepagamento f"),
    @NamedQuery(name = "Formasdepagamento.findByIdFormasDePagamento", query = "SELECT f FROM Formasdepagamento f WHERE f.idFormasDePagamento = :idFormasDePagamento"),
    @NamedQuery(name = "Formasdepagamento.findByNome", query = "SELECT f FROM Formasdepagamento f WHERE f.nome = :nome"),
    @NamedQuery(name = "Formasdepagamento.findByStatus", query = "SELECT f FROM Formasdepagamento f WHERE f.status = :status")})
public class Formasdepagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormasDePagamento")
    private Integer idFormasDePagamento;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormasDePagamento")
    private List<Vendadeimoveis> vendadeimoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormasDePagamento")
    private List<Alugueisdeimoveis> alugueisdeimoveisList;

    public Formasdepagamento() {
    }

    public Formasdepagamento(Integer idFormasDePagamento) {
        this.idFormasDePagamento = idFormasDePagamento;
    }

    public Integer getIdFormasDePagamento() {
        return idFormasDePagamento;
    }

    public void setIdFormasDePagamento(Integer idFormasDePagamento) {
        this.idFormasDePagamento = idFormasDePagamento;
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

    public List<Vendadeimoveis> getVendadeimoveisList() {
        return vendadeimoveisList;
    }

    public void setVendadeimoveisList(List<Vendadeimoveis> vendadeimoveisList) {
        this.vendadeimoveisList = vendadeimoveisList;
    }

    public List<Alugueisdeimoveis> getAlugueisdeimoveisList() {
        return alugueisdeimoveisList;
    }

    public void setAlugueisdeimoveisList(List<Alugueisdeimoveis> alugueisdeimoveisList) {
        this.alugueisdeimoveisList = alugueisdeimoveisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormasDePagamento != null ? idFormasDePagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formasdepagamento)) {
            return false;
        }
        Formasdepagamento other = (Formasdepagamento) object;
        if ((this.idFormasDePagamento == null && other.idFormasDePagamento != null) || (this.idFormasDePagamento != null && !this.idFormasDePagamento.equals(other.idFormasDePagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Formasdepagamento[ idFormasDePagamento=" + idFormasDePagamento + " ]";
    }
    
}

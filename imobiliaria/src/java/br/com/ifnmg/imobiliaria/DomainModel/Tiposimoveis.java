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
@Table(name = "tiposimoveis")
@NamedQueries({
    @NamedQuery(name = "Tiposimoveis.findAll", query = "SELECT t FROM Tiposimoveis t"),
    @NamedQuery(name = "Tiposimoveis.findByIdTipoImovel", query = "SELECT t FROM Tiposimoveis t WHERE t.idTipoImovel = :idTipoImovel"),
    @NamedQuery(name = "Tiposimoveis.findByNome", query = "SELECT t FROM Tiposimoveis t WHERE t.nome = :nome"),
    @NamedQuery(name = "Tiposimoveis.findByStatus", query = "SELECT t FROM Tiposimoveis t WHERE t.status = :status")})
public class Tiposimoveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoImovel")
    private Integer idTipoImovel;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoImovel")
    private List<Imoveis> imoveisList;

    public Tiposimoveis() {
    }

    public Tiposimoveis(Integer idTipoImovel) {
        this.idTipoImovel = idTipoImovel;
    }

    public Integer getIdTipoImovel() {
        return idTipoImovel;
    }

    public void setIdTipoImovel(Integer idTipoImovel) {
        this.idTipoImovel = idTipoImovel;
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

    public List<Imoveis> getImoveisList() {
        return imoveisList;
    }

    public void setImoveisList(List<Imoveis> imoveisList) {
        this.imoveisList = imoveisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoImovel != null ? idTipoImovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposimoveis)) {
            return false;
        }
        Tiposimoveis other = (Tiposimoveis) object;
        if ((this.idTipoImovel == null && other.idTipoImovel != null) || (this.idTipoImovel != null && !this.idTipoImovel.equals(other.idTipoImovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Tiposimoveis[ idTipoImovel=" + idTipoImovel + " ]";
    }
    
}

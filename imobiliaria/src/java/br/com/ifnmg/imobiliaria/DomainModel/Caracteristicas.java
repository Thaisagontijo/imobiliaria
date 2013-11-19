/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "caracteristicas")
@NamedQueries({
    @NamedQuery(name = "Caracteristicas.findAll", query = "SELECT c FROM Caracteristicas c"),
    @NamedQuery(name = "Caracteristicas.findByIdCaracteristicas", query = "SELECT c FROM Caracteristicas c WHERE c.idCaracteristicas = :idCaracteristicas"),
    @NamedQuery(name = "Caracteristicas.findByNome", query = "SELECT c FROM Caracteristicas c WHERE c.nome = :nome"),
    @NamedQuery(name = "Caracteristicas.findByStatus", query = "SELECT c FROM Caracteristicas c WHERE c.status = :status")})
public class Caracteristicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCaracteristicas")
    private Integer idCaracteristicas;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Column(name = "status")
    private Boolean status;
    @ManyToMany(mappedBy = "caracteristicasList")
    private List<Imoveis> imoveisList;

    public Caracteristicas() {
    }

    public Caracteristicas(Integer idCaracteristicas) {
        this.idCaracteristicas = idCaracteristicas;
    }

    public Integer getIdCaracteristicas() {
        return idCaracteristicas;
    }

    public void setIdCaracteristicas(Integer idCaracteristicas) {
        this.idCaracteristicas = idCaracteristicas;
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
        hash += (idCaracteristicas != null ? idCaracteristicas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristicas)) {
            return false;
        }
        Caracteristicas other = (Caracteristicas) object;
        if ((this.idCaracteristicas == null && other.idCaracteristicas != null) || (this.idCaracteristicas != null && !this.idCaracteristicas.equals(other.idCaracteristicas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Caracteristicas[ idCaracteristicas=" + idCaracteristicas + " ]";
    }
    
}

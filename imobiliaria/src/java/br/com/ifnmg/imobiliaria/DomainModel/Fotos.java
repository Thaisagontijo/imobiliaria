/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "fotos")
@NamedQueries({
    @NamedQuery(name = "Fotos.findAll", query = "SELECT f FROM Fotos f"),
    @NamedQuery(name = "Fotos.findByIdFotos", query = "SELECT f FROM Fotos f WHERE f.idFotos = :idFotos"),
    @NamedQuery(name = "Fotos.findByNome", query = "SELECT f FROM Fotos f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fotos.findByStatus", query = "SELECT f FROM Fotos f WHERE f.status = :status"),
    @NamedQuery(name = "Fotos.findByDescricao", query = "SELECT f FROM Fotos f WHERE f.descricao = :descricao")})
public class Fotos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFotos")
    private Integer idFotos;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;
    @Column(name = "status")
    private Boolean status;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "idImoveis", referencedColumnName = "idImoveis")
    @ManyToOne(optional = false)
    private Imoveis idImoveis;

    public Fotos() {
    }

    public Fotos(Integer idFotos) {
        this.idFotos = idFotos;
    }

    public Integer getIdFotos() {
        return idFotos;
    }

    public void setIdFotos(Integer idFotos) {
        this.idFotos = idFotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (idFotos != null ? idFotos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotos)) {
            return false;
        }
        Fotos other = (Fotos) object;
        if ((this.idFotos == null && other.idFotos != null) || (this.idFotos != null && !this.idFotos.equals(other.idFotos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Fotos[ idFotos=" + idFotos + " ]";
    }
    
}

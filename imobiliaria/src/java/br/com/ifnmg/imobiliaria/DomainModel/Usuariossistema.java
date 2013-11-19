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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuariossistema")
@NamedQueries({
    @NamedQuery(name = "Usuariossistema.findAll", query = "SELECT u FROM Usuariossistema u"),
    @NamedQuery(name = "Usuariossistema.findByIdusuariosSistema", query = "SELECT u FROM Usuariossistema u WHERE u.idusuariosSistema = :idusuariosSistema"),
    @NamedQuery(name = "Usuariossistema.findByLogin", query = "SELECT u FROM Usuariossistema u WHERE u.login = :login"),
    @NamedQuery(name = "Usuariossistema.findBySenha", query = "SELECT u FROM Usuariossistema u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuariossistema.findByStatus", query = "SELECT u FROM Usuariossistema u WHERE u.status = :status"),
    @NamedQuery(name = "Usuariossistema.findByNivel", query = "SELECT u FROM Usuariossistema u WHERE u.nivel = :nivel")})
public class Usuariossistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariosSistema")
    private Integer idusuariosSistema;
    @Size(max = 50)
    @Column(name = "login")
    private String login;
    @Size(max = 150)
    @Column(name = "senha")
    private String senha;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "nivel")
    private Integer nivel;
    @JoinColumn(name = "idFuncionarios", referencedColumnName = "idFuncionarios")
    @ManyToOne(optional = false)
    private Funcionarios idFuncionarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuariosSistema")
    private List<Logacesso> logacessoList;

    public Usuariossistema() {
    }

    public Usuariossistema(Integer idusuariosSistema) {
        this.idusuariosSistema = idusuariosSistema;
    }

    public Integer getIdusuariosSistema() {
        return idusuariosSistema;
    }

    public void setIdusuariosSistema(Integer idusuariosSistema) {
        this.idusuariosSistema = idusuariosSistema;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Funcionarios getIdFuncionarios() {
        return idFuncionarios;
    }

    public void setIdFuncionarios(Funcionarios idFuncionarios) {
        this.idFuncionarios = idFuncionarios;
    }

    public List<Logacesso> getLogacessoList() {
        return logacessoList;
    }

    public void setLogacessoList(List<Logacesso> logacessoList) {
        this.logacessoList = logacessoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariosSistema != null ? idusuariosSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariossistema)) {
            return false;
        }
        Usuariossistema other = (Usuariossistema) object;
        if ((this.idusuariosSistema == null && other.idusuariosSistema != null) || (this.idusuariosSistema != null && !this.idusuariosSistema.equals(other.idusuariosSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Usuariossistema[ idusuariosSistema=" + idusuariosSistema + " ]";
    }
    
}

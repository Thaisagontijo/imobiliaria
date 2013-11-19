/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "funcionarios")

public class Funcionarios extends Pessoas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name = "dataAdmissao")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    @Column(name = "status")
    private Boolean status;
  /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarios")
    private List<Usuariossistema> usuariossistemaList;
    @JoinColumn(name = "idPessoas", referencedColumnName = "idPessoas")
    @ManyToOne(optional = false)
    private Pessoas idPessoas;
    
    */
    @JoinColumn(name = "Cargo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cargos Cargo;
    
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarios")
    private List<Vendadeimoveis> vendadeimoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarios")
    private List<Alugueisdeimoveis> alugueisdeimoveisList;
     */
    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Cargos getCargo() {
        return Cargo;
    }

    public void setCargo(Cargos Cargo) {
        this.Cargo = Cargo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.dataAdmissao);
        hash = 31 * hash + Objects.hashCode(this.Cargo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionarios other = (Funcionarios) obj;
        if (!Objects.equals(this.dataAdmissao, other.dataAdmissao)) {
            return false;
        }
        if (!Objects.equals(this.Cargo, other.Cargo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name="Funcionarios")
public class Funcionario extends Pessoa implements Serializable {

    
    @Column(name = "dataAdmissao")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarios")
    private List<Usuariossistema> usuariossistemaList;
    @JoinColumn(name = "idPessoas", referencedColumnName = "idPessoas")
    @ManyToOne(optional = false)
    private Pessoas idPessoas;
    @JoinColumn(name = "idCargos", referencedColumnName = "idCargos")
    @ManyToOne(optional = false)
    private Cargos idCargos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarios")
    private List<Vendadeimoveis> vendadeimoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarios")
    private List<Alugueisdeimoveis> alugueisdeimoveisList;
}

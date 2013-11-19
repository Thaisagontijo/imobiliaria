/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdClientes", query = "SELECT c FROM Clientes c WHERE c.idClientes = :idClientes"),
    @NamedQuery(name = "Clientes.findByDataCadastro", query = "SELECT c FROM Clientes c WHERE c.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Clientes.findByStatus", query = "SELECT c FROM Clientes c WHERE c.status = :status"),
    @NamedQuery(name = "Clientes.findByConjugueNome", query = "SELECT c FROM Clientes c WHERE c.conjugueNome = :conjugueNome"),
    @NamedQuery(name = "Clientes.findByConjugueCpf", query = "SELECT c FROM Clientes c WHERE c.conjugueCpf = :conjugueCpf"),
    @NamedQuery(name = "Clientes.findByConjugueRg", query = "SELECT c FROM Clientes c WHERE c.conjugueRg = :conjugueRg"),
    @NamedQuery(name = "Clientes.findByConjugueDataNascimento", query = "SELECT c FROM Clientes c WHERE c.conjugueDataNascimento = :conjugueDataNascimento"),
    @NamedQuery(name = "Clientes.findByConjugueSexo", query = "SELECT c FROM Clientes c WHERE c.conjugueSexo = :conjugueSexo"),
    @NamedQuery(name = "Clientes.findByConjugueOrgaoExpedidor", query = "SELECT c FROM Clientes c WHERE c.conjugueOrgaoExpedidor = :conjugueOrgaoExpedidor"),
    @NamedQuery(name = "Clientes.findByDataCasamento", query = "SELECT c FROM Clientes c WHERE c.dataCasamento = :dataCasamento"),
    @NamedQuery(name = "Clientes.findByConjugueTelefone", query = "SELECT c FROM Clientes c WHERE c.conjugueTelefone = :conjugueTelefone"),
    @NamedQuery(name = "Clientes.findByConjugueEmail", query = "SELECT c FROM Clientes c WHERE c.conjugueEmail = :conjugueEmail"),
    @NamedQuery(name = "Clientes.findByClienteJuridicoFisico", query = "SELECT c FROM Clientes c WHERE c.clienteJuridicoFisico = :clienteJuridicoFisico"),
    @NamedQuery(name = "Clientes.findByJuridicoInscricaoMunicipal", query = "SELECT c FROM Clientes c WHERE c.juridicoInscricaoMunicipal = :juridicoInscricaoMunicipal"),
    @NamedQuery(name = "Clientes.findByJuridicoInstricaoEstadual", query = "SELECT c FROM Clientes c WHERE c.juridicoInstricaoEstadual = :juridicoInstricaoEstadual")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClientes")
    private Integer idClientes;
    @Column(name = "dataCadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "status")
    private Boolean status;
    @Size(max = 100)
    @Column(name = "conjugueNome")
    private String conjugueNome;
    @Size(max = 20)
    @Column(name = "conjugueCpf")
    private String conjugueCpf;
    @Size(max = 15)
    @Column(name = "conjugueRg")
    private String conjugueRg;
    @Column(name = "conjugueDataNascimento")
    @Temporal(TemporalType.DATE)
    private Date conjugueDataNascimento;
    @Column(name = "conjugueSexo")
    private Integer conjugueSexo;
    @Size(max = 10)
    @Column(name = "ConjugueOrgaoExpedidor")
    private String conjugueOrgaoExpedidor;
    @Column(name = "dataCasamento")
    @Temporal(TemporalType.DATE)
    private Date dataCasamento;
    @Size(max = 50)
    @Column(name = "conjugueTelefone")
    private String conjugueTelefone;
    @Size(max = 50)
    @Column(name = "conjugueEmail")
    private String conjugueEmail;
    @Column(name = "clienteJuridicoFisico")
    private Boolean clienteJuridicoFisico;
    @Size(max = 50)
    @Column(name = "juridicoInscricaoMunicipal")
    private String juridicoInscricaoMunicipal;
    @Size(max = 50)
    @Column(name = "juridicoInstricaoEstadual")
    private String juridicoInstricaoEstadual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClienteComprador")
    private List<Vendadeimoveis> vendadeimoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClienteVendedor")
    private List<Vendadeimoveis> vendadeimoveisList1;
    @JoinColumn(name = "conjugueidNacionalidade", referencedColumnName = "idNacionalidade")
    @ManyToOne(optional = false)
    private Nacionalidade conjugueidNacionalidade;
    @JoinColumn(name = "idProfissaoCongugue", referencedColumnName = "idProfissoes")
    @ManyToOne(optional = false)
    private Profissoes idProfissaoCongugue;
    @JoinColumn(name = "idProfissoes", referencedColumnName = "idProfissoes")
    @ManyToOne(optional = false)
    private Profissoes idProfissoes;
    @JoinColumn(name = "idPessoas", referencedColumnName = "idPessoas")
    @ManyToOne(optional = false)
    private Pessoas idPessoas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClientes")
    private List<Alugueisdeimoveis> alugueisdeimoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClienteProprietario")
    private List<Imoveis> imoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClientes")
    private List<Visitas> visitasList;

    public Clientes() {
    }

    public Clientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Integer getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Integer idClientes) {
        this.idClientes = idClientes;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getConjugueNome() {
        return conjugueNome;
    }

    public void setConjugueNome(String conjugueNome) {
        this.conjugueNome = conjugueNome;
    }

    public String getConjugueCpf() {
        return conjugueCpf;
    }

    public void setConjugueCpf(String conjugueCpf) {
        this.conjugueCpf = conjugueCpf;
    }

    public String getConjugueRg() {
        return conjugueRg;
    }

    public void setConjugueRg(String conjugueRg) {
        this.conjugueRg = conjugueRg;
    }

    public Date getConjugueDataNascimento() {
        return conjugueDataNascimento;
    }

    public void setConjugueDataNascimento(Date conjugueDataNascimento) {
        this.conjugueDataNascimento = conjugueDataNascimento;
    }

    public Integer getConjugueSexo() {
        return conjugueSexo;
    }

    public void setConjugueSexo(Integer conjugueSexo) {
        this.conjugueSexo = conjugueSexo;
    }

    public String getConjugueOrgaoExpedidor() {
        return conjugueOrgaoExpedidor;
    }

    public void setConjugueOrgaoExpedidor(String conjugueOrgaoExpedidor) {
        this.conjugueOrgaoExpedidor = conjugueOrgaoExpedidor;
    }

    public Date getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(Date dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public String getConjugueTelefone() {
        return conjugueTelefone;
    }

    public void setConjugueTelefone(String conjugueTelefone) {
        this.conjugueTelefone = conjugueTelefone;
    }

    public String getConjugueEmail() {
        return conjugueEmail;
    }

    public void setConjugueEmail(String conjugueEmail) {
        this.conjugueEmail = conjugueEmail;
    }

    public Boolean getClienteJuridicoFisico() {
        return clienteJuridicoFisico;
    }

    public void setClienteJuridicoFisico(Boolean clienteJuridicoFisico) {
        this.clienteJuridicoFisico = clienteJuridicoFisico;
    }

    public String getJuridicoInscricaoMunicipal() {
        return juridicoInscricaoMunicipal;
    }

    public void setJuridicoInscricaoMunicipal(String juridicoInscricaoMunicipal) {
        this.juridicoInscricaoMunicipal = juridicoInscricaoMunicipal;
    }

    public String getJuridicoInstricaoEstadual() {
        return juridicoInstricaoEstadual;
    }

    public void setJuridicoInstricaoEstadual(String juridicoInstricaoEstadual) {
        this.juridicoInstricaoEstadual = juridicoInstricaoEstadual;
    }

    public List<Vendadeimoveis> getVendadeimoveisList() {
        return vendadeimoveisList;
    }

    public void setVendadeimoveisList(List<Vendadeimoveis> vendadeimoveisList) {
        this.vendadeimoveisList = vendadeimoveisList;
    }

    public List<Vendadeimoveis> getVendadeimoveisList1() {
        return vendadeimoveisList1;
    }

    public void setVendadeimoveisList1(List<Vendadeimoveis> vendadeimoveisList1) {
        this.vendadeimoveisList1 = vendadeimoveisList1;
    }

    public Nacionalidade getConjugueidNacionalidade() {
        return conjugueidNacionalidade;
    }

    public void setConjugueidNacionalidade(Nacionalidade conjugueidNacionalidade) {
        this.conjugueidNacionalidade = conjugueidNacionalidade;
    }

    public Profissoes getIdProfissaoCongugue() {
        return idProfissaoCongugue;
    }

    public void setIdProfissaoCongugue(Profissoes idProfissaoCongugue) {
        this.idProfissaoCongugue = idProfissaoCongugue;
    }

    public Profissoes getIdProfissoes() {
        return idProfissoes;
    }

    public void setIdProfissoes(Profissoes idProfissoes) {
        this.idProfissoes = idProfissoes;
    }

    public Pessoas getIdPessoas() {
        return idPessoas;
    }

    public void setIdPessoas(Pessoas idPessoas) {
        this.idPessoas = idPessoas;
    }

    public List<Alugueisdeimoveis> getAlugueisdeimoveisList() {
        return alugueisdeimoveisList;
    }

    public void setAlugueisdeimoveisList(List<Alugueisdeimoveis> alugueisdeimoveisList) {
        this.alugueisdeimoveisList = alugueisdeimoveisList;
    }

    public List<Imoveis> getImoveisList() {
        return imoveisList;
    }

    public void setImoveisList(List<Imoveis> imoveisList) {
        this.imoveisList = imoveisList;
    }

    public List<Visitas> getVisitasList() {
        return visitasList;
    }

    public void setVisitasList(List<Visitas> visitasList) {
        this.visitasList = visitasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientes != null ? idClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idClientes == null && other.idClientes != null) || (this.idClientes != null && !this.idClientes.equals(other.idClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Clientes[ idClientes=" + idClientes + " ]";
    }
    
}

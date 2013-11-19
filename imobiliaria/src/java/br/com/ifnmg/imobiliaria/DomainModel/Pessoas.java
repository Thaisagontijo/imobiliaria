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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "pessoas")

@Inheritance(strategy= InheritanceType.JOINED)
public class Pessoas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPessoas")
    private Integer idPessoas;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 15)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 20)
    @Column(name = "rg")
    private String rg;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "sexo")
    private Integer sexo;
    @Size(max = 50)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 50)
    @Column(name = "enderecoRua")
    private String enderecoRua;
    @Size(max = 15)
    @Column(name = "enderecoCep")
    private String enderecoCep;
    @Size(max = 50)
    @Column(name = "enderecoBairro")
    private String enderecoBairro;
    @Column(name = "status")
    private Boolean status;
    
    
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoas")
    private List<Funcionarios> funcionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPessoas")
    private List<Clientes> clientesList;
    @JoinColumn(name = "idNacionalidade", referencedColumnName = "idNacionalidade")
    @ManyToOne(optional = false)
    private Nacionalidade idNacionalidade;
    @JoinColumn(name = "idCidades", referencedColumnName = "idCidades")
    @ManyToOne(optional = false)
    private Cidades idCidades;

    public Pessoas() {
    }

    public Pessoas(Integer idPessoas) {
        this.idPessoas = idPessoas;
    }

    public Integer getIdPessoas() {
        return idPessoas;
    }

    public void setIdPessoas(Integer idPessoas) {
        this.idPessoas = idPessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Funcionarios> getFuncionariosList() {
        return funcionariosList;
    }

    public void setFuncionariosList(List<Funcionarios> funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    public Nacionalidade getIdNacionalidade() {
        return idNacionalidade;
    }

    public void setIdNacionalidade(Nacionalidade idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public Cidades getIdCidades() {
        return idCidades;
    }

    public void setIdCidades(Cidades idCidades) {
        this.idCidades = idCidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoas != null ? idPessoas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoas)) {
            return false;
        }
        Pessoas other = (Pessoas) object;
        if ((this.idPessoas == null && other.idPessoas != null) || (this.idPessoas != null && !this.idPessoas.equals(other.idPessoas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Pessoas[ idPessoas=" + idPessoas + " ]";
    }
    
}

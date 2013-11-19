/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifnmg.imobiliaria.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "interessados")
@NamedQueries({
    @NamedQuery(name = "Interessados.findAll", query = "SELECT i FROM Interessados i"),
    @NamedQuery(name = "Interessados.findByIdInteressados", query = "SELECT i FROM Interessados i WHERE i.idInteressados = :idInteressados"),
    @NamedQuery(name = "Interessados.findByNome", query = "SELECT i FROM Interessados i WHERE i.nome = :nome"),
    @NamedQuery(name = "Interessados.findByTelefone", query = "SELECT i FROM Interessados i WHERE i.telefone = :telefone"),
    @NamedQuery(name = "Interessados.findByEmail", query = "SELECT i FROM Interessados i WHERE i.email = :email"),
    @NamedQuery(name = "Interessados.findByMensagem", query = "SELECT i FROM Interessados i WHERE i.mensagem = :mensagem"),
    @NamedQuery(name = "Interessados.findByDataRegistro", query = "SELECT i FROM Interessados i WHERE i.dataRegistro = :dataRegistro")})
public class Interessados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInteressados")
    private Integer idInteressados;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 120)
    @Column(name = "mensagem")
    private String mensagem;
    @Column(name = "dataRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;
    @JoinColumn(name = "Imoveis_idImoveis", referencedColumnName = "idImoveis")
    @ManyToOne(optional = false)
    private Imoveis imoveisidImoveis;

    public Interessados() {
    }

    public Interessados(Integer idInteressados) {
        this.idInteressados = idInteressados;
    }

    public Integer getIdInteressados() {
        return idInteressados;
    }

    public void setIdInteressados(Integer idInteressados) {
        this.idInteressados = idInteressados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Imoveis getImoveisidImoveis() {
        return imoveisidImoveis;
    }

    public void setImoveisidImoveis(Imoveis imoveisidImoveis) {
        this.imoveisidImoveis = imoveisidImoveis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInteressados != null ? idInteressados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interessados)) {
            return false;
        }
        Interessados other = (Interessados) object;
        if ((this.idInteressados == null && other.idInteressados != null) || (this.idInteressados != null && !this.idInteressados.equals(other.idInteressados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Interessados[ idInteressados=" + idInteressados + " ]";
    }
    
}

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

/**
 *
 * @author Ana Luiza
 */
@Entity
@Table(name = "logacesso")
@NamedQueries({
    @NamedQuery(name = "Logacesso.findAll", query = "SELECT l FROM Logacesso l"),
    @NamedQuery(name = "Logacesso.findByIdlogAcesso", query = "SELECT l FROM Logacesso l WHERE l.idlogAcesso = :idlogAcesso"),
    @NamedQuery(name = "Logacesso.findByDataHora", query = "SELECT l FROM Logacesso l WHERE l.dataHora = :dataHora"),
    @NamedQuery(name = "Logacesso.findByTipo", query = "SELECT l FROM Logacesso l WHERE l.tipo = :tipo")})
public class Logacesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogAcesso")
    private Integer idlogAcesso;
    @Column(name = "dataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinColumn(name = "idusuariosSistema", referencedColumnName = "idusuariosSistema")
    @ManyToOne(optional = false)
    private Usuariossistema idusuariosSistema;

    public Logacesso() {
    }

    public Logacesso(Integer idlogAcesso) {
        this.idlogAcesso = idlogAcesso;
    }

    public Integer getIdlogAcesso() {
        return idlogAcesso;
    }

    public void setIdlogAcesso(Integer idlogAcesso) {
        this.idlogAcesso = idlogAcesso;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Usuariossistema getIdusuariosSistema() {
        return idusuariosSistema;
    }

    public void setIdusuariosSistema(Usuariossistema idusuariosSistema) {
        this.idusuariosSistema = idusuariosSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogAcesso != null ? idlogAcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logacesso)) {
            return false;
        }
        Logacesso other = (Logacesso) object;
        if ((this.idlogAcesso == null && other.idlogAcesso != null) || (this.idlogAcesso != null && !this.idlogAcesso.equals(other.idlogAcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Logacesso[ idlogAcesso=" + idlogAcesso + " ]";
    }
    
}

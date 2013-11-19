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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "imoveis")
@NamedQueries({
    @NamedQuery(name = "Imoveis.findAll", query = "SELECT i FROM Imoveis i"),
    @NamedQuery(name = "Imoveis.findByIdImoveis", query = "SELECT i FROM Imoveis i WHERE i.idImoveis = :idImoveis"),
    @NamedQuery(name = "Imoveis.findByEnderecoRua", query = "SELECT i FROM Imoveis i WHERE i.enderecoRua = :enderecoRua"),
    @NamedQuery(name = "Imoveis.findByEnderecoCep", query = "SELECT i FROM Imoveis i WHERE i.enderecoCep = :enderecoCep"),
    @NamedQuery(name = "Imoveis.findByEnderecoBairro", query = "SELECT i FROM Imoveis i WHERE i.enderecoBairro = :enderecoBairro"),
    @NamedQuery(name = "Imoveis.findByEnderecoComplemento", query = "SELECT i FROM Imoveis i WHERE i.enderecoComplemento = :enderecoComplemento"),
    @NamedQuery(name = "Imoveis.findByEnderecoNumero", query = "SELECT i FROM Imoveis i WHERE i.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Imoveis.findByIptu", query = "SELECT i FROM Imoveis i WHERE i.iptu = :iptu"),
    @NamedQuery(name = "Imoveis.findByDimensoes", query = "SELECT i FROM Imoveis i WHERE i.dimensoes = :dimensoes"),
    @NamedQuery(name = "Imoveis.findByDataInicioContrucao", query = "SELECT i FROM Imoveis i WHERE i.dataInicioContrucao = :dataInicioContrucao"),
    @NamedQuery(name = "Imoveis.findBySomaImpostos", query = "SELECT i FROM Imoveis i WHERE i.somaImpostos = :somaImpostos"),
    @NamedQuery(name = "Imoveis.findByDataTerminoConstrucao", query = "SELECT i FROM Imoveis i WHERE i.dataTerminoConstrucao = :dataTerminoConstrucao")})
public class Imoveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImoveis")
    private Integer idImoveis;
    @Size(max = 50)
    @Column(name = "enderecoRua")
    private String enderecoRua;
    @Size(max = 15)
    @Column(name = "enderecoCep")
    private String enderecoCep;
    @Size(max = 20)
    @Column(name = "enderecoBairro")
    private String enderecoBairro;
    @Size(max = 50)
    @Column(name = "enderecoComplemento")
    private String enderecoComplemento;
    @Column(name = "enderecoNumero")
    private Integer enderecoNumero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iptu")
    private Float iptu;
    @Column(name = "dimensoes")
    private Float dimensoes;
    @Column(name = "dataInicioContrucao")
    @Temporal(TemporalType.DATE)
    private Date dataInicioContrucao;
    @Column(name = "somaImpostos")
    private Float somaImpostos;
    @Column(name = "dataTerminoConstrucao")
    @Temporal(TemporalType.DATE)
    private Date dataTerminoConstrucao;
    @JoinTable(name = "imoveis_has_caracteristicas", joinColumns = {
        @JoinColumn(name = "Imoveis_idImoveis", referencedColumnName = "idImoveis")}, inverseJoinColumns = {
        @JoinColumn(name = "Caracteristicas_idCaracteristicas", referencedColumnName = "idCaracteristicas")})
    @ManyToMany
    private List<Caracteristicas> caracteristicasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImoveis")
    private List<Vendadeimoveis> vendadeimoveisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImoveis")
    private List<Reformas> reformasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imoveisidImoveis")
    private List<Interessados> interessadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImoveis")
    private List<Alugueisdeimoveis> alugueisdeimoveisList;
    @JoinColumn(name = "idClienteProprietario", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private Clientes idClienteProprietario;
    @JoinColumn(name = "idCidades", referencedColumnName = "idCidades")
    @ManyToOne(optional = false)
    private Cidades idCidades;
    @JoinColumn(name = "idTipoImovel", referencedColumnName = "idTipoImovel")
    @ManyToOne(optional = false)
    private Tiposimoveis idTipoImovel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImoveis")
    private List<Fotos> fotosList;

    public Imoveis() {
    }

    public Imoveis(Integer idImoveis) {
        this.idImoveis = idImoveis;
    }

    public Integer getIdImoveis() {
        return idImoveis;
    }

    public void setIdImoveis(Integer idImoveis) {
        this.idImoveis = idImoveis;
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

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(Integer enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public Float getIptu() {
        return iptu;
    }

    public void setIptu(Float iptu) {
        this.iptu = iptu;
    }

    public Float getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(Float dimensoes) {
        this.dimensoes = dimensoes;
    }

    public Date getDataInicioContrucao() {
        return dataInicioContrucao;
    }

    public void setDataInicioContrucao(Date dataInicioContrucao) {
        this.dataInicioContrucao = dataInicioContrucao;
    }

    public Float getSomaImpostos() {
        return somaImpostos;
    }

    public void setSomaImpostos(Float somaImpostos) {
        this.somaImpostos = somaImpostos;
    }

    public Date getDataTerminoConstrucao() {
        return dataTerminoConstrucao;
    }

    public void setDataTerminoConstrucao(Date dataTerminoConstrucao) {
        this.dataTerminoConstrucao = dataTerminoConstrucao;
    }

    public List<Caracteristicas> getCaracteristicasList() {
        return caracteristicasList;
    }

    public void setCaracteristicasList(List<Caracteristicas> caracteristicasList) {
        this.caracteristicasList = caracteristicasList;
    }

    public List<Vendadeimoveis> getVendadeimoveisList() {
        return vendadeimoveisList;
    }

    public void setVendadeimoveisList(List<Vendadeimoveis> vendadeimoveisList) {
        this.vendadeimoveisList = vendadeimoveisList;
    }

    public List<Reformas> getReformasList() {
        return reformasList;
    }

    public void setReformasList(List<Reformas> reformasList) {
        this.reformasList = reformasList;
    }

    public List<Interessados> getInteressadosList() {
        return interessadosList;
    }

    public void setInteressadosList(List<Interessados> interessadosList) {
        this.interessadosList = interessadosList;
    }

    public List<Alugueisdeimoveis> getAlugueisdeimoveisList() {
        return alugueisdeimoveisList;
    }

    public void setAlugueisdeimoveisList(List<Alugueisdeimoveis> alugueisdeimoveisList) {
        this.alugueisdeimoveisList = alugueisdeimoveisList;
    }

    public Clientes getIdClienteProprietario() {
        return idClienteProprietario;
    }

    public void setIdClienteProprietario(Clientes idClienteProprietario) {
        this.idClienteProprietario = idClienteProprietario;
    }

    public Cidades getIdCidades() {
        return idCidades;
    }

    public void setIdCidades(Cidades idCidades) {
        this.idCidades = idCidades;
    }

    public Tiposimoveis getIdTipoImovel() {
        return idTipoImovel;
    }

    public void setIdTipoImovel(Tiposimoveis idTipoImovel) {
        this.idTipoImovel = idTipoImovel;
    }

    public List<Fotos> getFotosList() {
        return fotosList;
    }

    public void setFotosList(List<Fotos> fotosList) {
        this.fotosList = fotosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImoveis != null ? idImoveis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imoveis)) {
            return false;
        }
        Imoveis other = (Imoveis) object;
        if ((this.idImoveis == null && other.idImoveis != null) || (this.idImoveis != null && !this.idImoveis.equals(other.idImoveis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ifnmg.imobiliaria.DomainModel.Imoveis[ idImoveis=" + idImoveis + " ]";
    }
    
}

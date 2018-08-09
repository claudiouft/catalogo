/**
 * 
 */
package br.com.brbs.catalogo.modelo.entidade;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import br.com.brbs.catalogo.negocio.util.TelefoneUtil;

/**
 * @author claudiouft@gmail.com
 *
 */
@Entity
@Table(schema = "catalogo", name = "pessoa")
public class Pessoa {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nome_fantasia")
	private String nomeFantasia;

	@Column(name = "local_foto")
	private String localFotoPrincipal;
	
	@Column(name = "local_foto_destaque")
	private String localFotoDestaque;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "ativo")
	private String ativo;
	
	@Transient
	private MultipartFile foton;
	
	@OneToMany(mappedBy="pessoa", targetEntity = Foto.class, fetch = FetchType.EAGER)
	private List<Foto> listaFotos;
	
	@Column(name = "preco")
	private Double preco;
	
	@Column(name = "data_nascimento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataNascimento;
	
	@Column(name = "peso")
	private Double peso;
	
	@Column(name = "altura")
	private Double altura;
	
	@Column(name = "manequim")
	private Integer manequim;
	
	@Column(name = "acompanha")
	private String acompanha;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "uf")
	private String uf;
	
	@Column(name = "destaque")
	private String destaque;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "data_cadastro")
	@DateTimeFormat
	private Calendar dataCadastro;
	
	@Column(name = "data_alteracao")
	@DateTimeFormat
	private Calendar dataAlteracao;
	
	//@OneToOne
	//private Endereco endereco;
	
	@Transient
	String telefoneFormatado;
	
	public MultipartFile getFoton() {
		return foton;
	}

	public void setFoton(MultipartFile foton) {
		this.foton = foton;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone==null) {
			if(this.telefoneFormatado!=null) {
				this.telefone = TelefoneUtil.retirarMascaraTelefone(this.getTelefoneFormatado());
			}
		}else {
			this.telefone = telefone;
		}
		
	}

	public String getLocalFotoPrincipal() {
		return localFotoPrincipal;
	}

	public void setLocalFotoPrincipal(String localFotoPrincipal) {
		this.localFotoPrincipal = localFotoPrincipal;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public List<Foto> getListaFotos() {
		return listaFotos;
	}

	public void setListaFotos(List<Foto> listaFotos) {
		this.listaFotos = listaFotos;
	}

	public String getLocalFotoDestaque() {
		return localFotoDestaque;
	}

	public void setLocalFotoDestaque(String localFotoDestaque) {
		this.localFotoDestaque = localFotoDestaque;
	}

	public String getTelefoneFormatado() {
		if(this.getTelefone()!=null && this.getTelefone().length()==11) {
			return telefoneFormatado = TelefoneUtil.formatarTelefone(this.getTelefone());
		}
		return telefoneFormatado;
	}

	public void setTelefoneFormatado(String telefoneFormatado) {
		this.telefoneFormatado = telefoneFormatado;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getManequim() {
		return manequim;
	}

	public void setManequim(Integer manequim) {
		this.manequim = manequim;
	}

	public String getAcompanha() {
		return acompanha;
	}

	public void setAcompanha(String acompanha) {
		this.acompanha = acompanha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDestaque() {
		return destaque;
	}

	public void setDestaque(String destaque) {
		this.destaque = destaque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}

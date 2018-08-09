/**
 * 
 */
package br.com.brbs.catalogo.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author claudiouft@gmail.com
 *
 */
@Entity
@Table(schema = "catalogo", name = "foto")
public class Foto {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	@Column(name = "caminho_foto")
	private String localFoto;
	
	@Column(name = "ativo")
	private String ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getLocalFoto() {
		return localFoto;
	}

	public void setLocalFoto(String localFoto) {
		this.localFoto = localFoto;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
}

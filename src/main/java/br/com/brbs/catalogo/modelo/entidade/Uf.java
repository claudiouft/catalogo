package br.com.brbs.catalogo.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author claudiouft@gmail.com
 *
 */
@Entity
@Table(schema = "catalogo", name = "uf")
public class Uf {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sigla")
	private String sigla;


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
}

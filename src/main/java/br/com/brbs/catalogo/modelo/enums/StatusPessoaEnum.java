package br.com.brbs.catalogo.modelo.enums;

public enum StatusPessoaEnum {

	ATIVO("S"),
	DESLIGADO("N");
	
	private String valor;
	
	private StatusPessoaEnum(String ativo) {
		this.valor = ativo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}

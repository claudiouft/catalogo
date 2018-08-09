/**
 * 
 */
package br.com.brbs.catalogo.modelo.enums;

/**
 * @author claudiouft@gmail.com
 *
 */
public enum TipoFotoEnum {

		PRINCIPAL("P"),
		SECUNDARIO("S"),
		DESTAQUE("D");
	
	private String valor;
	
	private TipoFotoEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}

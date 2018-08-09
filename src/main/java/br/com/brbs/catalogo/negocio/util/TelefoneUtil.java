package br.com.brbs.catalogo.negocio.util;
/**
 * 
 * @author claudiouft@gmail.com
 *
 */
public final class TelefoneUtil {

	public static String formatarTelefone(String telefone) {
		String retorno = "";
		if(telefone!=null && telefone.length()>=11) {
			return retorno = "Fone: ("+telefone.substring(0,2)+") "+telefone.substring(2,7)+" - "+telefone.substring(7,11);
		}
		return retorno;
	}

	public static String retirarMascaraTelefone(String telefoneFormatado) {
		String retorno = "";
		if(telefoneFormatado!=null) {
			return retorno = telefoneFormatado.replace("(","").replace(")","").replace("-", "").replace(" ", "");
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		String fone = "(90)98282-4556";
		System.out.println("Com:"+fone);
		System.out.println("Sem:"+retirarMascaraTelefone(fone));
	}
}

package br.com.brbs.catalogo.negocio.util;

import java.util.Calendar;
import java.util.Date;

public final class DataUtil {

	public static Calendar obterDataAtual() {
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.setTime(new Date());
		return dataAtual;
	}

}

package catalogo;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Teste {

	public static void main(String[] args) {
		Double dolar = 100.909;
		NumberFormat format = NumberFormat.getCurrencyInstance();
		System.out.println(format.format(dolar));
		
		NumberFormat format2 = NumberFormat.getNumberInstance();
		System.out.println(format2.format(dolar));
		
		DecimalFormat format3 = new DecimalFormat("0.00");
		System.out.println(format3.format(dolar));
		
		NumberFormat format4 = NumberFormat.getIntegerInstance();
		System.out.println(format4.format(dolar));
		
	}

}

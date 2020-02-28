package br.com.roberto.util;

public class NumeroUtil {

	public static Double convertToDouble(String numero) {
		if(numero == null){
			return 0D;
		} 
		String numeroSemVirgula = numero.replaceAll(",", ".");
		if(isNumeric(numeroSemVirgula)) {
			return Double.valueOf(numeroSemVirgula);
		}
		return 0D;
	}
	
	public static boolean isNumeric(String numero) {
		if(numero == null){
			return false;
		} 
		String numeroSemVirgutla = numero.replaceAll(",", ".");
		return numeroSemVirgutla.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}

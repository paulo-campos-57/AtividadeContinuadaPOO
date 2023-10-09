package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class StringUtil {

	private StringUtil() {

	}

	/**
	 * 
	 * @param str
	 * @return true se a string for nula ou tiver so com espaçoes em braqnco, caso
	 *         contrario retorna false
	 */
	public static boolean ehNuloOuBranco(String str) {
		return str == null || str.trim().isEmpty();
	}
}

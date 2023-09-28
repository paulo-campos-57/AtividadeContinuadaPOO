package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class ValidadorCPF {

	private ValidadorCPF() {

	}

	public static boolean ehCpfValidado(String cpf) {
		int tamanho = cpf.length();

		// conferindo se todos os digitos deles são numeros
		// E se são 11 caracters
		if (cpf.matches("[0-9]+") && tamanho == 11) {
			/**
			 * TODO usar um algoritmo para saber se o cpf é verdadeiro
			 */

			return true;
		} else {
			return false;
		}
	}
}

package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class ValidadorCPF {

	private ValidadorCPF() {

	}

	public static boolean ehCpfValidado(String cpf) {
		int tamanho = cpf.length();
		
		//conferindo o primeiro caso da verificação do cpf
		int primeiroTeste = 10;
		int somaTotal = 0;
		int verdadeiroOuFalso1;
		int valorTotal = 0;
		
		for (int i=0; i<(tamanho-2); i++) {
			char caracter = cpf.charAt(i); //pega cada caracter da string
			int valor = Character.getNumericValue(caracter); //tranforma cada caracter da string em um int
			somaTotal += (valor*primeiroTeste); //multiplica cada caracter com n(i-1) e encrementa isso numa variavel
			primeiroTeste--; //vai diminuindo de 10 ate 2
		}
		valorTotal = (somaTotal*10)%11; //pega o resto de somaTotal*10
		
		if (valorTotal == 10) { //quando o resto da divisão é 10, o valor a ser encontrado é 0
			valorTotal = 0;
		}
		
		char penultimoCaracter = cpf.charAt(10); //pega o penultimo caracter da string
		int penultimoValor = Character.getNumericValue(penultimoCaracter); //transforma o ultimo caracter da string em in
		
		if(valorTotal == penultimoValor) { //se valorTotal for igual ao penultimo caracter isso que dizer que o primiero caso está correto
			verdadeiroOuFalso1 = 1;
		} else { //senão deu errado
			verdadeiroOuFalso1 = 0;
		}
		
		
		//conferindo o segundo caso da verificação do cpf
		int segundoTeste = 11;
		somaTotal = 0;
		int verdadeiroOuFalso2;
		valorTotal = 0;
		
		
		for (int i=0; i<(tamanho-1); i++) {
			char caracter = cpf.charAt(i); //pega o caracter de cada string
			int valor = Character.getNumericValue(caracter); //transforma cada caracter da string em int
			somaTotal += (valor*segundoTeste); //multiplica cada caracter com n(i-1) e incrementa isso numa variavel
			segundoTeste--; //vai diminuindo de 11 ate 2
		}
		
		valorTotal = (somaTotal*10)%11; //pega o resto da somaTotal * 10
		
		if (valorTotal == 10) { //se o resto for 10 tem que retornar 0
			valorTotal = 0;
		}
		
		char ultimoCaracter = cpf.charAt(11); //pega o ultimo caracter da string
		int ultimoValor = Character.getNumericValue(ultimoCaracter); //transforma o ultimo caracter da string em int
		
		if (valorTotal == ultimoCaracter) { //se o ultimo caraceter for igual ao rsto da divisão, então está correto o segundo caso de validação
			verdadeiroOuFalso2 = 1;
		} else { //senão deu errado
			verdadeiroOuFalso2 = 0;
		}
		
			
		

		// conferindo se todos os digitos deles são numeros
		// E se são 11 caracters
		// E conferindo se o cpf é verdadeiro
		if (cpf.matches("[0-9]+") && tamanho == 11 && verdadeiroOuFalso1 == 1 && verdadeiroOuFalso2 == 1) {

			return true;
		} else {
			return false;
		}
	}
}

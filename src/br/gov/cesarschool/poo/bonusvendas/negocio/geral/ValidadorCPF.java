package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class ValidadorCPF {
    // Construtor privado para impedir a instanciação da classe
    private ValidadorCPF() {
        // O construtor é privado para evitar a criação de instâncias da classe.
    }

    public static boolean ehCpfValido(String cpf) {
        // Verifica se a String de CPF possui o formato esperado
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }

        // Extrai os 9 primeiros dígitos do CPF como um array de inteiros
        int[] digitos = new int[9];
        for (int i = 0; i < 9; i++) {
            digitos[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Calcula o primeiro dígito verificador
        int primeiroDigito = calcularDigitoVerificador(digitos, 10);

        // Calcula o segundo dígito verificador
        int segundoDigito = calcularDigitoVerificador(digitos, 11);

        // Compara os dígitos verificadores calculados com os dois últimos dígitos do CPF
        return primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
               segundoDigito == Character.getNumericValue(cpf.charAt(10));
    }

    private static int calcularDigitoVerificador(int[] digitos, int pesoInicial) {
        int soma = 0;
        int peso = pesoInicial;

        for (int digito : digitos) {
            soma += digito * peso;
            peso--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }
}

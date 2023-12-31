package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;

public class VendedorMediator {
	private static VendedorMediator instance;
	private VendedorDAO repositorioVendedor;
	private AcumuloResgateMediator caixaDeBonusMediator;

	private VendedorMediator() {
		repositorioVendedor = new VendedorDAO();
		caixaDeBonusMediator = AcumuloResgateMediator.getInstancia();
	}

	/***
	 * 
	 * @return A instância única da classe VendedorMediator.
	 */
	public static VendedorMediator getInstancia() {
		if (instance == null) {
			instance = new VendedorMediator();
		}
		return instance;
	}

	/*
	 * FALTA TERMINAR ESSA FUNCAO, nao eh pra ser com o vendedor na linha 44, o numerocaixadebonus ta no ResultadoInclusaoVendedor
	 */
	public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
		String validacao = validar(vendedor);

		if (validacao != null) {
			// Se algum dado estiver inválido
			return new ResultadoInclusaoVendedor(0, validacao);
		} else {
			// Se os dados estiverem válidos
			long numeroCaixaBonus = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
//			vendedor.set(numeroCaixaBonus);
			repositorioVendedor.incluir(vendedor);
			return new ResultadoInclusaoVendedor(numeroCaixaBonus, null);
		}
	}

	public String alterar(Vendedor vendedor) {
		String validacao = validar(vendedor);

		if (validacao != null) {
			// Se algum dado estiver inválido
			return validacao;
		} else {
			// Se os dados estiverem válidos
			repositorioVendedor.alterar(vendedor);
			return null;
		}
	}

	/***
	 * 
	 * @param vendedor
	 * @return se a string é valida pros testes principalmente
	 */
	private String validar(Vendedor vendedor) {
		if (vendedor == null) {
			return "Vendedor é nulo.";
		}

		if (!ValidadorCPF.ehCpfValido(vendedor.getCpf())) {
			return "CPF inválido.";
		}

//		if (StringUtil.ehNuloOuBranco(vendedor.get())) {
//			return "Nome completo não informado.";
//		}

		if (vendedor.getSexo() == null) {
			return "Sexo não informado.";
		}

		if (vendedor.getDataNascimento() == null) {
			return "Data de nascimento não informada.";
		}

		LocalDate dataMinima = LocalDate.now().minusYears(17);
		if (vendedor.getDataNascimento().isAfter(dataMinima)) {
			return "Data de nascimento menor ou igual à data atual menos 17 anos.";
		}

		if (vendedor.getRenda() < 0) {
			return "Renda menor que zero.";
		}

		if (vendedor.getEndereco() == null) {
			return "Endereço igual a null.";
		}

		Endereco endereco = vendedor.getEndereco();
		if (StringUtil.ehNuloOuBranco(endereco.getLogradouro())) {
			return "Logradouro não informado.";
		}

		if (endereco.getLogradouro().length() < 4) {
			return "Logradouro com menos de 4 caracteres.";
		}

		if (endereco.getNumero() < 0) {
			return "Número menor que zero.";
		}

		if (StringUtil.ehNuloOuBranco(endereco.getCidade())) {
			return "Cidade não informada.";
		}

		if (StringUtil.ehNuloOuBranco(endereco.getEstado())) {
			return "Estado não informado.";
		}

		if (StringUtil.ehNuloOuBranco(endereco.getPais())) {
			return "País não informado.";
		}

		return null; // Retorna null se todos os dados estiverem válidos
	}

	public Vendedor buscar(String cpf) {
		return repositorioVendedor.buscar(cpf);
	}

}

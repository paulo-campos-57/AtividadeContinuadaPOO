package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

//import java.time.LocalDate;

//import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
//import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
//import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
//import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class AcumuloResgateMediator {
	// Instância única da classe (Singleton)
	private static AcumuloResgateMediator instance;

//     Atributos privados
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDAO repositorioLancamento;

	// Construtor privado
	private AcumuloResgateMediator() {
		// Inicializa os atributos com novas instâncias
		repositorioCaixaDeBonus = new CaixaDeBonusDAO();
		repositorioLancamento = new LancamentoBonusDAO();
	}

	/***
	 * Método público para obter a instância única
	 * 
	 * @return
	 */
	public static AcumuloResgateMediator getInstancia() {
		if (instance == null) {
			instance = new AcumuloResgateMediator();
		}
		return instance;
	}

	public long gerarCaixaDeBonus(Vendedor vendedor) {
		if (vendedor == null) {
			return 0; // Retorna zero se o vendedor for nulo
		}

		LocalDate dataAtual = LocalDate.now();
		String numeroCaixaDeBonus = vendedor.getCpf() + String.format("%04d%02d%02d", dataAtual.getYear(),
				dataAtual.getMonthValue(), dataAtual.getDayOfMonth());

		CaixaDeBonus caixaDeBonus = new CaixaDeBonus(Long.parseLong(numeroCaixaDeBonus));
		if (repositorioCaixaDeBonus.incluir(caixaDeBonus)) {
			return Long.parseLong(numeroCaixaDeBonus);
		} else {
			return 0; // Retorna zero se a caixa de bônus não for incluída no repositório
		}
	}

	public String acumularBonus(long numeroCaixaDeBonus, double valor) {
		if (valor <= 0) {
			return "Valor menor ou igual a zero";
		}
//
//	    CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscarCaixaDeBonus(numeroCaixaDeBonus);
//	    if (caixaDeBonus == null) {
//	        return "Caixa de bonus inexistente";
//	    }
//
//	    caixaDeBonus.creditar(valor); // Usando o método creditar da CaixaDeBonus
//	    repositorioCaixaDeBonus.atualizarCaixaDeBonus(caixaDeBonus);
//
//	    LancamentoBonusCredito lancamentoCredito = new LancamentoBonusCredito(caixaDeBonus, valor);
//	    repositorioLancamento.incluirLancamento(lancamentoCredito);

		return null;
	}

	public String resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo) {
		if (valor <= 0) {
			return "Valor menor ou igual a zero";
		}

//		CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscarCaixaDeBonus(numeroCaixaDeBonus);
//		if (caixaDeBonus == null) {
//			return "Caixa de bonus inexistente";
//		}
//
//		if (caixaDeBonus.getSaldo() < valor) {
//			return "Saldo insuficiente";
//		}
//
//		caixaDeBonus.debitar(valor); // Usando o método debitar da CaixaDeBonus
//		repositorioCaixaDeBonus.atualizarCaixaDeBonus(caixaDeBonus);
//
//		LancamentoBonusResgate lancamentoResgate = new LancamentoBonusResgate(caixaDeBonus, valor, tipo);
//		repositorioLancamento.incluirLancamento(lancamentoResgate);

		return null;
	}

}
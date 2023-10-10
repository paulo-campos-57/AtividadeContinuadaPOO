package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class LancamentoBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class);

	public boolean incluir(LancamentoBonus prod) {
		String numeroAsString = String.valueOf(prod.getNumeroCaixaDeBonus());
		LancamentoBonus prodBusca = buscar(numeroAsString);
		if (prodBusca != null) {
			return false;
		} else {
			cadastro.incluir(prod, BRANCO + prod.getNumeroCaixaDeBonus());
			return true;
		}
	}

	public boolean alterar(LancamentoBonus prod) {
		String numeroAsString = String.valueOf(prod.getNumeroCaixaDeBonus());

		LancamentoBonus prodBusca = buscar(numeroAsString);
		if (prodBusca == null) {
			return false;
		} else {
			cadastro.alterar(prod, BRANCO + prod.getNumeroCaixaDeBonus());
			return true;
		}
	}

	public LancamentoBonus buscar(String string) {

		return (LancamentoBonus) cadastro.buscar(BRANCO + string);
	}

	public LancamentoBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(LancamentoBonus.class);
		LancamentoBonus[] prods = new LancamentoBonus[rets.length];
		for (int i = 0; i < rets.length; i++) {

			prods[i] = (LancamentoBonus) rets[i];
		}
		return prods;
	}
}

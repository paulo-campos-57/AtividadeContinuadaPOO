package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

public class CaixaDeBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonus.class); 
	public boolean incluir(CaixaDeBonus prod) {
		CaixaDeBonus prodBusca = buscar(prod.getNumero()); 
		if (prodBusca != null) { 
			return false;
		} else {
			cadastro.incluir(prod, BRANCO + prod.getNumero());
			return true;
		}		 
	}
	public boolean alterar(CaixaDeBonus prod) {
		CaixaDeBonus prodBusca = buscar(prod.getNumero());
		if (prodBusca == null) {
			return false;
		} else {
			cadastro.alterar(prod, BRANCO + prod.getNumero());
			return true;
		}		
	}
	public CaixaDeBonus buscar(long codigo) {
		// Esta operação entre () vai ter significado mais à frente! 
		return (CaixaDeBonus)cadastro.buscar(BRANCO + codigo);
	}
	public CaixaDeBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(CaixaDeBonus.class);
		CaixaDeBonus[] prods = new CaixaDeBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			// Esta operação entre () vai ter significado mais à frente! 
			prods[i] = (CaixaDeBonus)rets[i];
		}
		return prods;
	}
}

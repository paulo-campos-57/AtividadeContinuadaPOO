package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class CaixaDeBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonusDAO.class); 
	public boolean incluir(CaixaDeBonusDAO prod) {
		CaixaDeBonusDAO prodBusca = buscar(prod.()); 
		if (prodBusca != null) { 
			return false;
		} else {
			cadastro.incluir(prod, BRANCO + prod.getCodigo());
			return true;
		}		 
	}
	public boolean alterar(CaixaDeBonusDAO prod) {
		CaixaDeBonusDAO prodBusca = buscar(prod.getCodigo());
		if (prodBusca == null) {
			return false;
		} else {
			cadastro.alterar(prod, BRANCO + prod.getCodigo());
			return true;
		}		
	}
	public CaixaDeBonusDAO buscar(long codigo) {
		// Esta operação entre () vai ter significado mais à frente! 
		return (CaixaDeBonusDAO)cadastro.buscar(BRANCO + codigo);
	}
	public CaixaDeBonusDAO[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(CaixaDeBonusDAO.class);
		CaixaDeBonusDAO[] prods = new CaixaDeBonusDAO[rets.length];
		for(int i=0; i<rets.length; i++) {
			// Esta operação entre () vai ter significado mais à frente! 
			prods[i] = (CaixaDeBonusDAO)rets[i];
		}
		return prods;
	}
}

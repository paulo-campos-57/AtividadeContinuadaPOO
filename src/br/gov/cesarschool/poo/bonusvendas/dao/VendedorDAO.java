package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);

	public boolean incluir(Vendedor prod) {
		Vendedor prodBusca = buscar(prod.getCpf());
		if (prodBusca != null) {
			return false;
		} else {
			cadastro.incluir(prod, BRANCO + prod.getCpf());
			return true;
		}
	}

	public boolean alterar(Vendedor prod) {
		Vendedor prodBusca = buscar(prod.getCpf());
		if (prodBusca == null) {
			return false;
		} else {
			cadastro.alterar(prod, BRANCO + prod.getCpf());
			return true;
		}
	}

	public Vendedor buscar(String string) {
		// Esta operação entre () vai ter significado mais à frente!
		return (Vendedor) cadastro.buscar(BRANCO + string);
	}

	public Vendedor[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(Vendedor.class);
		Vendedor[] prods = new Vendedor[rets.length];
		for (int i = 0; i < rets.length; i++) {
			// Esta operação entre () vai ter significado mais à frente!
			prods[i] = (Vendedor) rets[i];
		}
		return prods;
	}
}

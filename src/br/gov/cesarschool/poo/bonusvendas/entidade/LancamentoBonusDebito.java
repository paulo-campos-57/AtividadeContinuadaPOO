package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusDebito extends LancamentoBonus {

	private TipoResgate tipo;

	public LancamentoBonusDebito(long numeroCaixaDeBonus, int valor, LocalDateTime dataHoraLancamento) {
		super(numeroCaixaDeBonus, valor, dataHoraLancamento);
	}

	public TipoResgate getTipoResgate() {
		return tipo;
	}

}

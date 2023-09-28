package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusCredito extends LancamentoBonus{

	public LancamentoBonusCredito(long numeroCaixaDeBonus, int valor, LocalDateTime dataHoraLancamento) {
		super(numeroCaixaDeBonus, valor, dataHoraLancamento);
	}

}

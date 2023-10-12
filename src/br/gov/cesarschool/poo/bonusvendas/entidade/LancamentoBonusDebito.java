package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusDebito extends LancamentoBonus {

	private static final long serialVersionUID = 1L;
	private TipoResgate tipo;

	public LancamentoBonusDebito(long numeroCaixaDeBonus, double valor, LocalDateTime dataHoraLancamento) {
		super(numeroCaixaDeBonus, valor, dataHoraLancamento);
	}

	public TipoResgate getTipoResgate() {
		return tipo;
	}

}

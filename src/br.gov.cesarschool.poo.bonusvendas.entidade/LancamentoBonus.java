package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonus {
	private long numeroCaixaDeBonus;
	private int valor;
	private LocalDateTime dataHoraLancamento;

	public LancamentoBonus(long numeroCaixaDeBonus, int valor, LocalDateTime dataHoraLancamento) {
		super();
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = dataHoraLancamento;
	}

	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}

	public int getValor() {
		return valor;
	}

	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}

}

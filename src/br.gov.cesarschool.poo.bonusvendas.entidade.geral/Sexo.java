package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
	FEMININO(1, "feminino"), MASCULINO(2, "masculino");

	private final int codigo;
	private final String descricao;

	private Sexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
}

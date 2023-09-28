package br.gov.cesarschool.poo.bonusvendas.entidade;

public enum TipoResgate {
    PRODUTO(1, "produto"),
    SERVICO(2, "serviço"),
    CASH(3, "cash");

    private final int codigo;
    private final String descricao;

    private TipoResgate(int codigo, String descricao) {
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

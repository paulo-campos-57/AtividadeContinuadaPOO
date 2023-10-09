package br.gov.cesarschool.poo.bonusvendas.negocio;

public class AcumuloResgateMediator {
    // Instância única da classe (Singleton)
    private static AcumuloResgateMediator instance;
    
    // Atributos privados
    private CaixaDeBonusDAO repositorioCaixaDeBonus;
    private LancamentoBonusDAO repositorioLancamento;
    
    // Construtor privado
    private AcumuloResgateMediator() {
        // Inicializa os atributos com novas instâncias
        repositorioCaixaDeBonus = new CaixaDeBonusDAO();
        repositorioLancamento = new LancamentoBonusDAO();
    }
    
    // Método público para obter a instância única
    public static AcumuloResgateMediator getInstance() {
        if (instance == null) {
            instance = new AcumuloResgateMediator();
        }
        return instance;
    }
    
    // Outros métodos e funcionalidades da classe podem ser adicionados aqui
}
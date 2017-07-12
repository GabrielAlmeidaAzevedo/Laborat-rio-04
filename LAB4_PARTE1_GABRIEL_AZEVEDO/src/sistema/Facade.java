package sistema;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Classe "Fachada"
 */
public class Facade {

	private SistemaDeApostas sistema; // Declaração de sistema

	/**
	 * Função que instancia o sistema.
	 * 
	 * @param caixa
	 *            = Valor atual do caixa, em centavos.
	 * @param taxa
	 *            = porcentagem que deve ser retirada de cada aposta perdedora.
	 */
	public void incializa(int caixa, double taxa) {
		if (caixa < 0) {// Se o caixa for inicializado com valor negativo, lença
						// essa excessao.
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {// se a taxa for inicializada com valor negativo, lança
						// essa excessao.
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		sistema = new SistemaDeApostas(caixa, taxa);
	}

	/**
	 * 
	 * @return = quantia existente no caixa.
	 */
	public int getCaixa() {
		return sistema.getCaixa();
	}

	/**
	 * Metodo que adiciona um novo cenario com esta descricao ao array de
	 * cenarios de sistema.
	 * 
	 * @param descricao
	 *            = Hipotese futura sob a qual serao feitas as apostas.
	 * @return = numero do cenario cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		return sistema.novoCenario(descricao);
	}

	/**
	 * Metodo que exibe informacoes basicas de um cenario.
	 * 
	 * @param cenario
	 *            = numero do cenario que deve ser exbido.
	 * @return = string com as informacoes do cenario.
	 */
	public String exibirCenario(int cenario) {
		return sistema.exibeCenario(cenario);
	}

	/**
	 * Metodo que exibe todos os cenarios existentes no array de cenarios do
	 * sistema.
	 * 
	 * @return = string, em forma de lista, com todos os cenarios e suas
	 *         respectivas informacoes.
	 */
	public String exibirCenarios() {
		return sistema.exibirTodosCenarios();
	}

	/**
	 * Metodo que cadastra uma aposta em um determinado cenario.
	 * 
	 * @param cenario
	 *            = numero do cenario no qual deve ser cadastrado a aposta.
	 * @param apostador
	 *            = nome do apostador.
	 * @param valor
	 *            = valor da aposta.
	 * @param previsao
	 *            = string VAI OCORRER ou NAO VAI OCORRER.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		sistema.novaAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Metodo que soma todo o valor apostado em um cenario.
	 * 
	 * @param cenario
	 *            = numero do cenario sob o qual esse metodo deve operar.
	 * @return = int com o valor total.
	 */
	public int valorTotalDeApostas(int cenario) {
		return sistema.ValorTotalDeApostas(cenario);
	}

	/**
	 * Metodo que soma quantas apostas foram feitas nesse cenario.
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @return = total de apostas feitas nesse cenario.
	 */
	public int TotalDeApostas(int cenario) {
		return sistema.TotalDeApostas(cenario);
	}

	/**
	 * Metodo que lista todas as apostas desse cenario.
	 * 
	 * @param cenario
	 *            = numero do cenario cujas apostas devem ser exibidas.
	 * @return = string com todas as apostas e suas respectivas descricoes, em
	 *         forma de lista.
	 */
	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}

	/**
	 * Metodo que muda o parametro "estado" do cenario.
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @param ocorreu
	 *            = true ou false.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.encerrarAposta(cenario, ocorreu);
	}

	/**
	 * Metodo que calcula o valor destinado ao caixa de um determinado cenario
	 * ja fechado.
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @return valor destinado ao caixa do sistema.
	 */
	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}

	/**
	 * Metodo que calcula o valor total destinado aos ganhadores dado um cenario
	 * ja fechado.
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @return valor total destinado aos ganhadores.
	 */
	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}

}
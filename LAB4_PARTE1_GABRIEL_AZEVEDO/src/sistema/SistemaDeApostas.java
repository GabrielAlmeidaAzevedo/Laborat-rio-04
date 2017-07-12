package sistema;

import java.util.ArrayList;
import java.lang.Math;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Classe que gerencia as apostas.
 */
public class SistemaDeApostas {

	private int caixa;// declarando parametros.
	private final double taxa;
	private ArrayList<Cenario> cenarios;

	/**
	 * Construtor de sistema.
	 * 
	 * @param caixa
	 *            = valor inicial do caixa.
	 * @param taxa
	 *            = taxa cobrada sob cada aposta perdedora.
	 */
	public SistemaDeApostas(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<>();
	}

	/**
	 * 
	 * @return = valor atual do caixa.
	 */
	public int getCaixa() {
		return caixa;
	}

	/**
	 * 
	 * @return = valor da taxa.
	 */
	public double getTaxa() {
		return taxa;
	}

	/**
	 * Metodo que cria um novo cenario e o adiciona ao array de cenarios do
	 * sistema.
	 * 
	 * @param descricao
	 *            = Hipotese futura sob a qual serao feitas as apostas.
	 * @return = numeracao do cenario.
	 */
	public int novoCenario(String descricao) {
		if (descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		int index = cenarios.indexOf(cenario);
		cenarios.get(index).setNumeracao(index + 1);
		return cenarios.get(index).getNumeracao();
	}

	/**
	 * Metodo que gera uma representacao para cenario.
	 * 
	 * @param cenario
	 *            = nuemro do cenario
	 * @return = string com informacoes basicas do cenario.
	 */
	public String exibeCenario(int cenario) {
		if (cenario <= 0) {// Se o numero do cenario for negativo ou zero, lança
							// essa excessao.
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {// se nao existir no array de cenarios,
										// um cenario com esse numero, lança
										// essa excessao.
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return cenarios.get(cenario - 1).toString();
	}

	/**
	 * 
	 * @return = string com a representaca ode todos os cenarios existentes no
	 *         array de cenarios do sistema, linha por linha.
	 */
	public String exibirTodosCenarios() {
		String string_final = "";
		for (Cenario cenario : cenarios) {
			string_final += cenario.toString() + System.lineSeparator();
		}
		return string_final;
	}

	/**
	 * Metodo que cadastra uma nova aposta em determinado cenario.
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @param apostador
	 *            = nome do apostador.
	 * @param valor
	 *            = valor da aposta.
	 * @param previsao
	 *            = string VAI OCORRER ou NAO VAI OCORRER.
	 */
	public void novaAposta(int cenario, String apostador, int valor, String previsao) {
		cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
	}

	/**
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @return valor total das apostas feitas em determinado cenario.
	 */
	public int ValorTotalDeApostas(int cenario) {
		if (cenario <= 0) {// Se o numero do cenario for negativo ou zero, lança
							// essa excessao.
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (cenario > cenarios.size()) {// Se nao existir cenario com esse
										// numero, lança essa excessao.
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return cenarios.get(cenario - 1).ValorTotalDeApostas();
	}

	/**
	 * 
	 * @param cenario
	 *            = nuemero do cenario.
	 * @return = numero total de apostas feitas naquele cenario.
	 */
	public int TotalDeApostas(int cenario) {
		if (cenario <= 0) {// Se o numero do cenario for negativo ou zero, lança
							// essa excessao.
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (cenario > cenarios.size()) {// Se nao existir cenario com esse
										// numero, lança essa excessao.
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}

		return cenarios.get(cenario - 1).TotalDeApostas();
	}

	/**
	 * Metodo que retorna uma string com a representacao de cada aposta feita em
	 * um cenario, linha por linha.
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @return representacao das apostas.
	 */
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario - 1).exibeApostas();
	}

	/**
	 * Metodo que modifica o parametro "estado" de um cenario para finalizado.
	 * 
	 * @param cenario
	 *            = numero do cenario.
	 * @param ocorreu
	 *            = true ou false.
	 */
	public void encerrarAposta(int cenario, boolean ocorreu) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		cenarios.get(cenario - 1).fecharAposta(ocorreu);
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
		double Caixa_Taxa = 0;

		if (cenario <= 0) {// Se o numero do cenario for negativo ou zero, lança
							// essa excessao.
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {// Se nao existir cenario com esse
										// numero, lança essa excessao.
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}

		Caixa_Taxa = (cenarios.get(cenario - 1).getValorTotalApostasPerdedoras() * this.taxa);
		Caixa_Taxa = Math.floor(Caixa_Taxa);
		return (int) Caixa_Taxa;
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
		if (cenario <= 0) {// Se o numero do cenario for invalido, lança essa
							// excessao.
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {// Se o numero do cenario for positivo
										// porém nao existir no array, lança
										// essa excessao.
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		int total_Rateio = 0;
		total_Rateio = cenarios.get(cenario - 1).getValorTotalApostasPerdedoras() - this.getCaixaCenario(cenario);
		return total_Rateio;
	}

}

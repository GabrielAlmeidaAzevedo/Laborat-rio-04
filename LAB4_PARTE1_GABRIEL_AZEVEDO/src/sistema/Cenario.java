package sistema;

import java.util.ArrayList;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Classe Cenario
 */
public class Cenario {

	private String descricao; // Declara parametros.
	private EstadoCenario estado;
	private int numeracao;
	private ArrayList<Aposta> apostas;

	/**
	 * Construtor de Cenario.
	 * 
	 * @param descricao
	 *            = hipótese de uma situação que caracteriza o cenario.
	 */
	public Cenario(String descricao) {
		if (descricao == null) { // Se decricao for inicializada nula, lanca
									// essa excessao.
			throw new NullPointerException("ERRO - Descricao nula.");
		}
		if (descricao.trim().isEmpty()) { // Se descricao for inicializada
											// vazia, lanca essa excessao.
			throw new IllegalArgumentException("ERRO - Descrição do cenário vazia");
		}
		this.descricao = descricao; // instanciacao dos paramentros.
		this.estado = EstadoCenario.NAO_FINALIZADO; // Inicializando o estado do
													// cenario como nao
													// finalizado.
		this.apostas = new ArrayList<>();
	}

	/**
	 * Meotodo para numerar um cenario.
	 * 
	 * @param numeracao
	 *            = numero que o cenario deve ter.
	 */
	public void setNumeracao(int numeracao) {
		this.numeracao = numeracao;
	}

	/**
	 * 
	 * @return = numeracao do cenario.
	 */
	public int getNumeracao() {
		return this.numeracao;
	}

	/**
	 * 
	 * @return = enum que representa o estado do cenario.
	 */
	public String getEstado() {
		return estado.getEstado();
	}

	/**
	 * Metodo que calcula o valor total apostado em um cenario.
	 * 
	 * @return = valor total, em centavos.
	 */
	public int ValorTotalDeApostas() {
		int total = 0;
		for (Aposta aposta : apostas) {
			total += aposta.getValor();
		}
		return total;
	}

	/**
	 * Metodo que lista as apostas feitas.
	 * 
	 * @return string com as representacoes de cada aposta.
	 */
	public String exibeApostas() {
		String string_final = "";
		for (Aposta aposta : apostas) {
			string_final += aposta.toString() + System.lineSeparator(); // após
																		// a
																		// ultima,
																		// terá
																		// uma
																		// linha
																		// em
																		// braco.
		}
		return string_final;
	}

	/**
	 * 
	 * @return = quantidade de apostas feitas.
	 */
	public int TotalDeApostas() {
		return apostas.size();
	}

	/**
	 * Metodo que seta o estado do cenario.
	 * 
	 * @param estado
	 */
	public void setEstado(EstadoCenario estado) {
		this.estado = estado;
	}

	/**
	 * Metodo que baseado no boolean "ocorreu", seta o estado como finalizado.
	 * 
	 * @param ocorreu
	 *            = boolean true ou false.
	 */
	public void fecharAposta(boolean ocorreu) {
		if (this.estado == EstadoCenario.FINALIZADO_OCORREU || this.estado == EstadoCenario.FINALIZADO_NAO_OCORREU) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		if (ocorreu) {
			this.setEstado(EstadoCenario.FINALIZADO_OCORREU);
		} else {
			this.setEstado(EstadoCenario.FINALIZADO_NAO_OCORREU);
		}
	}

	/**
	 * Metodo que só funciona caso o cenario esteja encerrado.
	 * 
	 * @return = valor total das apostas perdedoras.
	 */
	public int getValorTotalApostasPerdedoras() {
		if (this.estado != EstadoCenario.FINALIZADO_OCORREU && this.estado != EstadoCenario.FINALIZADO_NAO_OCORREU) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto"); // Se
																													// o
																													// cenario
																													// estiver
																													// aberto,
																													// lança
																													// excessao.
		}
		int valor_total = 0;
		for (Aposta aposta : apostas) {
			if (!estado.getEstado().equals(aposta.getPrevisaoAposta().getPrevisao())
					&& !estado.getEstado().equals("Não finalizado")) {
				valor_total += aposta.getValor();
			}
		}
		return valor_total;
	}

	/**
	 * toString de cenario com suas informacoes basicas.
	 */
	@Override
	public String toString() {
		return this.numeracao + " - " + this.descricao + " - " + this.estado.getEstado();
	}

	/**
	 * Metodo que adiciona uma nova aposta no array de apostas do cenario.
	 * 
	 * @param apostador
	 *            = nome do apostador.
	 * @param valor
	 *            = valor apostado.
	 * @param previsao
	 *            = string VAI OCORRER ou NAO VAI OCORRER.
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		apostas.add(aposta);
	}

}
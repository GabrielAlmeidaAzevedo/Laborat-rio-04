package sistema;

public class Aposta {

	private String apostador; // Declarações dos parâmetros.
	private int valor;
	private PrevisaoAposta previsao;

	/**
	 * Construtor de Aposta.
	 * 
	 * @param apostador
	 *            = nome do apostador.
	 * @param valor
	 *            = valor apostado.
	 * @param previsao
	 *            = string VAI OCORRER ou NAO VAI OCORRER.
	 */
	public Aposta(String apostador, int valor, String previsao) {
		if (apostador == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo"); // Se
																												// o
																												// campo
																												// apostador
																												// for
																												// nulo
																												// lança
																												// essa
																												// excessao.
		}
		if (apostador.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo"); // Se
																													// o
																													// campo
																													// apostador
																													// for
																													// vazio,
																													// lança
																													// essa
																													// excessao.
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero"); // Se
																														// a
																														// aposta
																														// for
																														// zero
																														// ou
																														// menor,
																														// lança
																														// essa
																														// excessao.
		}
		if (previsao == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula"); // Se
																												// o
																												// campo
																												// previsao
																												// for
																												// nulo,
																												// lança
																												// essa
																												// excessao.
		}
		if (previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula"); // Se
																													// o
																													// campo
																													// previsao
																													// for
																													// vazio,
																													// lança
																													// essa
																													// excessao.
		}
		if (!previsao.equals("VAI ACONTECER") && !previsao.equals("NAO VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}

		this.apostador = apostador; // instanciando os parametros.
		this.valor = valor;
		this.previsao = DefinePrevisaoAposta(previsao); // chamada desse metodo
														// para converter String
														// previsao em um enum.
	}

	/**
	 * Metodo que qualifica a previsao do usuario em um enum.
	 * 
	 * @param previsao
	 *            = string recebida do usuario.
	 * @return enum Previsao.
	 */
	public PrevisaoAposta DefinePrevisaoAposta(String previsao) {
		if (previsao.equals("VAI ACONTECER")) {
			return PrevisaoAposta.VAI_ACONTECER;
		} else if (previsao.equals("NAO VAI ACONTECER")) {
			return PrevisaoAposta.NAO_VAI_ACONTECER;
		} else {
			throw new IllegalArgumentException("ERRO - Previsão inválida.");
		}
	}

	/**
	 * 
	 * @return = valor da aposta.
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * 
	 * @return = enum correspondente a previsao.
	 */
	public PrevisaoAposta getPrevisaoAposta() {
		return this.previsao;
	}

	/**
	 * 
	 * @return = nome do apostador.
	 */
	public String getApostador() {
		return apostador;
	}

	/**
	 * @return = Representacao em string, de uma aposta.
	 */
	@Override
	public String toString() {
		return this.apostador + " - " + "R$ " + (this.valor / 100) + "," + this.valor % 100 + " - " + this.previsao;
	}

}

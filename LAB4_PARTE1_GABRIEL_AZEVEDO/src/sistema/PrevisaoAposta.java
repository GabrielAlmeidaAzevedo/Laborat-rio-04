package sistema;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Enum PrevisaoAposta.
 */
public enum PrevisaoAposta {

	VAI_ACONTECER("Finalizado (ocorreu)"), NAO_VAI_ACONTECER("Finalizado (n ocorreu)");

	private final String previsao;

	private PrevisaoAposta(String previsao) {
		this.previsao = previsao;
	}

	public String getPrevisao() {
		return this.previsao;
	}

}

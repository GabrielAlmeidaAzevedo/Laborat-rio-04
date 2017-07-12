package sistema;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Enum EstadoCenario.
 */
public enum EstadoCenario {

	NAO_FINALIZADO("Não finalizado"), FINALIZADO_OCORREU("Finalizado (ocorreu)"), FINALIZADO_NAO_OCORREU(
			"Finalizado (n ocorreu)");

	private final String estado;

	private EstadoCenario(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}

}

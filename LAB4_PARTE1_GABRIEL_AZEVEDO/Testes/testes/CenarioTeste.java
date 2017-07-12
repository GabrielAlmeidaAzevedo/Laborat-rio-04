package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Aposta;
import sistema.Cenario;
import sistema.EstadoCenario;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Classe de Teste Cenario
 */
public class CenarioTeste {

	private Cenario cenario1; // Declarando parametros.
	private Cenario cenario2;

	/**
	 * Antes de cada teste, realiza essas instrucoes.
	 */
	@Before
	public void testCenario() {
		cenario1 = new Cenario("A maioria irá tirar mais do que 7 na prova!");
		cenario2 = new Cenario("O professor irá para a aula sobre GRASP com um café!");
		cenario1.setNumeracao(1);
		cenario2.setNumeracao(2);
	}

	/**
	 * Testa construtor de Cenario, o metodo setNumeracao e tambem o toString.
	 */
	@Test
	public void testConstrutorESetNumeracaoEToStringCenario() {
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado", cenario1.toString());
		assertEquals("2 - O professor irá para a aula sobre GRASP com um café! - Não finalizado", cenario2.toString());
	}

	/**
	 * Testa o metodo setNumeracao
	 */
	@Test
	public void testSetNumeracao() {
		cenario1.setNumeracao(5);
		assertEquals(5, cenario1.getNumeracao());
	}

	/**
	 * Testa o metodo GetNumeracao.
	 */
	@Test
	public void testGetNumeracao() {
		assertEquals(2, cenario2.getNumeracao());
		assertEquals(1, cenario1.getNumeracao());
	}

	/**
	 * Cadastra varias apostas e testa se o metodo ValorTotalDeApostas retorna o
	 * valor total delas.
	 */
	@Test
	public void testValorTotalDeApostas() {
		cenario1.cadastrarAposta("Matheus Gaudencio", 10000, "VAI ACONTECER");
		cenario1.cadastrarAposta("Francisco Cisco", 20000, "NAO VAI ACONTECER");
		cenario1.cadastrarAposta("Anonimo", 199, "NAO VAI ACONTECER");
		cenario1.cadastrarAposta("Livia Maria", 30000, "VAI ACONTECER");
		cenario1.cadastrarAposta("Raquel Lopes", 20000, "VAI ACONTECER");
		cenario1.cadastrarAposta("Matheus Gaudencio", 10000, "VAI ACONTECER");
		assertEquals(90199, cenario1.ValorTotalDeApostas());
	}

	/**
	 * Cadastra apostas e Testa o metodo ExibeApostas.
	 */
	@Test
	public void testExibeApostas() {
		cenario2.cadastrarAposta("Joao Victor", 500000, "VAI ACONTECER");
		cenario2.cadastrarAposta("Joberson", 200000, "NAO VAI ACONTECER");
		assertEquals("Joao Victor - R$ 5000,0 - VAI_ACONTECER" + System.lineSeparator()
				+ "Joberson - R$ 2000,0 - NAO_VAI_ACONTECER" + System.lineSeparator(), cenario2.exibeApostas());
	}

	/**
	 * Cadastra apostas em cenarios e testa o metodo TotalDeApostas.
	 */
	@Test
	public void testTotalDeApostas() {
		cenario1.cadastrarAposta("Matheus Gaudencio", 10000, "VAI ACONTECER");
		cenario1.cadastrarAposta("Francisco Cisco", 20000, "NAO VAI ACONTECER");
		cenario1.cadastrarAposta("Anonimo", 199, "NAO VAI ACONTECER");
		assertEquals(3, cenario1.TotalDeApostas());
		cenario2.cadastrarAposta("Joao Victor", 500000, "VAI ACONTECER");
		cenario2.cadastrarAposta("Joberson", 200000, "NAO VAI ACONTECER");
		assertEquals(2, cenario2.TotalDeApostas());
	}

	/**
	 * Testa os metodos getEstado e setEstado.
	 */
	@Test
	public void testGetESetEstado() {
		assertEquals("Não finalizado", cenario1.getEstado());
		cenario1.setEstado(EstadoCenario.FINALIZADO_OCORREU);
		assertEquals("Finalizado (ocorreu)", cenario1.getEstado());
	}

	/**
	 * Testa o metodo FecharCenario atraves do metodo getEstado.
	 */
	@Test
	public void testFecharCenario() {
		cenario1.fecharAposta(true);
		assertEquals("Finalizado (ocorreu)", cenario1.getEstado());
		cenario1.fecharAposta(false);
		assertEquals("Finalizado (n ocorreu)", cenario1.getEstado());
	}

	/**
	 * Cadastra varias apostas, feca cenario e testa o
	 * metodoValorTotalApostasPerdedoras.
	 */
	@Test
	public void testGetValorTotalApostasPerdedoras() {
		cenario1.cadastrarAposta("Matheus Gaudencio", 10000, "VAI ACONTECER");
		cenario1.cadastrarAposta("Francisco Cisco", 20000, "NAO VAI ACONTECER");
		cenario1.cadastrarAposta("Anonimo", 199, "NAO VAI ACONTECER");
		cenario1.cadastrarAposta("Livia Maria", 30000, "VAI ACONTECER");
		cenario1.cadastrarAposta("Raquel Lopes", 20000, "VAI ACONTECER");
		cenario1.cadastrarAposta("Matheus Gaudencio", 10000, "VAI ACONTECER");
		cenario1.fecharAposta(true);
		assertEquals(20199, cenario1.getValorTotalApostasPerdedoras());
	}

	/**
	 * Testa o toString de Cenario.
	 */
	@Test
	public void testToString() {
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado", cenario1.toString());
		cenario2.setEstado(EstadoCenario.FINALIZADO_OCORREU);
		assertEquals("2 - O professor irá para a aula sobre GRASP com um café! - Finalizado (ocorreu)",
				cenario2.toString());
	}

}

package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Cenario;
import sistema.SistemaDeApostas;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Classe de Teste SistemaDeApostas
 */
public class SistemaDeApostasTeste {

	private SistemaDeApostas sistema; // Declaracao de parametros.
	private SistemaDeApostas sistema1;
	private SistemaDeApostas sistema2;

	/**
	 * Antes de cada teste realiza essas instrucoes.
	 */
	@Before
	public void testSistemaDeApostas() {
		sistema = new SistemaDeApostas(0, 0.1);
		sistema.novoCenario("Mais da metade da classe vai passar em LP2");
		sistema.novaAposta(1, "Gabriel", 200, "NAO VAI ACONTECER");
		sistema.novaAposta(1, "Thiago", 800, "VAI ACONTECER");
		sistema1 = new SistemaDeApostas(100000, 0.01);
		sistema2 = new SistemaDeApostas(900000, 0.25);
	}

	/**
	 * Testa o construtor de SistemaDeApostas atraves do metodo getCaixa.
	 */
	@Test
	public void testConstrutorSistemaDeApostas() {
		SistemaDeApostas sistema = new SistemaDeApostas(800, 0.05);
		assertEquals(800, sistema.getCaixa());
		assertEquals(0.05, sistema.getTaxa(), 0.00);
	}

	/**
	 * Testa o metodo getCaixa.
	 */
	@Test
	public void testGetCaixa() {
		assertEquals(100000, sistema1.getCaixa());
		assertEquals(900000, sistema2.getCaixa());
	}

	/**
	 * Testa se um novo cenario foi adicionado e o metodo ExibirTodosCenarios.
	 */
	@Test
	public void testNovoCenarioEExibirTodosCenarios() {
		assertEquals("", sistema1.exibirTodosCenarios());
		assertEquals(1, sistema1.novoCenario("A maioria irá tirar mais do que 7 na prova!"));
		assertEquals("1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado" + System.lineSeparator(),
				sistema1.exibirTodosCenarios());
	}

	/**
	 * Testa se o metodo exibeCenario esta correto.
	 */
	@Test
	public void testExibeCenario() {
		sistema1.novoCenario("A maioria irá tirar mais do que 7 na prova!");
		sistema1.novoCenario("O professor irá para a aula sobre GRASP com um café!");
		assertEquals("2 - O professor irá para a aula sobre GRASP com um café! - Não finalizado",
				sistema1.exibeCenario(2));
	}

	/**
	 * Cria um novo cenaroi, adiciona apsotas a ele e testa o metodo
	 * TotalDeApostas.
	 */
	@Test
	public void testNovaApostaETotalDeApostas() {
		sistema1.novoCenario("A maioria irá tirar mais do que 7 na prova!");
		sistema1.novaAposta(1, "Lucas", 200, "NAO VAI ACONTECER");
		assertEquals(1, sistema1.TotalDeApostas(1));
		sistema1.novaAposta(1, "Rafinha", 100, "VAI ACONTECER");
		assertEquals(2, sistema1.TotalDeApostas(1));
	}

	/**
	 * Testa o metodo ValorTotalDeApostas.
	 */
	@Test
	public void testValorTotalDeApostas() {
		assertEquals(1000, sistema.ValorTotalDeApostas(1));
	}

	/**
	 * Testa se o metodo ExibeApostas esta correto.
	 */
	@Test
	public void testExibeApostas() {
		assertEquals("Gabriel - R$ 2,0 - NAO_VAI_ACONTECER" + System.lineSeparator() + "Thiago - R$ 8,0 - VAI_ACONTECER"
				+ System.lineSeparator(), sistema.exibeApostas(1));
	}

	/**
	 * Usa o metodo exibeCenario para testar se o metodo EncerrarCenario esta
	 * correto.
	 */
	@Test
	public void testEncerrarCenario() {
		assertEquals("1 - Mais da metade da classe vai passar em LP2 - Não finalizado", sistema.exibeCenario(1));
		sistema.encerrarAposta(1, true);
		assertEquals("1 - Mais da metade da classe vai passar em LP2 - Finalizado (ocorreu)", sistema.exibeCenario(1));
	}

	/**
	 * Encerra cenario, e testa se o metodo GetCaixaCenario opera corretamente
	 * quando o cenario eh encerrado com true e com false.
	 */
	@Test
	public void testGetCaixaCenario() {
		sistema.encerrarAposta(1, true);
		assertEquals(20, sistema.getCaixaCenario(1));
		sistema.encerrarAposta(1, false);
		assertEquals(80, sistema.getCaixaCenario(1));
	}

	/**
	 * Encerra cenario e testa se o metodo GetTotalRateioCenaro esta correto.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		sistema.encerrarAposta(1, true);
		assertEquals(180, sistema.getTotalRateioCenario(1));
		sistema.encerrarAposta(1, false);
		assertEquals(720, sistema.getTotalRateioCenario(1));
	}

}

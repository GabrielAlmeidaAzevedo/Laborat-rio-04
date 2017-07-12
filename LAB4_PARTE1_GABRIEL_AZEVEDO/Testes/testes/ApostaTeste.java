package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Aposta;
import sistema.PrevisaoAposta;

/**
 * 
 * @author Gabriel Almeida Azevedo - mat - 116210009 LAB04
 *
 *         Classe de Teste
 */
public class ApostaTeste {

	private Aposta aposta1; // Declaracao de parametros.
	private Aposta aposta2;
	private Aposta aposta3;
	private Aposta aposta4;
	private Aposta aposta5;
	private Aposta aposta6;

	/**
	 * Antes de cad metodo, instancia esses parametros.
	 */
	@Before
	public void criaAposta() {
		aposta1 = new Aposta("Matheus Gaudencio", 10000, "VAI ACONTECER");
		aposta2 = new Aposta("Francisco Cisco", 20000, "NAO VAI ACONTECER");
		aposta3 = new Aposta("Anonimo", 199, "NAO VAI ACONTECER");
		aposta4 = new Aposta("Livia Maria", 30000, "VAI ACONTECER");
		aposta5 = new Aposta("Raquel Lopes", 20000, "VAI ACONTECER");
		aposta6 = new Aposta("Matheus Gaudencio", 10000, "VAI ACONTECER");
	}

	/**
	 * Testa o constroturo de Aposta.
	 */
	@Test
	public void testConstrutorAposta() {
		assertEquals(PrevisaoAposta.VAI_ACONTECER, aposta1.getPrevisaoAposta());
		assertEquals(10000, aposta1.getValor());
		assertEquals("Matheus Gaudencio", aposta1.getApostador());
	}

	/**
	 * Testa se esta sendo lançada excessao quando o parametro "apostador" eh
	 * inicializado nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testNomeNuloConstrutorAposta() {
		Aposta aposta = new Aposta(null, 10000, "VAI ACONTECER");
	}

	/**
	 * Testa se esta sendo lançada excessao quando o parametro "previsao" eh
	 * inicializado nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testPrevisaoNulaConstrutorAposta() {
		Aposta aposta = new Aposta("Joao", 10000, null);
	}

	/**
	 * Testa se esta sendo lançada excessao quando o parametro "apostador" eh
	 * inicializado vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNomeVazioConstrutorAposta() {
		Aposta aposta = new Aposta("      ", 10000, "VAI ACONTECER");
	}

	/**
	 * Testa se esta sendo lançada excessao quando o parametro "valor" eh
	 * inicializado zerado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorZeradoConstrutorAposta() {
		Aposta aposta = new Aposta("José", 0, "VAI ACONTECER");
	}

	/**
	 * Testa se esta sendo lançada excessao quando o parametro "valor" eh
	 * inicializado negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorNegativoConstrutorAposta() {
		Aposta aposta = new Aposta("José", -500, "VAI ACONTECER");
	}

	/**
	 * Testa o metodo getValor.
	 */
	@Test
	public void testGetValor() {
		assertEquals(20000, aposta5.getValor());
		assertEquals(30000, aposta4.getValor());
	}

	/**
	 * Testa o etodo getPrevisaoAposta.
	 */
	@Test
	public void testGetPrevisaoAposta() {
		assertEquals(PrevisaoAposta.VAI_ACONTECER, aposta1.getPrevisaoAposta());
		assertEquals(PrevisaoAposta.NAO_VAI_ACONTECER, aposta2.getPrevisaoAposta());
	}

	/**
	 * Testa o toString de Aposta.
	 */
	@Test
	public void testToString() {
		assertEquals("Anonimo - R$ 1,99 - NAO_VAI_ACONTECER", aposta3.toString());
		assertEquals("Livia Maria - R$ 300,0 - VAI_ACONTECER", aposta4.toString());
	}

}

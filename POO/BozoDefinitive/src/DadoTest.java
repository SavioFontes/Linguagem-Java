import static org.junit.Assert.*;

import org.junit.Test;

public class DadoTest {

	private Dado dado;
	
	//Verifica a funcao SetLado()
	@Test
	public void testSetLado() {
		dado = new Dado();
		int k = 6;
		dado.setLado(k);
		assertEquals(k,dado.getLado());
	}
	
	//Verifica a funcao GetLado()
	@Test
	public void testGetLado() {
		dado = new Dado();
		int k = 6;
		dado.setLado(k);
		assertEquals(k,dado.getLado());
	}

	//Verifica a funcao Main() - Ela não faz nada
	@Test
	public void testMain() {
		dado = new Dado();
		dado.main(null);
		
	}

	//Verifica a funcao Rolar()
	@Test
	public void testRolar() {
		dado = new Dado();
		dado.rolar();
		int k = dado.getLado();
		assertEquals(k,dado.getLado());
	}

	//Testa as funcoes GetLados() e Dado()
	@Test
	public void testGetLadosEDado() {
		dado = new Dado();
		int k = 6;
		assertEquals(k,dado.getLados());
	}

	//Verifica a funcao Dado(int k) - Construtor
	@Test
	public void testDadoInt() {
		dado = new Dado(7);
		assertEquals(7,dado.getLados());
	}

	//Verifica a funcao toString para dado com valor 1
	@Test
	public void testToString1() {
		String r = "+-----+"+ "\n" + "|     |" + "\n" + "|  *  |" + "\n" + "|     |" + "\n" + "+-----+"+ "\n";
		dado = new Dado();
		dado.setLado(1);
		assertEquals(r,dado.toString());
	}

	//Verifica a funcao toString para dado com valor 2
	@Test
	public void testToString2() {
		String r = "+-----+"+ "\n" + "|*    |" + "\n" + "|     |" + "\n" + "|    *|" + "\n" + "+-----+"+ "\n";
		dado = new Dado();
		dado.setLado(2);
		assertEquals(r,dado.toString());
	}
	
	//Verifica a funcao toString para dado com valor 3
	@Test
	public void testToString3() {
		String r = "+-----+"+ "\n" + "|*    |" + "\n" + "|  *  |" + "\n" + "|    *|" + "\n" + "+-----+"+ "\n";
		dado = new Dado();
		dado.setLado(3);
		assertEquals(r,dado.toString());
	}
	
	//Verifica a funcao toString para dado com valor 4
	@Test
	public void testToString4() {
		String r = "+-----+"+ "\n" + "|*   *|" + "\n" + "|     |" + "\n" + "|*   *|" + "\n" + "+-----+"+ "\n";
		dado = new Dado();
		dado.setLado(4);
		assertEquals(r,dado.toString());
	}
	
	//Verifica a funcao toString para dado com valor 5
	@Test
	public void testToString5() {
		String r = "+-----+"+ "\n" + "|*   *|" + "\n" + "|  *  |" + "\n" + "|*   *|" + "\n" + "+-----+"+ "\n";
		dado = new Dado();
		dado.setLado(5);
		assertEquals(r,dado.toString());
	}
	
	//Verifica a funcao toString para dado com valor 6
	@Test
	public void testToString6() {
		String r = "+-----+"+ "\n" + "|*   *|" + "\n" + "|*   *|" + "\n" + "|*   *|" + "\n" + "+-----+"+ "\n";
		dado = new Dado();
		dado.setLado(6);
		assertEquals(r,dado.toString());
	}
	
	//Verifica a funcao toString para dado com valor 7 ou mais
	@Test
	public void testToString7() {
		String r = "7" + "\n";
		dado = new Dado(7);
		dado.setLado(7);
		assertEquals(r,dado.toString());
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class RolaDadosTest {

	private RolaDados d;
	private int[] nulo = {0,0,0,0,0};
	
	//verifica se cria o objeto
	@Test
	public void testRolaDados() {
		d = new RolaDados(5);
		assertNotNull(d);
	}

	//Verifica a funcao main() - ela nao faz nada
	@Test
	public void testMain() {
		d = new RolaDados(5);
		d.main(null);
	}

	//Verifica a funcao Rolar()
	@Test
	public void testRolar() {
		d = new RolaDados(5);
		d.setValores(new int[] {-1,-2,-3,-4,-5});
		int[] k = d.rolar();
		assertNotEquals(nulo,k);
	}

	//verifica a funcao Rolar(boolean[] quais)
	@Test
	public void testRolarBooleanArray() {
		d = new RolaDados(5);
		d.rolar();
		boolean[] a = {true,false,true,false,true};
		int[] k = d.rolar(a);
		int[] l = d.rolar(""); //é para só retornar o vetor e não alterá-lo
		assertArrayEquals(k,l);
	}

	//testa a funcao Rolar(String s)
	@Test
	public void testRolarString1() {
		d = new RolaDados(5);
		d.rolar();
		int[] k = d.rolar("1 3 5");
		int[] l = d.rolar(""); //é para só retornar o vetor e não alterá-lo
		assertArrayEquals(k,l);
	}

	//testa a funcao Rolar(String s) - Caso seje escrito um numero de dado, maior que os disponiveis
	@Test
	public void testRolarString2() {
		d = new RolaDados(5);
		d.setValores(nulo);
		int[] k = d.rolar("1 2 3 6 5");
		assertEquals(0,k[3]);
	}
	
	//testa a funcao Rolar(String s) - Caso seje escrito um numero de dado, menor que os disponiveis
	@Test
	public void testRolarString3() {
		d = new RolaDados(5);
		d.setValores(nulo);
		int[] k = d.rolar("1 2 3 -1 5");
		assertEquals(0,k[3]);
	}
	
	//Testa a funcao toString()
	@Test
	public void testToString1() {
		String r = " 1          2          3          4          5         " + "\n" +
				"+-----+    +-----+    +-----+    +-----+    +-----+    " + "\n" +
				"|     |    |*    |    |*    |    |*   *|    |*   *|    " + "\n" +
				"|  *  |    |     |    |  *  |    |     |    |  *  |    " + "\n" +
				"|     |    |    *|    |    *|    |*   *|    |*   *|    " + "\n" +
				"+-----+    +-----+    +-----+    +-----+    +-----+    " + "\n";
		d = new RolaDados(5);
		d.setValores(new int[] {1,2,3,4,5});
		assertEquals(r,d.toString());
	}

	//testa a funcao toString()
	@Test
	public void testToString2() {
		String r = " 1          2          3          4          5         " + "\n" +
				"+-----+    +-----+    +-----+    +-----+    +-----+    " + "\n" +
				"|*    |    |*    |    |*    |    |*   *|    |*   *|    " + "\n" +
				"|  *  |    |     |    |  *  |    |*   *|    |  *  |    " + "\n" +
				"|    *|    |    *|    |    *|    |*   *|    |*   *|    " + "\n" +
				"+-----+    +-----+    +-----+    +-----+    +-----+    " + "\n";
		d = new RolaDados(5);
		d.setValores(new int[] {3,2,3,6,5});
		assertEquals(r,d.toString());
	}
}

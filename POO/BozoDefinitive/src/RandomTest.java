import static org.junit.Assert.*;

import org.junit.Test;

public class RandomTest {

	public Random r;
	
	//Teste da função que gera um double para multiplicar pelo valor maximo
	@Test
	public void testGetRand() {
		r = new Random(15);
		double a = r.getRand();
		assertEquals(0.10181112214922905,a,0);
	}

	//Teste getIntRand() - funcao para gerar um numero aleatorio entre o minimo e maximo
	@Test
	public void testGetIntRand() {
		r = new Random(15);
		int k = r.getIntRand(500);
		assertEquals(50,k);
	}

	//teste SetSemente() - funcao para definir a semente
	@Test
	public void testSetSemente() {
		r = new Random();
		r.setSemente(15);
		int k = r.getIntRand(500);
		assertEquals(50,k);
	}

	//Teste Random(int k) - funcao que cria o objeto com a semente k
	@Test
	public void testRandomInt() {
		r = new Random(15);
		int k = r.getIntRand(500);
		assertEquals(50,k);
	}

	/*
	 * Construtor padrao, gera uma semente com base em Calendar.getInstance().getTimeInMillis()%p; e espera um tempo, para os dados gerarem numeros diferentes
	@Test
	public void testRandom() {
		fail("Not yet implemented");
	}
	*/
}

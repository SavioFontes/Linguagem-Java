import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlacarTest {

	private Placar p;
	
	//Teste para adicionar em posicao acima de 10
	@Test (expected = BozoException.class)
	public void testAddPosInv1() throws BozoException{
		p = new Placar();
		p.add(11, new int[] {1,2,3,4,5});
	}
	
	//Teste para adicionar em posicao abaixo de 1
	@Test (expected = BozoException.class)
	public void testAddPosInv2() throws BozoException{
		p = new Placar();
		p.add(-1, new int[] {1,2,3,4,5});
	}
	
	//Teste para adicionar em posicao ja utilizada
	@Test (expected = BozoException.class)
	public void testAddPosUtilizada() throws BozoException{
		p = new Placar();
		p.add(1, new int[] {1,2,3,4,5});
		p.add(1, new int[] {1,2,3,4,5});
	}
	
	//Teste para adicionar na posicao 1
	@Test
	public void testAddPos1() throws BozoException{
		p = new Placar();
		p.add(1, new int[] {1,2,3,4,5});
		assertEquals(1,p.getScore());
	}

	//Teste para adicionar na posicao 2
	@Test
	public void testAddPos2() throws BozoException{
		p = new Placar();
		p.add(2, new int[] {1,2,3,2,2});
		assertEquals(6,p.getScore());
	}
	
	//Teste para adicionar na posicao 3
	@Test
	public void testAddPos3() throws BozoException{
		p = new Placar();
		p.add(3, new int[] {1,2,6,4,5});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 4
	@Test
	public void testAddPos4() throws BozoException{
		p = new Placar();
		p.add(4, new int[] {5,2,3,4,5});
		assertEquals(4,p.getScore());
	}
	
	//Teste para adicionar na posicao 5
	@Test
	public void testAddPos5() throws BozoException{
		p = new Placar();
		p.add(5, new int[] {1,2,3,4,5});
		assertEquals(5,p.getScore());
	}
	
	//Teste para adicionar na posicao 6
	@Test
	public void testAddPos6() throws BozoException{
		p = new Placar();
		p.add(6, new int[] {1,6,6,6,5});
		assertEquals(18,p.getScore());
	}
	
	//Teste para adicionar na posicao 7 - fora do conjunto de pontuacao
	@Test
	public void testAddPos7_1() throws BozoException{
		p = new Placar();
		p.add(7, new int[] {1,6,6,6,5});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 7 - fora do conjunto de pontuacao
	@Test
	public void testAddPos7_2() throws BozoException{
		p = new Placar();
		p.add(7, new int[] {1,6,6,2,1});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 7 - uma quina
	@Test
	public void testAddPos7_3() throws BozoException{
		p = new Placar();
		p.add(7, new int[] {6,6,6,6,6});
		assertEquals(15,p.getScore());
	}
	
	//Teste para adicionar na posicao 7 - uma dupla e uma trinca
	@Test
	public void testAddPos7_4() throws BozoException{
		p = new Placar();
		p.add(7, new int[] {3,6,3,6,3});
		assertEquals(15,p.getScore());
	}
	
	//Teste para adicionar na posicao 8 - uma sequencia de 1 a 5
	@Test
	public void testAddPos8_1() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {1,4,2,3,5});
		assertEquals(20,p.getScore());
	}
	
	//Teste para adicionar na posicao 8 - uma sequencia de 2 a 6
	@Test
	public void testAddPos8_2() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {2,6,4,3,5});
		assertEquals(20,p.getScore());
	}
	
	//Teste para adicionar na posicao 8 - fora do conjunto de pontuacao
	@Test
	public void testAddPos8_3() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {1,6,6,6,5});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 8 - fora do conjunto de pontuacao
	@Test
	public void testAddPos8_4() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {2,6,6,6,5});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 8 - fora do conjunto de pontuacao
	@Test
	public void testAddPos8_5() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {6,6,6,6,6});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 8 - fora do conjunto de pontuacao
	@Test
	public void testAddPos8_6() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {5,4,5,4,1});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 9 - fora do conjunto de pontuacao
	@Test
	public void testAddPos9_1() throws BozoException{
		p = new Placar();
		p.add(9, new int[] {1,6,6,3,5});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 9 - uma quadra
	@Test
	public void testAddPos9_2() throws BozoException{
		p = new Placar();
		p.add(9, new int[] {6,6,6,6,5});
		assertEquals(30,p.getScore());
	}
	
	//Teste para adicionar na posicao 10 - fora do conjunto de pontuacao
	@Test
	public void testAddPos10_1() throws BozoException{
		p = new Placar();
		p.add(10, new int[] {1,6,6,6,5});
		assertEquals(0,p.getScore());
	}
	
	//Teste para adicionar na posicao 10 - uma quina
	@Test
	public void testAddPos10_2() throws BozoException{
		p = new Placar();
		p.add(10, new int[] {6,6,6,6,6});
		assertEquals(40,p.getScore());
	}
	
	//Teste para score vazio
	@Test
	public void testGetScoreVazio() {
		p = new Placar();
		assertEquals(0,p.getScore());
	}
	
	//Teste para verificar a soma do score
	@Test
	public void testGetScoreMeioCheio() throws BozoException{
		p = new Placar();
		p.add(1, new int[] {1,2,3,4,5});
		p.add(3, new int[] {1,2,6,4,5});
		p.add(6, new int[] {1,6,6,6,5});
		p.add(5, new int[] {1,2,3,4,5});
		assertEquals(24,p.getScore());
	}
	
	//Teste adicionando em todas as posicoes
	@Test
	public void testGetScoreCheio() throws BozoException{
		p = new Placar();
		p.add(1, new int[] {1,2,3,4,5});
		p.add(2, new int[] {1,2,6,4,5});
		p.add(3, new int[] {1,6,6,6,5});
		p.add(4, new int[] {1,2,3,4,5});
		p.add(5, new int[] {1,2,3,4,5});
		p.add(6, new int[] {1,2,3,4,5});
		p.add(7, new int[] {1,2,3,4,5});
		p.add(8, new int[] {1,2,3,4,5});
		p.add(9, new int[] {2,2,2,2,5});
		p.add(10, new int[] {1,2,3,4,5});
		assertEquals(62,p.getScore());
	}

	//Teste placar - vazio
	@Test
	public void testToStringVazio() throws BozoException{
		p = new Placar();
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 1
	@Test
	public void testToStringPos1() throws BozoException{
		p = new Placar();
		p.add(1, new int[] {1,2,3,4,5});
		String r =     " 1     |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 2, com um digito no placar
	@Test
	public void testToStringPos2_1() throws BozoException{
		p = new Placar();
		p.add(2, new int[] {1,2,3,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				" 2     |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 2, com dois digitos no placar
	@Test
	public void testToStringPos2_2() throws BozoException{
		p = new Placar();
		p.add(2, new int[] {2,2,2,2,2});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"10     |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}

	//Teste placar - Posicao 3, com um digito no placar
	@Test
	public void testToStringPos3_1() throws BozoException{
		p = new Placar();
		p.add(3, new int[] {1,2,3,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				" 3     |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 3, com dois digitos no placar
	@Test
	public void testToStringPos3_2() throws BozoException{
		p = new Placar();
		p.add(3, new int[] {3,3,3,3,2});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"12     |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 4, com um digito no placar
	@Test
	public void testToStringPos4_1() throws BozoException{
		p = new Placar();
		p.add(4, new int[] {1,2,3,4,5});
		String r =     "(1)    |   (7)    |    4  "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 4, com dois digitos no placar
	@Test
	public void testToStringPos4_2() throws BozoException{
		p = new Placar();
		p.add(4, new int[] {4,2,4,4,2});
		String r =     "(1)    |   (7)    |   12  "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 5, com um digito no placar
	@Test
	public void testToStringPos5_1() throws BozoException{
		p = new Placar();
		p.add(5, new int[] {1,2,3,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |    5  "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 5, com dois digitos no placar
	@Test
	public void testToStringPos5_2() throws BozoException{
		p = new Placar();
		p.add(5, new int[] {5,5,2,2,2});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   10  "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 6, com um digito no placar
	@Test
	public void testToStringPos6_1() throws BozoException{
		p = new Placar();
		p.add(6, new int[] {1,2,1,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |    0  "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 6, com dois digitos no placar
	@Test
	public void testToStringPos6_2() throws BozoException{
		p = new Placar();
		p.add(6, new int[] {2,6,2,6,6});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   18  "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 7, nao valida
	@Test
	public void testToStringPos7_1() throws BozoException{
		p = new Placar();
		p.add(7, new int[] {2,2,3,3,5});
		String r =     "(1)    |    0     |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 7, valida
	@Test
	public void testToStringPos7_2() throws BozoException{
		p = new Placar();
		p.add(7, new int[] {2,2,2,2,2});
		String r =     "(1)    |   15     |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 8, nao valida
	@Test
	public void testToStringPos8_1() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {1,2,5,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |    0     |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 8, valida
	@Test
	public void testToStringPos8_2() throws BozoException{
		p = new Placar();
		p.add(8, new int[] {6,2,3,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   20     |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 9, nao valida
	@Test
	public void testToStringPos9_1() throws BozoException{
		p = new Placar();
		p.add(9, new int[] {1,2,3,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |    0     |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 9, valida
	@Test
	public void testToStringPos9_2() throws BozoException{
		p = new Placar();
		p.add(9, new int[] {2,2,2,2,2});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   30     |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   (10)   |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 10, nao valida
	@Test
	public void testToStringPos10_1() throws BozoException{
		p = new Placar();
		p.add(10, new int[] {1,2,3,4,5});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |    0     |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	//Teste placar - Posicao 10, valida
	@Test
	public void testToStringPos10_2() throws BozoException{
		p = new Placar();
		p.add(10, new int[] {2,2,2,2,2});
		String r =     "(1)    |   (7)    |   (4) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(2)    |   (8)    |   (5) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"(3)    |   (9)    |   (6) "+ "\n" + 
				"--------------------------"+ "\n" + 
				"       |   40     |" + "\n" + 
				"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
	@Test
	public void testToStringCheio() throws BozoException{
		p = new Placar();
		p.add(1, new int[] {1,2,3,4,5});
		p.add(2, new int[] {1,2,6,4,5});
		p.add(3, new int[] {1,6,6,6,5});
		p.add(4, new int[] {1,2,3,4,5});
		p.add(5, new int[] {1,2,3,4,5});
		p.add(6, new int[] {1,2,3,4,5});
		p.add(7, new int[] {1,2,3,4,5});
		p.add(8, new int[] {1,2,3,4,5});
		p.add(9, new int[] {2,2,2,2,5});
		p.add(10, new int[] {1,2,3,4,5});//62
		String r =      " 1     |    0     |    4  "+ "\n" + 
						"--------------------------"+ "\n" + 
						" 2     |   20     |    5  "+ "\n" + 
						"--------------------------"+ "\n" + 
						" 0     |   30     |    0  "+ "\n" + 
						"--------------------------"+ "\n" + 
						"       |    0     |" + "\n" + 
						"       +----------+ ";
		assertEquals(r,p.toString());
	}
	
}

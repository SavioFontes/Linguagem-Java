
public class Placar {

	private int[] score = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};//Array do score do jogo. Se score[i]==-1, nao foi utilizado a posicao ainda 
	
	/* Funcao: private int soma(int valor, int[] dados)
	 * Parametros: int valor, int[] dados
	 * Retorno: int
	 * Obs: Retorna a soma dos dados que tem valor igual a valor
	 */
	private int soma(int valor, int[] dados) {
		int s = 0;
		for(int i = 0; i < 5; i++) {
			if(dados[i] == valor) s += dados[i];
		}
		return s;
	}
	
	/* Funcao: public void add(int posicao, int[] dados)
	 * Excecao: java.lang.IllegalArgumentException
	 * Parametros: int posicao, int[] dados
	 * Retorno: void
	 * Obs: Adiciona o valor dos dados no placar do jogo, de acordo com a opcao escolhida pelo jogador
	 * Posicao: 1 a 6 - a soma dos dados que tem o valor da casa
	 * 			7 - full hand
	 * 			8 - sequencia
	 * 			9 - quadra
	 * 			10 - quina
	 */
	public void add(int posicao, int[] dados) throws BozoException {
		
		int pos = posicao - 1;
		
		//caso o valor da posicao seja maior que o limite
		if(posicao > 10 || posicao < 1) {
			throw new BozoException("Valor de Posição inválido.");
		}
		
		//Caso for escolhido uma posicao invalida, eh emitido a excecao e jogo encerra
		if(score[pos] != -1) throw new BozoException("Posição já escolhida.");
		
		//Posicao entre 1 e 6
		if(posicao < 7) {
			score[pos] = soma(posicao, dados);
			return;
		}
		
		//Array que conta quantos dados de cada valor tem, para poder fazer as operacoes de posicao 7 a 10
		int[] valores = {0,0,0,0,0,0};
		for(int i = 0; i <5; i++) {
			valores[dados[i]-1]++;
		}
		
		//Verifica se existe uma dupla e trinca ou quina. Caso sim, atribui 15 pontos, do contrario atribui 0 pontos
		if(posicao == 7) {
			boolean dupla = false, trinca = false, quina = false;
			for(int i = 0; i < 6; i++) {
				if(valores[i]==2) dupla = true;
				if(valores[i]==3) trinca = true;
				if(valores[i]==5) quina = true;
			}
			if((dupla && trinca) || quina) {
				score[6] = 15;
			} else {
				score[6] = 0;
			}
			return;
		}
		
		//Verifica se existe uma sequencia 1 a 5 ou 2 a 6. Caso sim, atribui 20 pontos, do contrario atribui 0 pontos
		//Nos testes de coverage do JUnit, eu não consegui descobrir quais são os branchs não passados, mas o código funciona para os possiveis padrões de entrada no qual pensei
		if(posicao == 8) {
			if((valores[0] == valores[1] && valores[1] == valores[2] && valores[2] == valores[3] && valores[3] == valores[4] && valores[4] == 1) ||
					(valores[1] == valores[2] && valores[2] == valores[3] && valores[3] == valores[4] && valores[4] == valores[5] && valores[5] == 1)) {
				score[7] = 20;
			} else {
				score[7] = 0;
			}
			return;
		}
		
		//Verifica se existe uma quadra. Caso sim, atribui 30 pontos, do contrario atribui 0 pontos
		if(posicao == 9) {
			for(int i = 0; i < 6; i++) {
				if(valores[i]==4 || valores[i]==5) {
					score[8] = 30;
					return;
				}
			}
			score[8] = 0;
			return;
		}
		
		//Verifica se existe uma quina. Caso sim, atribui 40 pontos, do contrario atribui 0 pontos
		
		for(int i = 0; i < 6; i++) {
			if(valores[i]==5) {
				score[9] = 40;
				return;
			}
		}
		score[9] = 0;
		return;
		
			
	}
	
	/* Funcao: public int getScore()
	 * Parametros: Nao tem
	 * Retorno: int
	 * Obs: Retorna o score total do placar
	 */
	public int getScore() {
		
		int res = 0;
		for(int i = 0; i < 10; i++) {
			if(score[i]!=-1) res += score[i];
		}
		
		return res;
	}
	
	/* Funcao: public java.lang.String toString()
	 * Parametros: Nao tem
	 * Retorno: String
	 * Obs: Retorna uma string que tem o formato do placar
	 */
@Override
	public java.lang.String toString() {
		
		String s ="";
		String[] a = new String[10];
		
		//Verifica se no espaco da devida posicao vai ter o numero da posicao ou a pontuacao dela
		for(int i = 0; i < 10; i++) {
			if(score[i]==-1) {
				a[i] = "(" + Integer.toString(i+1) + ")";
			} else {
				a[i] = "";
				if(score[i]<10) {
					a[i] = " ";
				}
				a[i] += score[i];
				a[i] += " ";
				if(i==9) {
					a[i] += " ";
				}
			}
		}
		
		//string em formato do placar
		s = a[0]+"    |   "+a[6]+"    |   "+a[3]+" \n"+
		    "--------------------------\n"+
		    a[1]+"    |   "+a[7]+"    |   "+a[4]+" \n"+
		    "--------------------------\n"+
		    a[2]+"    |   "+a[8]+"    |   "+a[5]+" \n"+
		    "--------------------------\n"+
		    "       |   "+a[9]+"   |\n"+
		    "       +----------+ ";
		
		return s;
	}
}

/*
 * Nome: Savio Duarte Fontes - 10737251
 * 
 * Nao foi testado o Bozo.java - só tem a main
 * 
 * Na classe Placar tem dois branchs do if do metodo add() para a posicao 8 no qual nao consegui achar os branchs que faltam, mas ela funciona.
 */

import java.util.Scanner;

public class Bozo {
	public static void main(java.lang.String[] args) throws java.io.IOException{
		
		Placar placar = new Placar(); //Cria o placar do jogo
		RolaDados dados = new RolaDados(5); //Cria o conjunto de dados
		int[] valores = new int[5]; //vetor que contem os valores dos dados
		String numTrocar; //String que tem os numeros dos dados que devem ser trocados
		Scanner scan = new Scanner(System.in); //Cria um scanner para poder dar a pausa do sistema
		
		System.out.println(placar);//Imprime o placar pela primeira vez
		
		//loop da quantidade de rodadas
		for(int rodada = 1; rodada < 11; rodada++) {
			
			//Inicio da rodada
			System.out.println("\n****** Rodada " + rodada + "\nPressione ENTER para lançar os dados");
			//Pausa do sistema
			scan.nextLine();
			
			//Inicia os dados, rolando eles
			valores = dados.rolar();
			
			//loop das 2 vezes que pode trocar os dados
			for(int i = 0; i < 2; i++) {
				//Imprime os dados
				System.out.println(dados);
				
				//pega os dados que devem ser rolados e rola eles
				System.out.println("Digite os numeros dos dados que quiser TROCAR. Separados por espacos");
				numTrocar = EntradaTeclado.leString();
				valores = dados.rolar(numTrocar);
			}
			
			//Imprime o resultado final dos dados e o placar para escolher o local para colocar a pontuacao
			System.out.println(dados);
			System.out.println(placar);
			
			//Pega a posicao a ser adicionada a pontuacao e adiciona ela e imprime o placar novamente
			int posicao = 0;
			while(posicao == 0) {
				try {
					System.out.printf("Escolha a posicao que deseja ocupar com essa jogada ===> ");
					posicao = EntradaTeclado.leInt(); 
					placar.add(posicao, valores);
				} catch(BozoException e) {
					System.out.println(e.getMessage());
					posicao = 0;
				}
			}
			System.out.print("\n\n");
			System.out.println(placar);
		}
		
		//Fecha o scanner
		scan.close();
		
		//imprime a pontucao final
		String score = "***********************************\n***\n*** Seu score final foi: ";
		score += placar.getScore() + "\n***\n***********************************\n";
		System.out.print(score);
	}
}

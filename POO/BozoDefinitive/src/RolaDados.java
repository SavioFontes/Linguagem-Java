
public class RolaDados {

	private Dado[] dados; //array de dados
	private int[] valores; //array dos valores atuais dos dados
	private int nDados; //numero de dados do conjunto
	
	/* Funcao: public void setValores(int[] novo)
	 * Parametros: int[] novo - novo vetor de valores
	 * Retorno: void
	 * Obs: define o vetor de valores - Utilizado para testar os casos de testes
	 */
	public void setValores(int[] novo) {
		valores = novo;
		for(int i = 0; i < nDados; i++) {
			dados[i].setLado(novo[i]);
		}
	}
	
	/* Construtor padrao: RolaDados(int n)
	 * o conjunto de dados e de seus valores vao ter n elementos
	 */
	public RolaDados(int n) {
		
		dados = new Dado[n];
		for(int i = 0; i < n; i++) {
			dados[i] = new Dado();
		}
		
		nDados = n;
		
		valores = new int[n];
	}
	
	/* Funcao: public static void main(String[] args)
	 * Parametros: String[] args
	 * Retorno: void
	 * Obs: Nao ha funcoes implementadas
	 */
	public static void main(String[] args) {
	}
	
	/* Funcao: public int[] rolar()
	 * Parametros: Nao tem
	 * Retorno: int[]
	 * Obs: Retorna o vetor com todos os valores dos dados do objeto depois de serem rolados
	 */
	public int[] rolar() {
		
		for(int i = 0; i < nDados; i++) {
			valores[i] = dados[i].rolar();
		}
		
		return valores;
	}
	
	/* Funcao: public int[] rolar(boolean[] quais)
	 * Parametros: boolean quais[]
	 * Retorno: int[]
	 * Obs: Retorna o vetor com todos os valores dos dados do objeto depois de serem rolados, os que forem pedidos
	 */
	public int[] rolar(boolean[] quais) {
		
		for(int i = 0; i < nDados; i++) {
			if(quais[i] == true) {
				valores[i] = dados[i].rolar();
			}
		}
		
		return valores;
	}
	
	/* Funcao: public int[] rolar(java.lang.String s)
	 * Parametros: java.lang.String s
	 * Retorno: int[]
	 * Obs: Retorna o vetor com todos os valores dos dados do objeto depois de serem rolados, os que forem pedidos
	 * Eh criado um boolean[] para ser repassado para public int[] rolar(boolean[] quais) e retorna o vetor desta
	 */
	public int[] rolar(java.lang.String s) {
		
		boolean[] quais = new boolean[nDados];
		if(!s.isEmpty()) {
			for(String a : s.split("\\s+")) {
				int qual = Integer.parseInt(a) - 1;
				if(qual >= 0 && qual < nDados) {
					quais[qual] = true;
				}
			}
		}
		
		return rolar(quais);
	}
	
	/* Funcao: public java.lang.String toString()
	 * Parametros: Nao tem
	 * Retorno: String
	 * Obs: Retorna uma string, que contem a numeracao dos dados no conjunto e tambem todos os dados juntos
	 */
@Override
	public java.lang.String toString() {
	
		String retorno = "";
		
		//Numeracao dos dados
		for(int i = 1; i <= nDados; i++) {
			retorno += " " + i + "         ";
		}
		retorno += '\n';
		
		//Separa as Strings dos dados
		String[][] tabela = new String[nDados][5];
		for(int i = 0; i < nDados; i++) {
			tabela[i] = dados[i].toString().split("\n");
		}
		
		//Arranja as Strings dos dados na string de retorno
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < nDados; j++) {
				retorno += tabela[j][i] + "    ";
			}
			retorno += '\n';
		}
		
		return retorno;
	}

}

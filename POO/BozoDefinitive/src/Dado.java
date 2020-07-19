
public class Dado {
	
	private int lados; //quantidade de lados do dado
	private int valor; //valor do lado atual
	
	/* Funcao: public int getLados()
	 * Parametros: Nao tem
	 * Retorno: int
	 * Obs: Retorna o numero de lados do dado - Utilizada para os casos de testes
	 */
	public int getLados() {
		return lados;
	}
	
	/* Funcao: public int getLado()
	 * Parametros: Nao tem
	 * Retorno: int
	 * Obs: Retorna o valor atual do dado - Utilizada para os casos de testes
	 */
	public int getLado() {
		return valor;
	}
	
	/* Funcao: public int setLado()
	 * Parametros: int valor
	 * Retorno: void
	 * Obs: Define o valor do dado - Utilizada para os casos de testes
	 */
	public void setLado(int valor) {
		this.valor = valor;
	}
	
	/* Funcao: public static void main(String[] args)
	 * Parametros: String[] args
	 * Retorno: void
	 * Obs: Nao ha funcoes implementadas
	 */
	public static void main(String[] args) {
	}
	
	/* Funcao: public int rolar()
	 * Parametros: Nao tem
	 * Retorno: int
	 * Obs: Retorna o novo valor do dado, depois de rolar
	 */
	public int rolar() {
		
		Random r = new Random();
		valor = (r.getIntRand(lados) + 1);
		return valor;
		
	}
	
	/* Construtor padrao: Dado()
	 * O dado tem 6 lados
	 */
	public Dado() {
		lados = 6;
	}
	
	/* Construtor padrao: Dado()
	 * Parametros: int n
	 * O dado tem n lados
	 */
	public Dado(int n) {
		lados = n;
	}
	
	/* Funcao: public java.lang.String toString()
	 * Parametros: Nao tem
	 * Retorno: String
	 * Obs: Retorna uma string que tem o formato de dado para um dado que tem menos de 7 lados e, caso tenha mais, retorna o valor do lado.
	 */
@Override
	public java.lang.String toString() {
		
		if(valor >= 7) return "" + valor + "\n";
	
		//primeira linha do dado
		String retorno = "+-----+" + '\n';
		
		//segunda linha do dado
		if(valor >= 4) {
			retorno += "|*   *|" + '\n';
		} else {
			if(valor >= 2) {
				retorno += "|*    |" + '\n';
			} else {
				retorno += "|     |" + '\n';
			}
		}
		
		//terceira linha do dado
		if(valor % 2 == 1) {
			retorno += "|  *  |" + '\n';
		} else if(valor == 6){
			retorno += "|*   *|" + '\n';
		} else {
			retorno += "|     |" + '\n';
		}
		
		//quarta linha do dado
		if(valor >= 4) {
			retorno += "|*   *|" + '\n';
		} else {
			if(valor >= 2) {
				retorno += "|    *|" + '\n';
			} else {
				retorno += "|     |" + '\n';
			}
		}
		
		//quinta linha do dado
		retorno += "+-----+" + '\n';
		
		return retorno;
	}

}

import java.util.Calendar;

//classe para gerar numeros aleatorios
public class Random {
	//esses sao os parametros para a geracao
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	private long xi = 1023; //essa eh a semente
	//se colocar a variavel como public, é possivel alterar em outros programas
	
	//cria numeros entre 0 e 1
	public double getRand() {
		
		 xi = (a + m * xi) % p; 
		double d = xi;
		return d/p;
	
	}
	
	//gera o numero aleatorio com base em max
	public int getIntRand(int max) {
		double d = getRand() * max;
		return (int) d;
	}
	
	//altera a semente
	public void setSemente(int k) {
		xi = k;
	}
	
	//construtor, na hora em cria a classe, essa funcao é realizada
	public Random(int k) {
		xi = k;
	}
	//construtor vazio
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis();
	}
}
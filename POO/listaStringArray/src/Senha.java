

public class Senha {

	public static void main(String[] args) throws Exception {
		
		Random r = new Random();
		
		System.out.print("Digite um numero maximo: ");
		int n = EntradaTeclado.leInt();
		int max = n + 1;
		int rand = r.getIntRand(max);
		
		int teste = -1;
		int it = 0;
		while(teste != rand) {
			System.out.print("Digite um novo numero: ");
			teste = EntradaTeclado.leInt();
			it = it + 1;
		}
		System.out.printf("Foi utilizado %d tentativas. O numero random é %d.\n", it, rand);
	}

}

import java.io.IOException;

public class Ex6String {

	public static void main(String[] args) throws IOException {
		
		System.out.print("Digite a string: ");
		String conteudo = EntradaTeclado.leString();
		String inverso = "";
		
		for(int i = conteudo.length() - 1; i >= 0; i--) {
			inverso = inverso + conteudo.charAt(i);
		}
		System.out.printf("String invertida: %s\n", inverso);
		
		boolean palindromo = true;
		for(int i = 0, j = conteudo.length() - 1; i <= j; i++, j--) {
			if(conteudo.charAt(i) != conteudo.charAt(j)) {
				palindromo = false;
				break;
			}
		}
		if(palindromo) {
			System.out.println("É palindromo");
		} else {
			System.out.println("Não é palindromo");
		}
		
		System.out.print("Digite um numero: ");
		String numero = EntradaTeclado.leString();
		for(int i = 0; i < numero.length(); i++) {
			switch(numero.charAt(i)) {
			case '1':
				System.out.print("um ");
				break;
			case '2':
				System.out.print("dois ");
				break;
			case '3':
				System.out.print("tres ");
				break;
			case '4':
				System.out.print("quatro ");
				break;
			case '5':
				System.out.print("cinco ");
				break;
			case '6':
				System.out.print("seis ");
				break;
			case '7':
				System.out.print("sete ");
				break;
			case '8':
				System.out.print("oito ");
				break;
			case '9':
				System.out.print("nove ");
				break;
			case '0':
				System.out.print("zero ");
				break;
			default:
				break;
			}
		}
	}

}

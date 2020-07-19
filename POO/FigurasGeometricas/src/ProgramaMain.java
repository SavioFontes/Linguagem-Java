
public class ProgramaMain {

	private static Formas[] vetor = new Formas[100];
	private static int nFormas = 0;
	
	public static void main(String[] args) throws Exception{
		
		int op = 0; //opcao do programa
		
		while(op!=7) {
			
			op = leOpcao();
			
			switch(op){
			
			case 1: //Adicionar Circulo
				
				System.out.println("Digite o valor do raio: ");
				double raio = EntradaTeclado.leDouble();
				
				System.out.println("Digite a cor: ");
				String cor = EntradaTeclado.leString();
				
				System.out.println("Digite se esta preenchido:\n");
				boolean filled = leFilled();
				
				Circulo c = new Circulo(raio,cor,filled);
				
				add(c); //Adiciona o circulo no vetor de Formas
				
				System.out.println("\n--------------- Forma Adicionada ---------------\n");
				
				break;
				
			case 2: //Adicionar Quadrado
				
				System.out.println("Digite o valor do lado: ");
				double lado = EntradaTeclado.leDouble();
				
				System.out.println("Digite a cor: ");
				cor = EntradaTeclado.leString();
				
				System.out.println("Digite se esta preenchido:\n");
				filled = leFilled();
				
				Quadrado q = new Quadrado(lado,cor,filled);
				
				add(q); //Adiciona o quadrado na lista de Formas
				
				System.out.println("\n--------------- Forma Adicionada ---------------\n");
				
				break;
				
			case 3: //Adicionar retangulo

				System.out.println("Digite o valor do lado 1: ");
				double lado1 = EntradaTeclado.leDouble();
				
				System.out.println("Digite o valor do lado 2: ");
				double lado2 = EntradaTeclado.leDouble();
				
				System.out.println("Digite a cor: ");
				cor = EntradaTeclado.leString();
				
				System.out.println("Digite se esta preenchido:\n");
				filled = leFilled();
				
				Retangulo r = new Retangulo(lado1,lado2,cor,filled);
				
				add(r); //Adiciona o retangulo na lista de Formas
				
				System.out.println("\n--------------- Forma Adicionada ---------------\n");
				
				break;
				
			case 4: //Imprimir preenchidos
				
				System.out.println("\n");
				imprimirFilled();
				System.out.println("\n");
				break;
				
			case 5: //Imprimir perimetros
				
				System.out.println("\n");
				imprimirPerimetros();
				System.out.println("\n");
				break;
				
			case 6: //Imprimir areas
				
				System.out.println("\n");
				imprimirAreas();
				System.out.println("\n");
				break;
				
			case 7: //Encerrar programa
				
				System.out.println("Terminando o programa....");
				return;
				
			}
		
		System.out.println("Tecle ENTER para continuar...");
		EntradaTeclado.leString();
		System.out.println("\n");
		}

	}
	
	//Imprime as opcoes do menu e le a opcao escolhida pelo usuario
	private static int leOpcao() {
		System.out.println("1) Inserir Circulo.\n2) Inserir Quadrado.\n3) Inserir Retangulo.\n4) Imprimir preenchecidos.\n"
				+ "5) Imprimir perimetros.\n6) Imprimir areas.\n7) Encerrar Programa.");
		int k = -1;
		while(true) {
			System.out.println("Digite a opção desejada ===> ");
			try {
				k = EntradaTeclado.leInt();
				if(k > 0 && k < 8) return k;
			} catch(Exception e) {
				;
			}
		}
	}
	
	//Le a opcao digitada pelo usuario para saber se a figura esta preenchida (retorna true) ou nao (retorna false)
	private static boolean leFilled() {
		System.out.println("0 - para nao preenchido.\n1 - para preenchido.\n");
		int k = -1;
		while(true) {
			System.out.println("Digite a opção desejada ===> ");
			try {
				k = EntradaTeclado.leInt();
				if(k > -1 && k < 2) {
					if(k == 0) return false;
					if(k == 1) return true;
				}
			} catch(Exception e) {
				;
			}
		}
	}
	
	//adiciona a forma ao vetor de formas
	private static void add(Formas f) {
		vetor[nFormas++] = f;
	}
	
	//Imprime os que estao preenchidos mais a posicao delas na lista(vetor)
	private static void imprimirFilled() {
		int n = 0;
		for(Formas f : vetor) {
			if(f == null) return;
			
			n++;
			
			if(f.getFilled() == true) {
				if(f instanceof Circulo) {
					Circulo c = (Circulo) f;
					System.out.println(n + ") " + c.toString());
				} else if(f instanceof Quadrado){
					Quadrado q = (Quadrado) f;
					System.out.println(n + ") " + q.toString());
				} else if(f instanceof Retangulo) {
					Retangulo r = (Retangulo) f;
					System.out.println(n + ") " + r.toString());
				}
			}
			
		}
	}
	
	//Imprime os perimetros das figuras com a posicao delas no vetor
	private static void imprimirPerimetros() {
		int n = 1;
		for(Formas f : vetor) {
			if(f == null) return;
			
			if(f instanceof Circulo) {
				Circulo c = (Circulo) f;
				System.out.println("Perimetro da Forma " + n + " (Circulo): " + c.getPerimeter());
			} else if(f instanceof Quadrado){
				Quadrado q = (Quadrado) f;
				System.out.println("Perimetro da Forma " + n + " (Quadrado): " + q.getPerimeter());
			} else if(f instanceof Retangulo) {
				Retangulo r = (Retangulo) f;
				System.out.println("Perimetro da Forma " + n + " (Retangulo): " + r.getPerimeter());
			}
			
			n++;
			
		}
	}

	//Imprime as areas das figuras com a posicao delas no vetor
	private static void imprimirAreas() {
		int n = 1;
		for(Formas f : vetor) {
			if(f == null) return;
			
			if(f instanceof Circulo) {
				Circulo c = (Circulo) f;
				System.out.println("Area da Forma " + n + " (Circulo): " + c.getArea());
			} else if(f instanceof Quadrado){
				Quadrado q = (Quadrado) f;
				System.out.println("Area da Forma " + n + " (Quadrado): " + q.getArea());
			} else if(f instanceof Retangulo) {
				Retangulo r = (Retangulo) f;
				System.out.println("Area da Forma " + n + " (Retangulo): " + r.getArea());
			}
			
			n++;
			
		}
	}
}


public class Loja {

	private static Produto[] vetor = new Produto[100];
	private static int nProdutos = 0;
	
	public static void main(String[] args) throws Exception{
		int op = 0;
		
		while(op!=7) {
			
			op = leOpcao();
			
			switch(op){
			
			case 1: //Adicionar Livro
				
				System.out.println("Digite o nome do Livro: ");
				String nome = EntradaTeclado.leString();
				
				System.out.println("Digite a quantidade: ");
				int qtd = EntradaTeclado.leInt();
				
				System.out.println("Digite o código de barras: ");
				int codigoBarras = EntradaTeclado.leInt();
				
				Livro livro = new Livro(nome, codigoBarras, qtd);
				
				add(livro); //Adiciona o circulo no vetor de Formas
				
				System.out.println("\n--------------- Livro Adicionado ---------------\n");
				
				break;
				
			case 2: //Adicionar CD
				
				System.out.println("Digite o nome do CD: ");
				nome = EntradaTeclado.leString();
				
				System.out.println("Digite a quantidade: ");
				qtd = EntradaTeclado.leInt();
				
				System.out.println("Digite o código de barras: \n");
				codigoBarras = EntradaTeclado.leInt();
				
				CD cd = new CD(nome, codigoBarras, qtd);
				
				add(cd); //Adiciona o cd no vetor de Produtos
				
				System.out.println("\n--------------- CD Adicionado ---------------\n");
				
				break;
				
			case 3: //Adicionar DVD
	
				System.out.println("Digite o nome do DVD: ");
				nome = EntradaTeclado.leString();
				
				System.out.println("Digite a quantidade: ");
				qtd = EntradaTeclado.leInt();
				
				System.out.println("Digite o código de barras: ");
				codigoBarras = EntradaTeclado.leInt();
				
				DVD dvd = new DVD(nome, codigoBarras, qtd);
				
				add(dvd); //Adiciona o DVD no vetor de Produtos
				
				System.out.println("\n--------------- DVD Adicionado ---------------\n");
				
				break;
				
			case 4: //Acrescentar produtos
				
				System.out.println("Qual o código de barras do produto a ser acrescentado: ");
				codigoBarras = EntradaTeclado.leInt();
				
				int k = -1;
				while(true) {
					System.out.println("Qual a quantidade a ser acrescentada: ");
					try {
						k = EntradaTeclado.leInt();
						if(k >= 0) break;
					} catch(Exception e) {
						System.out.println("Quantidade inválida (valor negativo).");
					}
				}
				
				Produto p = procura(codigoBarras);
				
				if(p == null) {
					System.out.println("Produto Inexistente.\n");
					break;
				}
				
				p.adicionar(k);
				
				System.out.println("\n--------------- Quantidade Acrescentada ---------------\n");
				break;
				
			case 5: //Vender produtos
				
				System.out.println("Qual o código de barras do produto a ser vendido: ");
				codigoBarras = EntradaTeclado.leInt();
				
				k = -1;
				while(true) {
					System.out.println("Qual a quantidade a ser vendida: ");
					try {
						k = EntradaTeclado.leInt();
						if(k >= 0) break;
					} catch(Exception e) {
						System.out.println("Quantidade inválida (valor negativo).");
					}
				}
				
				p = procura(codigoBarras);
				
				if(p == null) {
					System.out.println("Produto Inexistente.\n");
					break;
				}
				
				try {
					p.venda(k);
					System.out.println("\n--------------- Quantidade Vendida ---------------\n");
				} catch(Exception e) {
					System.out.println("\n--------------- Quantidade NÃO Vendida ---------------\n");
					System.out.println(e.getMessage());
				}
					
				break;
				
			case 6: //Imprimir produtos
				
				System.out.println("\n");
				imprimir();
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
	
	//faz a leitura da opcao do menu
	private static int leOpcao() {
		System.out.println("1) Inserir Livro.\n2) Inserir CD.\n3) Inserir DVD.\n4) Acrescentar produtos.\n"
				+ "5) Realizar venda.\n6) Imprimir produtos.\n7) Encerrar Programa.");
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
	
	//adiciona produto no vetor
	private static void add(Produto p) {
		vetor[nProdutos++] = p;
	}

	//procura o produto com tal codigo de barras(cb)
	private static Produto procura(int cb) {
		for(Produto pro : vetor) {
			if(pro == null) break;
			
			if(pro.getCodigoBarras() == cb) return pro;
		}
		return null;
	}
	
	//Imprime somente os produtos que tem quantidade maior que zero, como há a opção de acrescentar quantidade, ele não é removido do vetor
	private static void imprimir() {
		int nLivros = 0, nCd = 0, nDvd = 0;
		for(Produto p : vetor) {
			if(p == null) break;
			
			if(p instanceof Livro) {
				if(p.getQuantidade() > 0) {
					nLivros++;
					Livro l = (Livro) p;
					System.out.println(l.toString());
				}
			} else if(p instanceof CD) {
				if(p.getQuantidade() > 0) {
					nCd++;
					CD c = (CD) p;
					System.out.println(c.toString());
				}
			} else if(p instanceof DVD) {
				if(p.getQuantidade() > 0) {
					nDvd++;
					DVD d = (DVD) p;
					System.out.println(d.toString());
				}
			}
		}
		
		System.out.println("Existe(m):\n\t" + nLivros + " Livro(s);\n\t" + nCd + " CD(s);\n\t" + nDvd + " DVD(s).\n");
	}
	
}

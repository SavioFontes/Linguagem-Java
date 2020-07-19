
public class Agenda {

	private static Pessoa contatos[] = new Pessoa[100];
	private static	int nContatos = 0;
	
	public static void main(String[] args) throws Exception{
		
		int op = 0; //opcao do programa
		
		while(op != 6) {
			op = leopcao();
			switch(op) {
			
			case 1: //Adicionar Pessoa Fisica
				
				if(nContatos == 100) {
					System.out.println("\n\nAgenda Cheia\n\n");
					break;
				}
				
				System.out.println("Nome da Pessoa Física: ");
				String nome = EntradaTeclado.leString();
				
				System.out.println("Endereço da Pessoa Física: ");
				String endereco = EntradaTeclado.leString();
				
				System.out.println("Data de nascimento da Pessoa Física (DD/MM/YYYY): ");
				String data_nascimento = EntradaTeclado.leString();
				
				System.out.println("CPF da Pessoa Física: ");
				String cpf = EntradaTeclado.leString();
				
				System.out.println("E-mail da Pessoa Física: ");
				String email = EntradaTeclado.leString();
				
				System.out.println("Estado civil da Pessoa Física: ");
				String estado_civil = EntradaTeclado.leString();
				
				PessoaFisica pf = new PessoaFisica(cpf, nome, endereco, data_nascimento, email, estado_civil);
				add(pf);
				
				System.out.println("************ Contato criado.**************");
				break;
				
			case 2: //Adicionar Pessoa Juridica
				
				if(nContatos == 100) {
					System.out.println("\n\nAgenda Cheia\n\n");
					break;
				}
				
				System.out.println("Nome da Pessoa Jurídica: ");
				nome = EntradaTeclado.leString();
				
				System.out.println("Endereço da Pessoa Jurídica: ");
				endereco = EntradaTeclado.leString();
				
				System.out.println("Razão Social da Pessoa Jurídica: ");
				String razao_social = EntradaTeclado.leString();
				
				System.out.println("CNPJ da Pessoa Jurídica (somente os números): ");
				String cnpj = EntradaTeclado.leString();
				
				System.out.println("Inscrição Estadual da Pessoa Jurídica: ");
				String inscricao_estadual = EntradaTeclado.leString();
				
				System.out.println("E-mail da Pessoa Jurídica: ");
				email = EntradaTeclado.leString();
				
				PessoaJuridica pj = new PessoaJuridica(cnpj,nome,endereco,email,inscricao_estadual,razao_social);
				add(pj);
				
				System.out.println("************ Contato criado.**************");
				break;
				
			case 3: //Remocao da Pessoa
				System.out.println("1) Remocao por nome.\n2) Remocao por CPF.\n3) Remocao por CNPJ.");
				
				//loop para escolha de qual tipo de busca para remocao
				int k = -1;
				while(true)
				{
					System.out.println("Digite a opção de remocao ===> ");
					k = EntradaTeclado.leInt();
					if(k > 0 && k < 4) break;
				}
				
				System.out.println("Digite o valor do campo de busca para remocao: ");
				String remocao = EntradaTeclado.leString();
				
				Pessoa p = procura(k, remocao);
				
				int a = 0;
				while(a < nContatos && a < 100 && p != null) {
					if(p == contatos[a]) break;
					a++;
				}
				
				if(p == null || a == 100) {
					System.out.println("\n************ Contato Inexistente **************\n");
				} else {
					for(int b = a; b<nContatos; b++) {
						contatos[b] = contatos[b+1];
					}
					nContatos--;
					System.out.println("\n************ Contato Removido **************\n");
				}
				
				break;
				
			case 4: //Busca do contato
				System.out.println("1) Busca por nome.\n2) Busca por CPF.\n3) Busca por CNPJ.");
				
				//loop para escolha de qual tipo de busca
				k = -1;
				while(true)
				{
					System.out.println("Digite a opção de busca ===> ");
					k = EntradaTeclado.leInt();
					if(k > 0 && k < 4) break;
				}
				
				System.out.println("Digite o valor do item de busca: ");
				String busca = EntradaTeclado.leString();
				
				p = procura(k,busca);
				
				if(p == null) {
					System.out.println("\n************ Contato Inexistente **************\n");
				} else {
					if(p instanceof PessoaFisica) {
						pf = (PessoaFisica) p;
						pf.imprimirDados();
					}
					if(p instanceof PessoaJuridica) {
						pj = (PessoaJuridica) p;
						pj.imprimirDados();
					}
				}
				break;
				
			case 5://Impressao dos contatos
				
				ordena();//Ordena antes de imprimir 
				
				for(Pessoa imprimir : contatos) {
					if(imprimir == null) {
						break;
					} else {
						if(imprimir instanceof PessoaFisica) {
							pf = (PessoaFisica) imprimir;
							pf.imprimirDados();
						}
						if(imprimir instanceof PessoaJuridica) {
							pj = (PessoaJuridica) imprimir;
							pj.imprimirDados();
						}
					}
				}
				break;
			
			case 6: //Encerramento do programa
				System.out.println("Terminando o programa....");
				return;
			}
			
			System.out.println("Tecle ENTER para continuar...");
			EntradaTeclado.leString();
			System.out.println("\n\n");
		}

	}
	
	//Imprime as opcoes do menu e pega a opcao escolhida pelo usuario
	private static int leopcao() {
		
		System.out.println("1) Adicionar Pessoa Física.\n2) Adicionar Pessoa Jurídica.\n3) Remover Pessoa.\n4) Busca.\n"
				+"5) Imprimir contatos da agenda.\n6) Para sair.\n");
		
		//loop para pegar a opcao
		int k = -1;
        while (true)
        {
        	System.out.println("Digite a opção desejada ===> ");
        	try {
        		k = EntradaTeclado.leInt();
        		if ( k > 0 && k < 7 )
        			return k;
        	}
        	catch (Exception e) {
        		;
        	}
        }
	}
	
	//Adiciona a pessoa na lista de contatos
	private static void add(Pessoa p) {
		contatos[nContatos++] = p;
	}
	
	//Procura a pessoa com base na string de busca e retorna a pessoa achada
	private static Pessoa procura(int modo, String busca) {
		for (Pessoa p : contatos) {
			if(p == null) break;
			
			switch(modo) {
			
			case 1:
				if(busca.equals(p.getNome()) == true) return p;
				break;
				
			case 2:
				if(p instanceof PessoaFisica) {
					PessoaFisica pf = (PessoaFisica) p;
					if(busca.equals(pf.getCpf()) == true) return p;
				}
				break;
				
			case 3:
				if(p instanceof PessoaJuridica) {
					PessoaJuridica pj = (PessoaJuridica) p;
					if(busca.equals(pj.getCnpj()) == true) return p;
				}
				break;
				
			}
		}
		
		return null;
	}
	
	//método para ordenar, ele só é chamado antes de imprimir os contatos na tela, para ter que fazer uma vez só a ordenção já que foi optado o uso do bubblesort
	private static void ordena() {
		int i = 0;
		int j = nContatos - 1;
		
		if(i==0 && j == -1) return; //caso nao tenha nada no vetor
		
		Pessoa p;
		while(i<=j) {
			if(contatos[i] instanceof PessoaJuridica) {
				
				if(contatos[j] instanceof PessoaFisica) {
					p = contatos[i];
					contatos[i] = contatos[j];
					contatos[j] = p;
					i++;
					j--;
				
				} else if(contatos[j] instanceof PessoaJuridica){
					j--;
				}
				
			} else if(contatos[i] instanceof PessoaFisica){
				if(contatos[j] instanceof PessoaJuridica) {
					i++;
					j--;
				
				} else if(contatos[j] instanceof PessoaFisica){
					i++;
				
				}
			}
		}
		if(contatos[j] instanceof PessoaJuridica) j--;
		bubblesortPF(0,j);
		bubblesortPJ(j+1,nContatos-1);
		
	}
	
	//bubblesort para PessoaFisica - Optei pelo bubblesort para relembrar como implementar
	private static void bubblesortPF(int inicio, int fim) {
		Pessoa p;
		PessoaFisica pf1;
		PessoaFisica pf2;
		
		for(int i = 0 + inicio; i < fim; i++) {
			
			for(int j = 0 + inicio; j < fim - i; j++) {
				
				pf1 = (PessoaFisica) contatos[j];
				pf2 = (PessoaFisica) contatos[j+1];
				
				if(pf1.getCpf().compareTo(pf2.getCpf()) > 0) {
					p = contatos[j];
					contatos[j] = contatos[j+1];
					contatos[j+1] = p;
				}
			}
		}
	}

	//bubblesort para PessoaJuridica - Optei pelo bubblesort para relembrar como implementar
	private static void bubblesortPJ(int inicio, int fim) {
		Pessoa p;
		PessoaJuridica pj1;
		PessoaJuridica pj2;
		
		for(int i = 0 + inicio; i < fim; i++) {
			for(int j = 0 + inicio; j < fim - i; j++) {
				
				pj1 = (PessoaJuridica) contatos[j];
				pj2 = (PessoaJuridica) contatos[j+1];
				
				if(pj1.getCnpj().compareTo(pj2.getCnpj()) > 0) {
					p = contatos[j];
					contatos[j] = contatos[j+1];
					contatos[j+1] = p;
				}
			}
		}
	}
}

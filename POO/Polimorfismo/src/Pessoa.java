
public class Pessoa {
	private String nome;
	private String endereco;
	private String email;
	
	//Construtor
	public Pessoa(String nome, String endereco, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}
	
	//Define o nome
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Retorna o nome
	public String getNome() {
		return nome;
	}
	
	//Define o endereco
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//Retorna o endereco
	public String getEndereco() {
		return endereco;
	}
	
	//Define o email
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Retorna o email
	public String getEmail() {
		return email;
	}
}

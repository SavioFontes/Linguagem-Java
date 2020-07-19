
public class PessoaJuridica extends Pessoa{
	
	String cnpj;
	String inscricao_estadual;
	String razao_social;
	
	//construtor
	public PessoaJuridica(String cnpj, String nome, String endereco, String email, String inscricao_estadual, String razao_social) {
		super(nome,endereco,email);
		this.cnpj = cnpj;
		this.inscricao_estadual = inscricao_estadual;
		this.razao_social = razao_social;
	}
	
	//Define o CNPJ
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	//Retorna o CNPJ
	public String getCnpj() {
		return cnpj;
	}
	
	//Define a Inscricao estadual
	public void setInscricaoEstadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}
	
	//Retorna a Inscricao estadual
	public String getInscricaoEstadual() {
		return inscricao_estadual;
	}
	
	//Define a Razao Social
	public void setRazaoSocial(String razao_social) {
		this.razao_social = razao_social;
	}
	
	//Retorna a Razao Social
	public String getRazaoSocial() {
		return razao_social;
	}
	
	//Imprime os dados da funcao
	public void imprimirDados() {
		System.out.println("CNPJ: " + cnpj);
		System.out.println("Nome: " + getNome() + " - Inscricao Estadual: " + inscricao_estadual);
		System.out.println("Razao Social: " + razao_social);
		System.out.println("Endereco: " + getEndereco());
		System.out.println("Email: " + getEmail() + "\n");
	}
}

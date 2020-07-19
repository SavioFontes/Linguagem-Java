
public class PessoaFisica extends Pessoa {
	
	String cpf;
	String data_nascimento;
	String estado_civil;
	
	//Construtor
	public PessoaFisica(String cpf, String nome, String endereco, String data_nascimento, String email, String estado_civil) {
		super(nome,endereco,email);
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.estado_civil = estado_civil;
	}
	
	//Define CPF
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//Retorna CPF
	public String getCpf() {
		return cpf;
	}
	
	//Define data de nascimento
	public void setDataNascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	//Retorna a data de nascimento
	public String getDataNascimento() {
		return data_nascimento;
	}
	
	//define o estado civil
	public void setEstadoCivil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	
	//retorna o estado civil
	public String getEstadoCivil() {
		return estado_civil;
	}
	
	//funcao para impressao dos dados
	public void imprimirDados() {
		System.out.println("CPF: " + cpf);
		System.out.println("Nome: " + getNome() + " - Data de Nascimento: " + data_nascimento);
		System.out.println("Endereco: " + getEndereco());
		System.out.println("Email: " + getEmail());
		System.out.println("Estado civil: " + estado_civil + "\n");
	}
}


public class DVD extends Produto{

	String nome;
	
	//Define o nome
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Retorna o nome
	public String getNome() {
		return this.nome;
	}
	
	//Construtor
	public DVD(String nome, int codigoBarras, int quantidade) {
		super(codigoBarras, quantidade);
		setNome(nome);
	}
	
@Override
	public String toString() {
		return "\nDVD: " + this.nome + "\nQuantidade: " + getQuantidade() + "\nCódigo de Barras: " + getCodigoBarras() + "\n"; 
	}
}

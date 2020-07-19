
public class Produto {
	private int codigoBarras;
	private int quantidade;
	
	//Define o Codigo de Barras
	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	//Retorna o Codigo de Barras
	public int getCodigoBarras() {
		return this.codigoBarras;
	}
	
	//Define a quantidade de elementos
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//Retorna a quantidade de elementos
	public int getQuantidade() {
		return this.quantidade;
	}
	
	//Adiciona produtos na quantidade
	public void adicionar(int k) {
		quantidade += k;
	}
	
	//realiza a venda de produtos
	public void venda(int k) throws IllegalArgumentException {
		if(k > quantidade)
			throw new IllegalArgumentException("Tentativa de venda maior do que há no estoque.\n");
		quantidade -= k;
	}
	
	//Construtor
	public Produto(int codigoBarras, int quantidade) {
		setCodigoBarras(codigoBarras);
		setQuantidade(quantidade);
	}
}

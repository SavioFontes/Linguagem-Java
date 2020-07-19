
public class Formas {
	String color;
	boolean filled = false;
	
	//construtor
	public Formas(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	
	//define a cor
	public void setColor(String color){
		this.color = color;
	}
	
	//retorna a cor
	public String getColor() {
		return this.color;
	}
	
	//define o preenchimento
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	//retorna se esta preenchido
	public boolean getFilled() {
		return this.filled;
	}
	
}

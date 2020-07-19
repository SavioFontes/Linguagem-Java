public class Quadrado extends Formas{
	double side = 0;
	double perimeter = 0;
	double area = 0;
	
	//define o lado
	public void setSide(double side) {
		this.side = side;
		setPerimeter(this.side);
		setArea(this.side);
	}
	
	//retorna o lado
	public double getSide() {
		return this.side;
	}
	
	//define o perimetro
	private void setPerimeter(double side) {
		this.perimeter = 4 * side;
	}
	
	//retorna o perimetro
	public double getPerimeter() {
		return this.perimeter;
	}
	
	//define a area
	private void setArea(double side) {
		this.area = side * side;
	}
	
	//retorna a area
	public double getArea() {
		return this.area;
	}
	
	//construtor
	public Quadrado(double side, String color, boolean filled) {
		super(color, filled);
		setSide(side);
	}
	
@Override
	public String toString() {
		return "Quadrado de lado " + side + ", com perimetro de " + perimeter + " e area de " + area + ".\n";
	}
}

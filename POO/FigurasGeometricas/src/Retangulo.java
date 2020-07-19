
public class Retangulo extends Formas{
	double side1 = 0;
	double side2 = 0;
	double perimeter = 0;
	double area = 0;
	
	//define o lado1
	public void setSide1(double side1) {
		this.side1 = side1;
		setPerimeter(this.side1, this.side2);
		setArea(this.side1, this.side2);
	}
	
	//retorna o lado1
	public double getSide1() {
		return this.side1;
	}
	
	//define o lado2
	public void setSide2(double side2) {
		this.side2 = side2;
		setPerimeter(this.side1, this.side2);
		setArea(this.side1, this.side2);
	}
	
	//retorna o lado2
	public double getSide2() {
		return this.side2;
	}
	
	//define o perimetro
	private void setPerimeter(double side1, double side2) {
		this.perimeter = 2 * side1 + 2 * side2;
	}
	
	//retorna o perimetro
	public double getPerimeter() {
		return this.perimeter;
	}
	
	//define a area
	private void setArea(double side1, double side2) {
		this.area = side1 * side2;
	}
	
	//retorna a area
	public double getArea() {
		return this.area;
	}
	
	//construtor
	public Retangulo(double side1, double side2, String color, boolean filled) {
		super(color, filled);
		setSide1(side1);
		setSide2(side2);
	}
	
@Override
	public String toString() {
		return "Retangulo de lados iguais a " + side1 + " e " + side2 + ", com perimetro de " + perimeter + " e area de " + area + ".\n";
	}
}

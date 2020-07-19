
public class Circulo extends Formas {
	double radius = 0;
	double perimeter = 0;
	double area = 0;
	
	//define o raio
	public void setRadius(double radius) {
		this.radius = radius;
		setPerimeter(radius);
		setArea(radius);
	}
	
	//retorna o raio
	public double getRadius() {
		return this.radius;
	}
	
	//define o perimetro
	private void setPerimeter(double radius) {
		this.perimeter = radius * 2 * 3.14159;
	}
	
	//retorna o perimetro
	public double getPerimeter() {
		return this.perimeter;
	}
	
	//define a area
	private void setArea(double radius) {
		this.area = 3.14159 * radius * radius;
	}
	
	//retorna a area
	public double getArea() {
		return this.area;
	}
	
	//construtor
	public Circulo(double radius, String color, boolean filled) {
		super(color, filled);
		setRadius(radius);
	}
	
@Override
	public String toString() {
		return "Circulo de raio " + radius + ", com perimetro de " + perimeter + " e area de " + area + ".\n";
	}
}

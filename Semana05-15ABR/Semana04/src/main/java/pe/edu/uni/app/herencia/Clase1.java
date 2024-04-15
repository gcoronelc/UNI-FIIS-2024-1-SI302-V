package pe.edu.uni.app.herencia;

public class Clase1 {

	public Clase1() {
		System.out.println("Hola todos!!!");
	}
	
	public Clase1(String nombre) {
		System.out.println("Hola " + nombre + "!!!");
	}

	public int promedio(int n1, int n2, int n3) {
		int pr = (n1 + n2 + n3) / 3;
		return pr;
	}

}

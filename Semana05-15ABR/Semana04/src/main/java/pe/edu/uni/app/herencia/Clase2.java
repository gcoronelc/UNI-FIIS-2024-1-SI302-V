package pe.edu.uni.app.herencia;

public class Clase2 extends Clase1{

	public Clase2() {
		super("Gustavo");
	}
	
	@Override
	public int promedio(int n1, int n2, int n3) {
		int pr = (n1 + n2 + n3*2)/4;
		return pr;	
	}

	
	
}

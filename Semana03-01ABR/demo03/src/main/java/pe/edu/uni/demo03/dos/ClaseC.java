package pe.edu.uni.demo03.dos;

import pe.edu.uni.demo03.uno.ClaseA;

/**
 *
 * @author Gustavo Coronel
 */
public class ClaseC extends ClaseA{

	public ClaseC() {
		super(500, 500, 500, 500);
	}
	
	
	
	
	
	/**
	 * Metodo que muestra el valor de las variables.
	 */
	public void metodoC(){
		// Variables
		ClaseA obj = new ClaseA(43,67,23,89);
		int n3 = 1000;
		// Reporte
		System.out.println("DESDE EL METODO C");
		// System.out.println("n1: " + obj.n1); No se tiene acceso, por que es privado
		// System.out.println("n2: " + obj.n2); La variable n2 se encuentra en un paquete diferente.
		System.out.println("n3 (Local): " + n3);
		System.out.println("n3 (Del Padre): " + super.n3);
		System.out.println("n4: " + obj.n4);
	}
	
	
}

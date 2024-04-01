package pe.edu.uni.demo03.uno;

/**
 *
 * @author Gustavo Coronel
 */
public class ClaseB {

	public ClaseB() {
		super();
		System.out.println("Hola desde constructor de ClaseB.");
	}
	
	
	

	/**
	 * Metodo que muestra el valor de las variables.
	 */
	public void metodoB(){
		// Variables
		ClaseA obj = new ClaseA();
		// Reporte
		System.out.println("DESDE EL METODO B");
		// System.out.println("n1: " + obj.n1); No se tiene acceso, por que es privado
		System.out.println("n2: " + obj.n2);
		System.out.println("n3: " + obj.n3);
		System.out.println("n4: " + obj.n4);
	}
	
	
}

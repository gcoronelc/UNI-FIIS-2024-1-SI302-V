package pe.edu.uni.app.prueba;

import pe.edu.uni.app.herencia.Clase2;
import pe.edu.uni.app.herencia.Clase3;
import pe.edu.uni.app.herencia.Clase4;


public class Prueba03 {
	
	public static void main(String[] args) {
		Clase2 o1 = new Clase4();
		Clase3 o2 = null;
		if(o1 instanceof Clase3){
			o2 = (Clase3) o1;
		}
		System.out.println("Bien ....!!!");
	}
}

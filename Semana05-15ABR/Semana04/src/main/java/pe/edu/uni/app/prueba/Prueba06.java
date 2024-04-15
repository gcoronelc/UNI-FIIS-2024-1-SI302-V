package pe.edu.uni.app.prueba;

import pe.edu.uni.app.herencia.Clase1;
import pe.edu.uni.app.herencia.Clase2;
import pe.edu.uni.app.herencia.Clase3;

public class Prueba06 {

	public static void main(String[] args) {

//		Clase2 bean2 = new Clase2();
//		Clase1 bean1 = bean2;
//		Clase1 bean1 = new Clase2();
//		Clase2 bean2 = (Clase2) bean1;
		Clase2 bean2=new Clase2();
		Clase3 bean3= (Clase3) bean2; 

	}

}

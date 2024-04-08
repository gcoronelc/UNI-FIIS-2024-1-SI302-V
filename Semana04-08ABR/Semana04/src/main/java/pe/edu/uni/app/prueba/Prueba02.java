package pe.edu.uni.app.prueba;

import pe.edu.uni.app.service.DaoAbstract;
import pe.edu.uni.app.service.OracleDao;


public class Prueba02 {
	
	public static void main(String[] args) {
		DaoAbstract obj = new OracleDao();
		obj.insertar();
	}
}

package pe.edu.uni.ventaapp.prueba;

import pe.edu.uni.ventaapp.dto.ItemDTO;
import pe.edu.uni.ventaapp.service.VentaFactory;


public class Prueba02 {

	public static void main(String[] args) {
		
		//Datos
		double total = 154.20;
		//Proceso
		ItemDTO[] repo = VentaFactory.get(VentaFactory.BOLETA).procesar(total);
		//Reporte
		for (ItemDTO dto:repo){
			System.out.println(dto);
		}
	}
}

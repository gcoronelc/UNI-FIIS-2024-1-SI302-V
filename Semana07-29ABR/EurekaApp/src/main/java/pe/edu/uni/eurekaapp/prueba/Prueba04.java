package pe.edu.uni.eurekaapp.prueba;

import java.util.List;
import pe.edu.uni.eurekaapp.dto.CuentaDto;
import pe.edu.uni.eurekaapp.service.CuentaService;


public class Prueba04 {

	public static void main(String[] args) {
		try {
			String sucursal = "001";
			CuentaService service = new CuentaService();
			List<CuentaDto> lista = service.getCuentas(sucursal);
			for (CuentaDto dto : lista) {
				System.out.println(dto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

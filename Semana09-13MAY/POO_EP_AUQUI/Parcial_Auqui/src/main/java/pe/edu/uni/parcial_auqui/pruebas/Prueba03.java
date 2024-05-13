/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.parcial_auqui.pruebas;

import java.util.List;
import pe.edu.uni.parcial_auqui.dto.AlumMatrDto;

import pe.edu.uni.parcial_auqui.service.ConsultasService;

/**
 *
 * @author LENOVO
 */
public class Prueba03 {
     public static void main(String[] args) {
		try {
			
			ConsultasService service = new ConsultasService();
			List<AlumMatrDto> lista = service.getConsultaralumnosmatr(1);
			for (AlumMatrDto dto : lista) {
				System.out.println(dto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

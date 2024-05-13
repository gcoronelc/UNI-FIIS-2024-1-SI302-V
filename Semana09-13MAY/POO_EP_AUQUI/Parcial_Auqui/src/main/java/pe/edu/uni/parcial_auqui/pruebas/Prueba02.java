/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.parcial_auqui.pruebas;

import java.util.List;
import pe.edu.uni.parcial_auqui.dto.CursosMatDto;
import pe.edu.uni.parcial_auqui.service.ConsultasService;

/**
 *
 * @author LENOVO
 */
public class Prueba02 {

    public static void main(String[] args) {
        try {

            ConsultasService service = new ConsultasService();
            List<CursosMatDto> lista = service.getCursosPorAlumno(3);
            for (CursosMatDto dto : lista) {
                System.out.println(dto.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

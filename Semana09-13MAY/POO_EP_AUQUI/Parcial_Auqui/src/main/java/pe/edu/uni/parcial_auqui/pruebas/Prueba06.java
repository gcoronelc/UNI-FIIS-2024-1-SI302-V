/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.parcial_auqui.pruebas;

import pe.edu.uni.parcial_auqui.service.RegistrarPago;

/**
 *
 * @author LENOVO
 */
public class Prueba06 {
  public static void main(String[] args) {
      // ES REGULAR PAGA 3 CUOTAS, esta pagando la 3ra y esa debe ser 300 ya que precio de la matricula del curso es 1000 y debe ser el 30%
        try {
            // Datos
            int idalumno = 4;
            int idCurso = 1;
            int pag_cuota=3;
            int idempleado=2;
            
         
            
            // Proceso
            RegistrarPago service = new RegistrarPago();
            service.Pago(idCurso, idalumno, pag_cuota, idempleado);
            System.out.println("Proceso Ok.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }  
}

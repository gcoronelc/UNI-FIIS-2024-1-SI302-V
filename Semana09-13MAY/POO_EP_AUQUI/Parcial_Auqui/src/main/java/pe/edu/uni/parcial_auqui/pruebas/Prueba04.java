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
public class Prueba04 {
    public static void main(String[] args) {
      // ES REGULAR PERO NO DEBE PAGAR NUEVAMENTE LA CUOTA 2 Y ADEMAS SOLO TIENE QUE PAGAR 2 CUOTAS
        try {
            // Datos
            int idalumno = 1;
            int idCurso = 1;
            int pag_cuota=2;
            int idempleado=3;
            
         
            
            // Proceso
            RegistrarPago service = new RegistrarPago();
            service.Pago(idCurso, idalumno, pag_cuota, idempleado);
            System.out.println("Proceso Ok.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}


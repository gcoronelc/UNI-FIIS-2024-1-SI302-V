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
public class Prueba05 {
    public static void main(String[] args) {
      // Es MEDIABECA  pero no debe pagar 2da cuota solo paga 1 cuota
        try {
            // Datos
            int idalumno = 1;
            int idCurso = 2;
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


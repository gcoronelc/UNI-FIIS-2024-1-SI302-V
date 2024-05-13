/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.parcial_auqui.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
/**
 *
 * @author LENOVO
 */
public class AlumMatrDto {
     private int idalumno;
    private String Nombre;
   
    private String tipo;
    private String fecha;
    private double precio;
    private int nota;
    private String condicion;

}

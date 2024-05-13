/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.parcial_auqui.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.parcial_auqui.AccesoBD.AccesoBD;
import pe.edu.uni.parcial_auqui.dto.AlumMatrDto;
import pe.edu.uni.parcial_auqui.dto.CursosMatDto;

/**
 *
 * @author LENOVO
 */
public class ConsultasService {

    public List<CursosMatDto> getCursosPorAlumno(int idalumno) {
        // Variables
        List<CursosMatDto> lista1 = new ArrayList<>();
        String sql = "SELECT M.cur_id AS codigo_curso, "
                + "C.cur_nombre AS nombre_curso, "
                + "CASE WHEN C.cur_profesor IS NULL THEN 'NO DISPONIBLE' "
                + "WHEN LEN(C.cur_profesor) = 0 THEN 'NO DISPONIBLE' "
                + "ELSE C.cur_profesor END  AS profesor, "
                + "M.mat_tipo AS tipo, "
                + "M.mat_precio AS precio, "
                + "M.mat_nota AS nota, "
                + "CASE WHEN M.mat_nota IS NULL THEN 'None' "
                + "WHEN M.mat_nota < 12 THEN 'Desaprobado' " 
                + "ELSE 'Aprobado' END Condicion "
                + "FROM MATRICULA M "
                + "JOIN CURSO C ON M.cur_id = C.cur_id "
                + "WHERE M.alu_id = ? "
                + "ORDER BY 1";
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        // Proceso
        try {
            // Conexión
            cn = AccesoBD.getConnection();
            // Preparando la consulta
            System.out.println("SQL: " + sql);
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idalumno); // Establecer el valor del parámetro
            // Ejecutando la consulta
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idcurso = rs.getInt("codigo_curso");
                String Nombre = rs.getString("nombre_curso");
                String profesor = rs.getString("profesor");
                String tipo = rs.getString("tipo");
                double precio = rs.getDouble("precio");
                int nota = rs.getInt("nota");
                String condicion = rs.getString("condicion");
                CursosMatDto dto = new CursosMatDto(idcurso, Nombre, profesor, tipo, precio, nota, condicion);
                lista1.add(dto);
            }
            // Liberando objetos
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso.");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                // Manejo de excepciones
            }
        }
        // Reporte
        return lista1;
    }

    public List<AlumMatrDto> getConsultaralumnosmatr(int idcurso) {
        // Variables
        List<AlumMatrDto> lista2 = new ArrayList<>();
        String sql = "SELECT A.alu_id AS idalumno, "
                + "A.alu_nombre AS nombrealumno, "
                + "M.mat_tipo AS tipo, "
                + "CONVERT(varchar(30),M.mat_fecha,105) AS fecha,"
                + "C.cur_precio AS precio, "
                + "M.mat_nota AS nota "
                + "FROM MATRICULA M "
                + "JOIN ALUMNO A ON A.alu_id = M.alu_id "
                + "JOIN CURSO C ON M.cur_id = C.cur_id "
                + "WHERE C.cur_id = ? "
                + "ORDER BY 1";
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        // Proceso
        try {
            // Conexión
            cn = AccesoBD.getConnection();
            // Preparando la consulta
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idcurso); // Establecer el valor del parámetro
            // Ejecutando la consulta
            rs = pstm.executeQuery();
            while (rs.next()) {
                int idalumno = rs.getInt("idalumno");
                String Nombre = rs.getString("nombrealumno");
                String fecha = rs.getString("fecha");
                String tipo = rs.getString("tipo");

                double precio = rs.getDouble("precio");
                String condicion;
                int nota = rs.getInt("nota");
                if (nota >= 12) {
                    condicion = "Aprobado";
                } else {
                    condicion = "Desaprobado";
                }

                AlumMatrDto dto = new AlumMatrDto(idalumno, Nombre, tipo, fecha, precio, nota, condicion);
                lista2.add(dto);
            }
            // Liberando objetos
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso.");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                // Manejo de excepciones
            }
        }
        // Reporte
        return lista2;
    }
}

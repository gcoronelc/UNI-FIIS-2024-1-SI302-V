/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.parcial_auqui.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.edu.uni.parcial_auqui.AccesoBD.AccesoBD;

/**
 *
 * @author LENOVO
 */
public class RegistrarPago {

    public void Pago(int idCurso, int idalumno, int pag_cuota, int idempleado) {
        // Variables
        Connection cn = null;
        String sql;
        PreparedStatement pstm;
        ResultSet rs;
        int cont;
        double pag_importe = 0;
        try {
            // Conexión a la base de datos
            cn = AccesoBD.getConnection();

            // Paso 1: Validar que la matricula exista
            String sqlCurso = "SELECT count(1) cont FROM MATRICULA WHERE (cur_id = ? and alu_id=?)";
            pstm = cn.prepareStatement(sqlCurso);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, idalumno);
            rs = pstm.executeQuery();
            rs.next();
            cont = rs.getInt("cont");
            pstm.close();
            rs.close();
            if (cont != 1) {
                throw new SQLException("La matricula no existe");
            }
            //Validar el numero de cuotas
            sql = "select mat_tipo, mat_cuotas  from MATRICULA where (alu_id=? and cur_id=?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idalumno);
            pstm.setInt(2, idCurso);
            rs = pstm.executeQuery();
            rs.next();
            String tipoMat = rs.getString("mat_tipo");
            int matcuotas = rs.getInt("mat_cuotas");
            pstm.close();
            rs.close();
            sql = "SELECT MAX(pag_cuota) AS max_pag_cuota FROM PAGO WHERE (cur_id = ? AND alu_id = ?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, idalumno);
            rs = pstm.executeQuery();
            rs.next();
            int reg_pago = rs.getInt("max_pag_cuota"); //Maximo nro de cuota que ya pagó
            pstm.close();
            rs.close();

            switch (tipoMat) {
                case "REGULAR" -> {
                    if ((1 <= pag_cuota && pag_cuota <= 3) && (matcuotas >= pag_cuota) && (pag_cuota > reg_pago)) {
                    } else {
                        throw new SQLException("Cantidad de cuota incorrecta o ya pagó la cuota.");
                    }
                }
                case "MEDIABECA" -> {
                    if ((pag_cuota == 1) && (matcuotas >= pag_cuota) && (pag_cuota > reg_pago)) {
                    } else {
                        throw new SQLException("Cantidad de cuota incorrecta o ya pagó la cuota.");
                    }
                }
                case "BECA" -> {
                    if ((pag_cuota == 0) && (matcuotas >= pag_cuota) && (pag_cuota > reg_pago)) {
                    } else {
                        throw new SQLException("Cantidad de cuota incorrecta o ya pagó la cuota.");
                    }
                }

            }
            //Validar el importe
            sql = "select mat_precio  from MATRICULA where (cur_id=? and alu_id=?)";
            pstm = cn.prepareStatement(sql);

            pstm.setInt(1, idCurso);
            pstm.setInt(2, idalumno);
            rs = pstm.executeQuery();
            rs.next();
            double precio = rs.getInt("mat_precio");
            pstm.close();
            rs.close();

            switch (tipoMat) {
                case "REGULAR" -> {
                    if (matcuotas == 1) {
                        pag_importe = precio;
                    }
                    if (matcuotas == 2) {
                        if ((pag_cuota == 1 || pag_cuota == 2)) {
                            pag_importe = precio / 2;
                        }
                    }
                    if (matcuotas == 3) {
                        if ((pag_cuota == 1)) {
                            pag_importe = precio * 0.4;
                        }
                        if (pag_cuota == 2 || pag_cuota == 3) {
                            pag_importe = precio * 0.3;
                        }
                    }

                }
                case "MEDIABECA" -> {
                    pag_importe = precio;
                }
            }
            // Registrar matricula
            sql = "insert into PAGO(cur_id,";
            sql += "alu_id,pag_cuota,emp_id,";
            sql += "pag_fecha, pag_importe) ";
            sql += "values(?,?,?,?,getdate(),?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, idalumno);
            pstm.setInt(3, pag_cuota);
            pstm.setInt(4, idempleado);

            pstm.setDouble(5, pag_importe);
            pstm.executeUpdate();
            pstm.close();
            // Confirmar Tx
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en el proceso, intentelo mas tarde.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

    }
}

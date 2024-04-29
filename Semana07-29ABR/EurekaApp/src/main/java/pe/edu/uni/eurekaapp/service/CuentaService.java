package pe.edu.uni.eurekaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.eurekaapp.db.AccesoDB;
import pe.edu.uni.eurekaapp.dto.CuentaDto;
import pe.edu.uni.eurekaapp.dto.MoviDto;

public class CuentaService {

	public void deposito(String cuenta, double importe, String empleado) {
		// Variables
		Connection cn = null;
		String sql;
		PreparedStatement pstm;
		ResultSet rs;
		int cont, contMov, filas;
		double saldo;
		// Proceso
		try {
			// Inicio de Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Verificar importe
			if(importe<=0){
				throw new SQLException("El importe debe ser positivo.");
			}
			// Verificar cuenta
			sql = "select count(1) cont from Cuenta where chr_cuencodigo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			rs = pstm.executeQuery();
			rs.next();
			cont = rs.getInt("cont");
			pstm.close();
			rs.close();
			if (cont != 1) {
				throw new SQLException("Cuenta no existe.");
			}
			// Datos de la cuenta
			sql = "select dec_cuensaldo, int_cuencontmov ";
			sql += "from Cuenta where chr_cuencodigo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			rs = pstm.executeQuery();
			rs.next();
			saldo = rs.getDouble("dec_cuensaldo");
			contMov = rs.getInt("int_cuencontmov");
			rs.close();
			pstm.close();
			// Actualizar la cuenta
			saldo += importe;
			contMov++;
			sql = "update cuenta set dec_cuensaldo = ? ,";
			sql += "int_cuencontmov = ? where chr_cuencodigo = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setDouble(1, saldo);
			pstm.setInt(2, contMov);
			pstm.setString(3, cuenta);
			filas = pstm.executeUpdate();
			pstm.close();
			if (filas != 1) {
				throw new SQLException("Es posible que la cuenta no exista.");
			}
			// Registrar movimiento
			sql = "insert into Movimiento(chr_cuencodigo,";
			sql += "int_movinumero,dtt_movifecha,chr_emplcodigo,";
			sql += "chr_tipocodigo,dec_moviimporte) ";
			sql += "values(?,?,getdate(),?,'003',?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			pstm.setInt(2, contMov);
			pstm.setString(3, empleado);
			pstm.setDouble(4, importe);
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
	
	public List<MoviDto> getMovimientos(String cuenta){
		// Variables
		List<MoviDto> lista = new ArrayList<>();
		String sql = "select m.int_movinumero id, ";
		sql += "CONVERT(varchar(30),m.dtt_movifecha,105) fecha,";
		sql += "t.vch_tipodescripcion tipo, ";
		sql += "m.dec_moviimporte importe ";
		sql += "from Movimiento m join TipoMovimiento t ";
		sql += "on m.chr_tipocodigo = t.chr_tipocodigo ";
		sql += "where m.chr_cuencodigo = ? order by 1";
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		// Proceso
		try {
			// Conexion
			cn = AccesoDB.getConnection();
			// Preparando la consulta
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cuenta);
			// Ejecutando la consulta
			rs = pstm.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String fecha = rs.getString("fecha");
				String tipo = rs.getString("tipo");
				double importe = rs.getDouble("importe");
				MoviDto dto = new MoviDto(id, fecha, tipo, importe);
				lista.add(dto);
			}
			// Liberando objetos
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso.");
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		// Reporte
		return lista;		
	}

	
	public List<CuentaDto> getCuentas(String sucursal){
		// Variables
		List<CuentaDto> lista = new ArrayList<>();
		String sql = "SELECT chr_sucucodigo CODIGO,";
		sql += "C.chr_cuencodigo CUENTA,";
		sql += "chr_monecodigo MONEDA,";
		sql += "CONCAT(CL.vch_clienombre,', ',CL.vch_cliepaterno,' ',CL.vch_cliematerno) CLIENTE,";
		sql += "dec_cuensaldo SALDO,";
		sql += "vch_cuenestado ESTADO ";
		sql += "FROM CUENTA C ";
		sql += "JOIN Cliente CL ON C.chr_cliecodigo = CL.chr_cliecodigo ";
		sql += "WHERE chr_sucucodigo = ?";
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		// Proceso
		try {
			// Conexion
			cn = AccesoDB.getConnection();
			// Preparando la consulta
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, sucursal);
			// Ejecutando la consulta
			rs = pstm.executeQuery();
			while(rs.next()){
				String codigo = rs.getString("codigo");
				String cuenta = rs.getString("cuenta");
				String moneda = rs.getString("moneda");
				String cliente = rs.getString("cliente");
				double saldo = rs.getDouble("saldo");
				String estado = rs.getString("estado");
				CuentaDto dto = new CuentaDto(codigo, cuenta, moneda, cliente, saldo, estado);
				lista.add(dto);
			}
			// Liberando objetos
			rs.close();
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso.");
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		// Reporte
		return lista;
	}
	
}

package pe.edu.uni.demo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.demo01.dto.ClienteDto;
import pe.edu.uni.demo01.dto.CuentaDto;

@Service
public class CuentaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			rollbackFor = Exception.class)
	public CuentaDto registrarCuenta(CuentaDto dto) {
		// Variables
		String sql;
		int cont;
		String sucursal;
		String cuenta;
		// Validacion del importe
		if(dto.getSaldo().doubleValue()<=0.0) {
			throw new RuntimeException("El importe de apertura debe ser positivo.");
		}
		// Validar que el empleado se encuentre activo
		sql = "select count(1) cont from Asignado ";
		sql += "where chr_emplcodigo=? ";
		sql += "and dtt_asigfechabaja is null";
		cont = jdbcTemplate.queryForObject(sql, Integer.class, dto.getEmpleado());
		if( cont != 1) {
			throw new RuntimeException("Error, empleado no esta activo.");
		}
		// Otras validaciones
		
		
		// Obtener codigo de sucursal
		sql = "select chr_sucucodigo from Asignado ";
		sql += "where chr_emplcodigo=? ";
		sql += "and dtt_asigfechabaja is null";
		sucursal = jdbcTemplate.queryForObject(sql, String.class, dto.getEmpleado());
		// Leer contador de la sucursal
		sql = "update sucursal ";
		sql += "set int_sucucontcuenta = int_sucucontcuenta + 1 ";
		sql += "where chr_sucucodigo = ? ";
		cont = jdbcTemplate.update(sql, sucursal);
		if(cont != 1) {
			throw new RuntimeException("Error, no se ha podido acceder a la BD.");
		}
		sql = "select int_sucucontcuenta cont ";
		sql += "from sucursal ";
		sql +=  "where chr_sucucodigo = ? ";
		cont = jdbcTemplate.queryForObject(sql, Integer.class, sucursal);
		// Registrar la cuenta
		cuenta = "00000" + cont;
		cuenta = sucursal + cuenta.substring(cuenta.length() - 5);
		sql = "insert into cuenta(chr_cuencodigo,chr_monecodigo, ";
		sql += "chr_sucucodigo,chr_emplcreacuenta,chr_cliecodigo, ";
		sql += "dec_cuensaldo,dtt_cuenfechacreacion,vch_cuenestado, ";
		sql += "int_cuencontmov,chr_cuenclave) ";
		sql += "values(?,?,?,?,?,?,getdate(),'ACTIVO',1,?)";
		jdbcTemplate.update(sql, cuenta,dto.getMoneda(), sucursal,
				dto.getEmpleado(), dto.getCliente(),dto.getSaldo(),dto.getClave());
		// Registrar movimiento
		sql = "insert into movimiento(chr_cuencodigo,int_movinumero,";
		sql += "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,";
		sql += "dec_moviimporte,chr_cuenreferencia) ";
		sql += "values(?,1,getdate(),?,'001',?,null)";
		jdbcTemplate.update(sql, cuenta,dto.getEmpleado(),dto.getSaldo());
		// Reporte
		dto.setCodigo(cuenta);
		dto.setSucursal(sucursal);
		return dto;
	}
	
	
}

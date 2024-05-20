package pe.edu.uni.demo01.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pe.edu.uni.demo01.dto.ClienteDto;

@Service
public class ClienteService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> obtenerClientes1(){
		String sql = "select * from cliente";
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql);
		return lista;
	}
	
	public List<ClienteDto> obtenerClientes2(){
		String sql = "select chr_cliecodigo codigo, vch_cliepaterno paterno, ";
		sql += "vch_cliematerno materno, vch_clienombre nombre, ";
		sql += "chr_cliedni dni, vch_clieciudad ciudad,  ";
		sql += "vch_cliedireccion direccion, vch_clietelefono telefono, ";
		sql += "vch_clieemail email from cliente";
		List<ClienteDto> lista;
		lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ClienteDto>(ClienteDto.class));;
		return lista;
	}
	
	public ClienteDto obtenerCliente(String codigo){
		String sql = "select chr_cliecodigo codigo, vch_cliepaterno paterno, ";
		sql += "vch_cliematerno materno, vch_clienombre nombre, ";
		sql += "chr_cliedni dni, vch_clieciudad ciudad,  ";
		sql += "vch_cliedireccion direccion, vch_clietelefono telefono, ";
		sql += "vch_clieemail email from cliente ";
		sql += "where chr_cliecodigo=? ";
		ClienteDto dto;
		try {
			dto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<ClienteDto>(ClienteDto.class), codigo);			
		} catch (Exception e) {
			dto = null;
		}
		return dto;
	}
	
}

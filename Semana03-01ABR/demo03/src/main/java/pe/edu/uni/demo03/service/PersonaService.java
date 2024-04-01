package pe.edu.uni.demo03.service;

import pe.edu.uni.demo03.dto.PersonaDto;

public class PersonaService {


	public PersonaDto[] listado(){
		PersonaDto[] arr = DataPersonas.personas.toArray(new PersonaDto[DataPersonas.personas.size()]);
		return arr;
	}

	public void agregar(PersonaDto dto) {
		DataPersonas.personas.add(dto);
	}
	
}

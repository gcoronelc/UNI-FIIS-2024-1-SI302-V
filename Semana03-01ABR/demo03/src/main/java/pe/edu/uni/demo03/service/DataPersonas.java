package pe.edu.uni.demo03.service;

import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.demo03.dto.PersonaDto;

class DataPersonas {

	private DataPersonas() {
	}
	

	static final List<PersonaDto> personas;

	static {
		personas = new ArrayList<>();
		personas.add(new PersonaDto("Gustavo", "gustavo@gmail.com", 40));
		personas.add(new PersonaDto("Alejandra", "alejandra@gmail.com", 25));
		personas.add(new PersonaDto("Cesar", "cesar@gmail.com", 45));
		personas.add(new PersonaDto("Alicia", "alicia@gmail.com", 30));
	}
}

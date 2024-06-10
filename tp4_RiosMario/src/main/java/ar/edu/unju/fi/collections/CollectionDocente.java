package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {

private static List<Docente> docentes = new ArrayList<Docente>();
	
	public static List<Docente> getDocentes(){
		if(docentes.isEmpty()) {
			docentes.add(new Docente("APU0001P", "Lucia", "Casasola", "LucCas@gmail.com", "3884418273"));
			docentes.add(new Docente("APU0002P", "Rodrigo", "Ramirez", "RoRez@gmail.com", "3883928475"));
			docentes.add(new Docente("APU0003P", "Alex", "Soliz", "AlexIz@gmail.com", "3884513627"));
		}
		return docentes;
	}
	
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	
	public static void eliminarDocente(String codigoDocente) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLegajo()==codigoDocente) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarDocente(Docente docente) {
		for(Docente doce : docentes) {
			if(doce.getLegajo()==docente.getLegajo()) {
				doce.setNombre(docente.getNombre());
				doce.setApellido(docente.getApellido());
				doce.setEmail(docente.getEmail());
				doce.setTelefono(docente.getTelefono());
			} else {
				System.out.println("No se encuentra el código de carrera");
			}
		}
	}
	
	public static Docente buscarDocente(String legajo) {
		Predicate<Docente> filterCodigo = c -> c.getLegajo().equals(legajo);
		Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
		if(docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}
	}
	
}

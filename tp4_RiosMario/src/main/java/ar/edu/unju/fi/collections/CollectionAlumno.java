package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> getAlumnos(){
		if(alumnos.isEmpty()) {
			alumnos.add(new Alumno("APU0001", 432766670L, "Mario", "Rios", "mario300401@gmail.com", "3884418273", LocalDate.of(2001, 4, 30), "General Savio - Constitución 702"));
			alumnos.add(new Alumno("APU0002", 426509388L, "Leonardo", "Garcia", "LeoGar@gmail.com", "3884172847", LocalDate.of(2000, 4, 02), "Guemes - Balcarcel 542"));
			alumnos.add(new Alumno("APU0003", 439681820L, "Jorge", "Gutierrez", "JorGutrrez@gmail.com", "3884489473", LocalDate.of(1994, 2, 15), "Moreno - Diamante 522"));
			
		}
		return alumnos;
	}
	
	public static boolean agregarAlumno(Alumno alumno) {
		return alumnos.add(alumno) ? true : false;
	}
	
	public static void eliminarAlumno(String lu) {
		Iterator<Alumno> iterator = alumnos.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLu().equals(lu)) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarAlumno(Alumno alumno) {
		for(Alumno alum : alumnos) {
			if(alum.getLu()==alumno.getLu()) {
				alum.setDni(alumno.getDni());
				alum.setNombre(alumno.getNombre());
				alum.setApellido(alumno.getApellido());
				alum.setEmail(alumno.getEmail());
				alum.setTelefono(alumno.getTelefono());
				alum.setFechaNacimiento(alumno.getFechaNacimiento());
				alum.setDomicilio(alumno.getDomicilio());
			} else {
				System.out.println("No se encuentra el código de carrera");
			}
		}
	}
	
	public static Alumno buscarAlumno(String lu) {
		Predicate<Alumno> filterCodigo = c -> c.getLu().equals(lu);
		Optional<Alumno> alumno = alumnos.stream().filter(filterCodigo).findFirst();
		if(alumno.isPresent()) {
			return alumno.get();
		}else {
			return null;
		}
	}
}

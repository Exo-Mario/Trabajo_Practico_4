package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

public class CollectionMateria {
	
	private static ArrayList<Materia> materias = new ArrayList<Materia>(); 
	
	public static List<Materia> getMaterias(){
		if(materias.isEmpty()) {
			Docente docente = CollectionDocente.buscarDocente(2);
			Carrera carrera = CollectionCarrera.buscarCarrera(1);
			materias.add(new Materia(1,"Programación Visual","SEGUNDO",(byte)6,"VIRTUAL",docente,carrera));
		}
		return materias;
	}
	
	public static boolean agregarMateria(Materia materia) {
		return materias.add(materia) ? true : false;
	}

	public static void eliminarMateria(int codigoMateria) {
		Iterator<Materia> iterator = materias.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()==codigoMateria) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarMateria(Materia materia) {
		for(Materia mate : materias) {
			if(mate.getCodigo()==materia.getCodigo()) {
				mate.setCodigo(materia.getCodigo());
				mate.setNombre(materia.getNombre());
				mate.setCurso(materia.getCurso());
				mate.setCantidadHoras(materia.getCantidadHoras());
				mate.setModalidad(materia.getModalidad());
				mate.setDocente(materia.getDocente());
				mate.setCarrera(materia.getCarrera());
			} else {
				System.out.println("No se encuentra el código de carrera");
			}
		}
	}
	
	public static Materia buscarMateria(int codigo) {
		Predicate<Materia> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		if(materia.isPresent()) {
			return materia.get();
		}else {
			return null;
		}
	}
	
}


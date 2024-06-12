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
			Docente docente2 = CollectionDocente.buscarDocente(3);
			Carrera carrera2 = CollectionCarrera.buscarCarrera(2);
			materias.add(new Materia(1,"Programación Visual","SEGUNDO",(byte)6,"VIRTUAL",docente,carrera));
			materias.add(new Materia(2,"Matemática Discreta","TERCERO",(byte)3,"PRESENCIAL",docente2,carrera2));
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
	
	public static void modificarMateria(Materia materia) throws Exception {
		boolean encontrado = false;
		try {
			for(Materia mate : materias) {
				if(mate.getCodigo()==materia.getCodigo()) {
					mate.setCodigo(materia.getCodigo());
					mate.setNombre(materia.getNombre());
					mate.setCurso(materia.getCurso());
					mate.setCantidadHoras(materia.getCantidadHoras());
					mate.setModalidad(materia.getModalidad());
					mate.setDocente(materia.getDocente());
					mate.setCarrera(materia.getCarrera());
					encontrado=true;
					break;
				}
			}
			if(!encontrado) {
				throw new Exception ("La materia con código "+materia.getCodigo()+" no existe");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
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


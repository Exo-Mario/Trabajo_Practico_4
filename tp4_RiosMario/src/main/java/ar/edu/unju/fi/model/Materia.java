package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;

@Component
public class Materia {
	private int codigo;
    private String nombre;
    private String curso;
    private byte cantidadHoras;
    private String modalidad; // "virtual" o "presencial"
    private Docente docente;
    private Carrera carrera;
    private Alumno alumno;
    
    public Materia() {
    	
    }

	public Materia(int codigo, String nombre, String curso, byte cantidadHoras, String modalidad, Docente docente,
			Carrera carrera, Alumno alumno) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
		this.alumno = alumno;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public byte getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(byte cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}

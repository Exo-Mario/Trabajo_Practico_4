package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	@Autowired
	private Materia materia;
	private Carrera carrera;
	private Docente docente;
	
	@GetMapping("/listado")
	public String getMateriasPage(Model model) {
		model.addAttribute("materias", CollectionMateria.getMaterias());
		
		model.addAttribute("titulo","Materias");
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaMateriaPage (Model model) {
		Boolean edicion = false;
		model.addAttribute("carreras", CollectionCarrera.getCarreras()); 
		model.addAttribute("docentes", CollectionDocente.getDocentes());
		model.addAttribute("materia", materia);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Materia");
		return "materia-form";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarmateria (@ModelAttribute("materia") Materia materia) { 
		ModelAndView modelView = new ModelAndView("materias");
		carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		docente = CollectionDocente.buscarDocente (materia.getDocente().getLegajo());
		materia.setCarrera(carrera); 
		materia.setDocente(docente);
		CollectionMateria.agregarMateria(materia);
		modelView.addObject("materias", CollectionMateria.getMaterias());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarmateriaPage (Model model, @PathVariable(value="codigo") int codigo) {
		Materia materiaEncontrada = new Materia();
		boolean edicion = true;
		materiaEncontrada = CollectionMateria.buscarMateria(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontrada); model.addAttribute("titulo", "Modificar Materia");
		model.addAttribute("carreras",
		CollectionCarrera.getCarreras()); model.addAttribute("docentes", CollectionDocente.getDocentes());
		return "materia-form";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") Materia materia) {
		carrera = CollectionCarrera.buscarCarrera (materia.getCarrera ().getCodigo()); 
		docente = CollectionDocente.buscarDocente (materia.getDocente().getLegajo());
		materia.setCarrera(carrera); 
		materia.setDocente(docente);
		CollectionMateria.modificarMateria(materia);
		return "redirect:/materia/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") int codigo) {
		CollectionMateria.eliminarMateria(codigo);
		return "redirect:/materia/listado";
	}
}

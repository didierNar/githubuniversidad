package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BONota;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BORegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Nota;

public class ControladorDialogoVerEstudiante {

	private BORegistroCurso boRegistroCurso;
	private BONota boNotas;
	
	public ControladorDialogoVerEstudiante() {
		boRegistroCurso = new BORegistroCurso();
		boNotas = new BONota();
	}
	
	/**
	 * Obtiene los cr�ditos de un estudiante
	 * @param e Estudiante al que se le obtendr�n los cr�ditos
	 * @return los creditos del estudiante
	 * @throws Exception Si falla la operaci�n
	 */
	public int creditosEstudiante (Estudiante e) throws Exception{
		return boRegistroCurso.creditosEstudiante(e);
	}
	
	/**
	 * Obtiene las notas de un estudiante
	 * @param e Estudiante al que se le buscar�n las notas
	 * @return las notas del estudiante
	 * @throws Exception Si falla la operaci�n
	 */
	public List<Nota> notasEstudiante (Estudiante e) throws Exception{
		return boNotas.notasEstudiante(e);
	}
	
	/**
	 * Calcula la nota definitiva de un estudiante
	 * @param eval Evalaluaciones hechas al estudiante
	 * @param notas Notas del estudiante
	 * @return la calificaci�n del estudiante
	 */
	public double calcularDefinitva (List<Nota> notas){
		return boNotas.calcularDefinitiva(notas);
	}
	
}

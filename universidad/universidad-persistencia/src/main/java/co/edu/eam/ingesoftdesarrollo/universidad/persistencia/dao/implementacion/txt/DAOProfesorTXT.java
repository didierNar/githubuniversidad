package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOProfesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;

public class DAOProfesorTXT implements IDAOProfesor {

	public void crear(Profesor p) throws Exception {
		// TODO Auto-generated method stub
		
		PrintWriter salida = new PrintWriter( new FileWriter ("docentes.txt", true));
		
		salida.println(p.getCedula() + ";" +
				p.getApellido() + ";" + 
				p.getCorreo() + ";" +
				p.getDireccion() + ";" +
				p.getNombre() + ";" +
				p.isPostgrado() + ";" +
				p.getProfesion() + ";" +
				p.getTelefono());
	}

	public void editar(Profesor p) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	public Profesor buscar(String ced) throws Exception {
//		
//		BufferedReader entrada = new BufferedReader(new FileReader("docentes.txt"));
//		String linea = null;
//		
//		while ((linea=entrada.readLine()) != null){
//			String datos[] = linea.split(";");
//			if (datos[0] == ced){
//				boolean postgrado;
//				if (datos[5].equalsIgnoreCase("true")){
//					postgrado = true;
//				} else {
//					postgrado = false;
//				}
//				Profesor p = new Profesor(datos[0], datos[1], datos[2], datos[3],
//						datos[4], datos[7], postgrado, datos[6]);
//				
//				return p;
//			}
//		} 
//		
//		return null;
//		
//	}

	public void eliminar(Profesor p) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Profesor> listarProfesores() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Profesion> listaProfesiones() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Profesor buscar(String ced) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Profesion buscarProfesion(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	public Profesion buscarProfesionNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminar(String ced) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

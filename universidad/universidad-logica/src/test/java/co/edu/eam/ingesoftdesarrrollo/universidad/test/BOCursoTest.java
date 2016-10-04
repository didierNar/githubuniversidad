package co.edu.eam.ingesoftdesarrrollo.universidad.test;

import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOProfesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Persona;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import junit.framework.Assert;

public class BOCursoTest {

	private BOCurso boCurso;
	private BOProfesor boProfesor;
	private BOAsignatura boAsignatura;

	@BeforeClass
	public static void beforeClass() {
		TestDataUtil.ejecutarSQL("sqltest/Prueba-add.sql");
	}

	@Before
	public void setUp() {
		boCurso = new BOCurso();
		boProfesor = new BOProfesor();
		boAsignatura = new BOAsignatura();
	}

	@Test
	public void testCrearCurso() {

		try {

			Curso c = new Curso();
			c.setCodigo("1111");
			Asignatura a = boAsignatura.buscarAsignatura("123");
			c.setAsignatura(a);
			Profesor prof = boProfesor.buscarProfesor("123123");
			c.setProfesor(prof);

			boCurso.crearCurso(c);
			Curso curBuscado = boCurso.buscarCurso("1111");
			Assert.assertNotNull(curBuscado);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@AfterClass
	public static void afterClass() {
		// TestDataUtil.ejecutarSQL("sqltest/Prueba-add.sql");
	}

}

package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {

	/**
	 * Test obtenerTamaño
	 * 
	 * Prueba la obtencion del tamaño de una Cabecera.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		assertEquals(me.obtenerTamaño() + 4 + 5, cab.obtenerTamaño());
	}

	/**
	 * Test obtenerVisualizacion
	 * 
	 * Prueba la obtencion de la visualizacion de una Cabecera.
	 * 
	 */
	@Test
	public void obtenerVisualizacionTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");

		String expected = "test" + ": " + cab._valor + "\n" + me.obtenerVisualizacion();
		assertEquals(expected, cab.obtenerVisualizacion());
	}

	/**
	 * Test obtenerNoLeidos
	 * 
	 * Prueba la obtencion de un item no leido
	 * 
	 */
	@Test
	public void obtenerNoLeidosTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");

		int expected = 1;
		assertEquals(expected, cab.obtenerNoLeidos());
	}

	/**
	 * Test estableceLeidoTrue
	 * 
	 * Prueba el establecer un item como leido
	 * 
	 */
	@Test
	public void estableceLeidoTrueTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		cab.establecerLeido(true);
		int expected = 0;
		assertEquals(expected, cab.obtenerNoLeidos());
	}

	/**
	 * Test estableceLeidoFalse
	 * 
	 * Prueba el establcer un item como no leido
	 * 
	 */
	@Test
	public void estableceLeidoFalseTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		cab.establecerLeido(false);
		int expected = 1;
		assertEquals(expected, cab.obtenerNoLeidos());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Prueba a obtener el Icono de una Cabecera.
	 * 
	 */
	@Test
	public void obtenerIconoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		cab.establecerLeido(true);

		assertEquals(new Integer(2), cab.obtenerIcono());
	}

	/**
	 * Test obteneIconoNuevo
	 * 
	 * Prueba a obtener el Icono de una Cabecera nueva.
	 * 
	 */
	@Test
	public void obtenerIconoNuevoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");

		assertEquals(new Integer(3), cab.obtenerIcono());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Prueba la obtencion de la PreVisualizacion de una Cabecera.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		assertEquals(me.obtenerPreVisualizacion(), cab.obtenerPreVisualizacion());
	}

	/**
	 * Test obtenerRuta
	 * 
	 * Prueba el obtener la Ruta de una Cabecera.
	 * 
	 */
	@Test
	public void obtenerRutaTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		assertEquals(me.obtenerRuta(), cab.obtenerRuta());
	}

	/**
	 * Test obtenerRuta
	 * 
	 * Prueba a obtener la Ruta de una Cabecera con padre.
	 * 
	 */
	@Test
	public void obtenerRutaPadreTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		Carpeta ca = new Carpeta("test");
		cab.establecerPadre(ca);
		assertEquals("test" + " > " + me.obtenerPreVisualizacion(), cab.obtenerRuta());
	}

	/**
	 * Test explorar .
	 * 
	 * Prueba el lanzamiento de la excepcion de OperacionInvalida. Salta cuando
	 * explora una Cabecera
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerExplorarTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");

		cab.explorar();

	}

	/**
	 * Test buscar
	 * 
	 * Prueba la busqueda de un item y lo devuelve en forma de colecion
	 * 
	 */
	@Test
	public void buscarTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		Collection expected = new ArrayList<Cabecera>();
		expected.add(cab);

		assertEquals(expected, cab.buscar("contenido"));
	}

	/**
	 * Test buscar
	 * 
	 * Prueba la busqueda de un item que no existe
	 * 
	 */
	@Test
	public void buscarNoEncontrarTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Cabecera cab = new Cabecera(me, "test", "valor");
		Collection expected = new ArrayList<Cabecera>();
		assertEquals(expected, cab.buscar("test"));
	}

}

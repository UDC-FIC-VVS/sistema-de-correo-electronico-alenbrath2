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
	 * Obtiene el tamaño de un Cabecera.
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
	 * Obtiene la visualizacion de un Cabecera.
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
	 *
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
	 * Test obtenerNoLeidos
	 * 
	 *
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
	 * Test obtenerNoLeidos
	 * 
	 *
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
	 * Obtiene el Icono de una Cabecera.
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
	 * Test obteneIcono
	 * 
	 * Obtiene el Icono de una Cabecera.
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
	 * Obtiene la PreVisualizacion de una Cabecera.
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
	 * Obtiene la Ruta de una Cabecera.
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
	 * Obtiene la Ruta con pade de una Cabecera.
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
	 * busca un mensaje y lo devuelve
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
	 * no encuentra un mensaje
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

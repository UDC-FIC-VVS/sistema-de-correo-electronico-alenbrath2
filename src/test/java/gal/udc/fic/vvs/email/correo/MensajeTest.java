package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {

	private final static int TAMAÑO_PREVISUALIZACION = 32;

	/**
	 * Test obtenerTamaño
	 * 
	 * Obtiene el tamaño de un Mensaje.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);

		assertEquals(9, me.obtenerTamaño());
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

		me.establecerLeido(true);
		int expected = 0;

		assertEquals(expected, me.obtenerNoLeidos());
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

		me.establecerLeido(false);
		int expected = 1;

		assertEquals(expected, me.obtenerNoLeidos());
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
		int expected = 1;

		assertEquals(expected, me.obtenerNoLeidos());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Obtiene el Icono de un Mensaje.
	 * 
	 */
	@Test
	public void obtenerIconoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);

		me.establecerLeido(true);

		assertEquals(new Integer(2), me.obtenerIcono());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Obtiene el Icono de un Mensaje.
	 * 
	 */
	@Test
	public void obtenerIconoNuevoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);

		assertEquals(new Integer(3), me.obtenerIcono());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Obtiene la PreVisualizacion de un Mensaje.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() {
		Texto te = new Texto("test", "contenido contenido contenido contenido contenido");
		Mensaje me = new Mensaje(te);

		String expected = "contenido contenido contenido co...";

		assertEquals(expected, me.obtenerPreVisualizacion());
	}

	/**
	 * Test obtenerVisualizacion
	 * 
	 * Obtiene la PreVisualizacion de un Mensaje.
	 * 
	 */
	@Test
	public void obtenerVisualizacionTest() {
		Texto te = new Texto("test", "contenido contenido contenido contenido contenido");
		Mensaje me = new Mensaje(te);

		String expected = "contenido contenido contenido contenido contenido";

		assertEquals(expected, me.obtenerVisualizacion());
	}

	/**
	 * Test obtenerRuta
	 * 
	 * Obtiene la Ruta de un Reenvio.
	 * 
	 */
	@Test
	public void obtenerRutaTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);

		assertEquals(me.obtenerRuta(), me.obtenerRuta());
	}

	/**
	 * Test obtenerRuta
	 * 
	 * Obtiene la Ruta con pade de un Reenvio .
	 * 
	 */
	@Test
	public void obtenerRutaPadreTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);

		Carpeta ca = new Carpeta("test");
		me.establecerPadre(ca);
		assertEquals("test" + " > " + me.obtenerPreVisualizacion(), me.obtenerRuta());
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

		me.explorar();

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

		Collection expected = new ArrayList<Mensaje>();
		expected.add(me);

		assertEquals(expected, me.buscar("contenido"));
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

		Collection expected = new ArrayList<Mensaje>();

		assertEquals(expected, me.buscar("test"));
	}

}

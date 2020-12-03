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
	 * Prueba la obtencion del tamaño de un Mensaje.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);

		assertEquals(9, me.obtenerTamaño());
	}

	/**
	 * Test obtenerVisualizacion
	 * 
	 * Prueba la obtencion de la visualizacion de un Mensaje.
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
	 * Test obtenerNoLeidos
	 * 
	 * Prueba la obtencion de un item no leido
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
	 * Test estableceLeidoTrue
	 * 
	 * Prueba el establecer un item como leido
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
	 * Test estableceLeidoFalse
	 * 
	 * Prueba el establcer un item como no leido
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
	 * Test obteneIcono
	 * 
	 * Prueba a obtener el Icono de un Mensaje.
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
	 * Test obteneIconoNuevo
	 * 
	 * Prueba a obtener el Icono de un Mensaje nuevo.
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
	 * Prueba la obtencion de la PreVisualizacion de un Mensaje.
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
	 * Test obtenerRuta
	 * 
	 * Prueba el obtener la Ruta de un Mensaje.
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
	 * Prueba a obtener la Ruta de un Mensaje con padre.
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
	 * Prueba el lanzamiento de la excepcion de OperacionInvalida. Salta cuando
	 * explora un Mensaje
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
	 * Prueba la busqueda de un item y lo devuelve en forma de colecion
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
	 * Prueba la busqueda de un item que no existe
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

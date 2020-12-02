package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {

	/**
	 * Test obtenerTamaño
	 * 
	 * Obtiene el tamaño de un Reenvio.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Correo co = re;
		assertEquals(me.obtenerTamaño() + meR.obtenerTamaño(), co.obtenerTamaño());
	}

	/**
	 * Test obtenerVisualizacion
	 * 
	 * Obtiene la visualizacion de un Reenvio.
	 * 
	 */
	@Test
	public void obtenerVisualizacionTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Correo co = re;
		String expected = me.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n" + meR.obtenerVisualizacion()
				+ "\n---- Fin correo reenviado ----";
		System.out.println(expected);
		System.out.println(co.obtenerVisualizacion());
		assertEquals(expected, co.obtenerVisualizacion());
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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Correo co = re;
		int expected = 1;
		assertEquals(expected, co.obtenerNoLeidos());
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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		re.establecerLeido(true);
		Correo co = re;

		int expected = 0;
		assertEquals(expected, co.obtenerNoLeidos());
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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		re.establecerLeido(false);
		int expected = 1;
		Correo co = re;
		assertEquals(expected, co.obtenerNoLeidos());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Obtiene el Icono de un Reenvio.
	 * 
	 */
	@Test
	public void obtenerIconoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		re.establecerLeido(true);
		Correo co = re;

		assertEquals(new Integer(2), co.obtenerIcono());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Obtiene el Icono de un Reenvio.
	 * 
	 */
	@Test
	public void obtenerIconoNuevoTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Correo co = re;
		assertEquals(new Integer(3), co.obtenerIcono());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Obtiene la PreVisualizacion de un Reenvio.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Correo co = re;
		assertEquals(me.obtenerPreVisualizacion(), co.obtenerPreVisualizacion());
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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Correo co = re;
		assertEquals(me.obtenerRuta(), co.obtenerRuta());
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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Carpeta ca = new Carpeta("test");
		re.establecerPadre(ca);
		Correo co = re;
		assertEquals("test" + " > " + me.obtenerPreVisualizacion(), co.obtenerRuta());
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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Correo co = re;
		co.explorar();

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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Collection expected = new ArrayList<Reenvio>();
		expected.add(re);
		Correo co = re;

		assertEquals(expected, co.buscar("contenido"));
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
		Texto teR = new Texto("test renvio", "contenido");
		Mensaje meR = new Mensaje(teR);

		Reenvio re = new Reenvio(me, meR);
		Collection expected = new ArrayList<Reenvio>();
		Correo co = re;
		assertEquals(expected, co.buscar("test"));
	}

}

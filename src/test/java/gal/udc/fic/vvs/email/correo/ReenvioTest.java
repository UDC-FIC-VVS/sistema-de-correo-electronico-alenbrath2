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
	 * Prueba la obtencion del tamaño de un Reenvio.
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
	 * Prueba la obtencion de la visualizacion de un Reenvio.
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
	 * Prueba la obtencion de un item no leido
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
	 * Test estableceLeidoTrue
	 * 
	 * Prueba el establecer un item como leido
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
	 * Test estableceLeidoFalse
	 * 
	 * Prueba el establcer un item como no leido
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
	 * Prueba a obtener el Icono de un Reenvio.
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
	 * Prueba a obtener el Icono de un Reenvio nuevo.
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
	 * Prueba la obtencion de la PreVisualizacion de un Reenvio.
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
	 * Prueba el obtener la Ruta de un Reenvio.
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
	 * Prueba a obtener la Ruta de un Reenvio con padre.
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
	 * Prueba el lanzamiento de la excepcion de OperacionInvalida. Salta cuando
	 * explora un Reenvio
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
	 * Prueba la busqueda de un item y lo devuelve en forma de colecion
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
	 * Prueba la busqueda de un item que no existe
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

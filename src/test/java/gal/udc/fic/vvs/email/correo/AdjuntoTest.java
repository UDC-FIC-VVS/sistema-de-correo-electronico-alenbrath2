package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {

	/**
	 * Test obtenerTamaño
	 * 
	 * Obtiene el tamaño de un Adjunto.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		assertEquals(me.obtenerTamaño() + ar.obtenerTamaño(), ad.obtenerTamaño());
	}

	/**
	 * Test obtenerVisualizacion
	 * 
	 * Obtiene la visualizacion de un Adjunto.
	 * 
	 */
	@Test
	public void obtenerVisualizacionTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);

		String expected = me.obtenerVisualizacion() + "\n\nAdxunto: " + ar.obtenerPreVisualizacion();
		assertEquals(expected, ad.obtenerVisualizacion());
	}

	/**
	 * Test obtenerNoLeidos
	 * 
	 *
	 * 
	 */
	@Test
	public void obtenerNoLeidosTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);

		int expected = 1;
		assertEquals(expected, ad.obtenerNoLeidos());
	}

	/**
	 * Test obtenerNoLeidos
	 * 
	 *
	 * 
	 */
	@Test
	public void estableceLeidoTrueTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		ad.establecerLeido(true);
		int expected = 0;
		assertEquals(expected, ad.obtenerNoLeidos());
	}

	/**
	 * Test obtenerNoLeidos
	 * 
	 *
	 * 
	 */
	@Test
	public void estableceLeidoFalseTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		ad.establecerLeido(false);
		int expected = 1;
		assertEquals(expected, ad.obtenerNoLeidos());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Obtiene el Icono de un Adjunto.
	 * 
	 */
	@Test
	public void obtenerIconoTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		ad.establecerLeido(true);

		assertEquals(new Integer(2), ad.obtenerIcono());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Obtiene el Icono de un Adjunto.
	 * 
	 */
	@Test
	public void obtenerIconoNuevoTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);

		assertEquals(new Integer(3), ad.obtenerIcono());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Obtiene la PreVisualizacion de un Adjunto.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		assertEquals(me.obtenerPreVisualizacion(), ad.obtenerPreVisualizacion());
	}

	/**
	 * Test obtenerRuta
	 * 
	 * Obtiene la Ruta de un Adjunto.
	 * 
	 */
	@Test
	public void obtenerRutaTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		assertEquals(me.obtenerRuta(), ad.obtenerRuta());
	}

	/**
	 * Test obtenerRuta
	 * 
	 * Obtiene la Ruta con pade de un Adjunto.
	 * 
	 */
	@Test
	public void obtenerRutaPadreTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		Carpeta ca = new Carpeta("test");
		ad.establecerPadre(ca);
		assertEquals("test" + " > " + me.obtenerPreVisualizacion(), ad.obtenerRuta());
	}

	/**
	 * Test explorar .
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerExplorarTest() throws OperacionInvalida {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);

		ad.explorar();

	}

	/**
	 * Test buscar
	 * 
	 * busca un mensaje y lo devuelve
	 * 
	 */
	@Test
	public void buscarTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		Collection expected = new ArrayList<Adjunto>();
		expected.add(ad);

		assertEquals(expected, ad.buscar("contenido"));
	}

	/**
	 * Test buscar
	 * 
	 * no encuentra un mensaje
	 * 
	 */
	@Test
	public void buscarNoEncontrarTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Adjunto ad = new Adjunto(me, ar);
		Collection expected = new ArrayList<Adjunto>();
		assertEquals(expected, ad.buscar("test"));
	}

}

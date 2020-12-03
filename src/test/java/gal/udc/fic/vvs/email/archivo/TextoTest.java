package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {

	/**
	 * Test obtenerNombre
	 * 
	 * Prueba obetener el nombre de un Texto.
	 * 
	 */
	@Test
	public void obtenerNombreTest() {
		Archivo ar = new Texto("test", "contenido");
		assertEquals("test", ar.obtenerNombre());
	}

	/**
	 * Test obtenerNombre
	 * 
	 * Prueba obetener el MimeType de un Texto.
	 * 
	 */
	@Test
	public void obtenerMimeTypeTest() {
		Archivo ar = new Texto("test", "contenido");
		assertEquals("text/plain", ar.obtenerMimeType());
	}

	/**
	 * Test obtenerContenido
	 * 
	 * Prueba obetener el Contenido de un texto.
	 * 
	 */
	@Test
	public void obtenerContenidoTest() {
		Archivo ar = new Texto("test", "contenido");
		assertEquals("contenido", ar.obtenerContenido());
	}

	/**
	 * Test obtenerTamaño
	 * 
	 * Prueba obetener el tamaño de un texto.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		String contenido = "contenido";
		Archivo ar = new Texto("test", contenido);
		assertEquals(contenido.length(), ar.obtenerTamaño());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Prueba obetener la previsualizacion de un Texto.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() {
		String contenido = "contenido";
		Archivo ar = new Texto("test", contenido);
		String expected = "test" + "(" + ar.obtenerTamaño() + " bytes, " + ar.obtenerMimeType() + ")";
		assertEquals(expected, ar.obtenerPreVisualizacion());
	}

}

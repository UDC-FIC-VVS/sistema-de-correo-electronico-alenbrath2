package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AudioTest {
	/**
	 * Test obtenerNombre
	 * 
	 * Obtiene el nombre de un Audio.
	 * 
	 */
	@Test
	public void obtenerNombreTest() {
		Archivo ar = new Audio("test", "contenido");
		assertEquals("test", ar.obtenerNombre());
	}

	/**
	 * Test obtenerNombre
	 * 
	 * Obtiene el MimeType de un Audio.
	 * 
	 */
	@Test
	public void obtenerMimeTypeTest() {
		Archivo ar = new Audio("test", "contenido");
		assertEquals("audio/ogg", ar.obtenerMimeType());
	}

	/**
	 * Test obtenerContenido
	 * 
	 * Obtiene el Contenido de un Audio.
	 * 
	 */
	@Test
	public void obtenerContenidoTest() {
		Archivo ar = new Audio("test", "contenido");
		assertEquals("contenido", ar.obtenerContenido());
	}

	/**
	 * Test obtenerTamaño
	 * 
	 * Obtiene el tamaño de un Audio.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		assertEquals(contenido.length(), ar.obtenerTamaño());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Obtiene el Contenido de un Audio.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() {
		String contenido = "contenido";
		Archivo ar = new Audio("test", contenido);
		String expected = "test" + "(" + ar.obtenerTamaño() + " bytes, " + ar.obtenerMimeType() + ")";
		assertEquals(expected, ar.obtenerPreVisualizacion());
	}

}

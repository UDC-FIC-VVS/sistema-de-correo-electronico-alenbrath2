package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImagenTest {

	/**
	 * Test obtenerNombre
	 * 
	 * Obtiene el nombre de una Imagen.
	 * 
	 */
	@Test
	public void obtenerNombreTest() {
		Archivo ar = new Imagen("test", "contenido");
		assertEquals("test", ar.obtenerNombre());
	}

	/**
	 * Test obtenerNombre
	 * 
	 * Obtiene el MimeType de un Imagen.
	 * 
	 */
	@Test
	public void obtenerMimeTypeTest() {
		Archivo ar = new Imagen("test", "contenido");
		assertEquals("image/png", ar.obtenerMimeType());
	}

	/**
	 * Test obtenerContenido
	 * 
	 * Obtiene el Contenido de un Imagen.
	 * 
	 */
	@Test
	public void obtenerContenidoTest() {
		Archivo ar = new Imagen("test", "contenido");
		assertEquals("contenido", ar.obtenerContenido());
	}

	/**
	 * Test obtenerTamaño
	 * 
	 * Obtiene el tamaño de un Imagen.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() {
		String contenido = "contenido";
		Archivo ar = new Imagen("test", contenido);
		assertEquals(contenido.length(), ar.obtenerTamaño());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Obtiene el Contenido de un Imagen.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() {
		String contenido = "contenido";
		Archivo ar = new Imagen("test", contenido);
		String expected = "test" + "(" + ar.obtenerTamaño() + " bytes, " + ar.obtenerMimeType() + ")";
		assertEquals(expected, ar.obtenerPreVisualizacion());
	}

}

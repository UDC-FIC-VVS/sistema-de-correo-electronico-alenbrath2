package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class AudioPropertiesTest {

	/**
	 * 
	 * Test obtenerNombre con JUnitQuickCheck
	 * 
	 */
	@Property(trials = 5)
	public void obtenerNombre(@InRange(min = "") String nombre) {

		Archivo ar = new Audio(nombre, "");

		assertEquals(nombre, ar.obtenerNombre());
	}

	/**
	 * 
	 * 
	 * Test obtenerContenido con JUnitQuickCheck
	 * 
	 */
	@Property(trials = 5)
	public void obtenerContenidoTest(@InRange(min = "") String contenido) {
		Archivo ar = new Audio("test", contenido);
		assertEquals(contenido, ar.obtenerContenido());
	}

	/**
	 * Test obtenerTamaño
	 * 
	 * Prueba obetener el tamaño de un Audio con JUnitQuickCheck.
	 * 
	 */
	@Property(trials = 5)
	public void obtenerTamañoTest(@InRange(min = "") String contenido) {
		Archivo ar = new Audio("test", contenido);
		System.out.println(contenido);
		assertEquals(contenido.length(), ar.obtenerTamaño());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Prueba obetener la previsualizacion de un Audio con JUnitQuickCheck.
	 * 
	 */
	@Property(trials = 5)
	public void obtenerPrevisualizacionTest(@InRange(min = "") String contenido, @InRange(min = "") String nombre) {
		Archivo ar = new Audio(nombre, contenido);
		String expected = nombre + "(" + ar.obtenerTamaño() + " bytes, " + ar.obtenerMimeType() + ")";
		assertEquals(expected, ar.obtenerPreVisualizacion());
	}

}

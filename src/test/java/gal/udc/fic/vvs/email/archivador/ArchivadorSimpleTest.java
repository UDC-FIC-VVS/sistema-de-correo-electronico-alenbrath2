package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class ArchivadorSimpleTest {
	/**
	 * Test obtenerNombre
	 * 
	 * Obtiene el nombre de un archivador.
	 * 
	 */
	@Test
	public void obtenerNombretest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 1);
		assertEquals("test", ar.obtenerNombre());
	}

	/**
	 * Test almacenarCorreo
	 * 
	 * Almacena un correo con un contenido ocupando un espacio del archivador en
	 * funcion del contenido del mensaje
	 * 
	 */
	@Test
	public void almacenarCorreoTest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 10);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Correo co = me;
		assertTrue(ar.almacenarCorreo(co));
	}

	/**
	 * Test almacenarCorreo
	 * 
	 * Si el espacio del archivador no es suficiente no almacena el correo
	 * 
	 */
	@Test
	public void noAlmacenarCorreoTest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 0);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Correo co = me;
		assertFalse(ar.almacenarCorreo(co));
	}

	/**
	 * Test obtenerEspacioTotal
	 * 
	 * Obtiene el espacio total que dispone el archivador
	 * 
	 */
	@Test
	public void obtenerEspacioTotalTest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 1);
		assertEquals(1, ar.obtenerEspacioTotal());
	}

	/**
	 * Test obtenerEspacioDisponible
	 * 
	 * Obtiene el espacio disponible que le queda al archivador En el caso de prueba
	 * el contenido del correo ocupa 9 y el espacio disponible resultante despues de
	 * guardar un correo es 11.
	 * 
	 */
	@Test
	public void obtenerEspacioDisponibleTest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 20);
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Correo co = me;
		ar.almacenarCorreo(co);
		assertEquals(11, ar.obtenerEspacioDisponible());
	}

}

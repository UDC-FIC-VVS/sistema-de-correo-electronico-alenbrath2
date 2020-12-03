package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {

	/**
	 * Test almacenarCorreo
	 * 
	 * Prueba almacenar un correo asignado al delegado.
	 * 
	 */
	@Test
	public void almacenarCorreoTest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 10);
		Delegado de = new Delegado(ar);
		DecoradorArchivador deAr = de;

		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Correo co = me;

		assertTrue(deAr.almacenarCorreo(co));
	}

	/**
	 * Test obtenerDelegado Test EstablecerDelegado
	 * 
	 * Prueba obetener el delegado, Establece el delegado
	 */
	@Test
	public void obtener_Y_EstablecerDelegadoTest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 10);
		Delegado de = new Delegado(ar);
		DecoradorArchivador deAr = de;
		deAr.establecerDelegado(de);
		assertEquals(de, deAr.obtenerDelegado());
	}
}

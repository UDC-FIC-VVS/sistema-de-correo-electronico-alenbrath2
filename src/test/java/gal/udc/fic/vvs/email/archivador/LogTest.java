package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivador.DecoradorArchivador;
import gal.udc.fic.vvs.email.archivador.Log;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {

	/**
	 * Test almacenarCorreo
	 * 
	 * Almacena un correo asignado al log.
	 * 
	 */
	@Test
	public void almacenarCorreoTest() {
		ArchivadorSimple ar = new ArchivadorSimple("test", 10);
		Log lo = new Log(ar);
		DecoradorArchivador deAr = lo;

		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Correo co = me;

		assertTrue(deAr.almacenarCorreo(co));
	}

}

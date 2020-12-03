package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaLimitadaTest {

	/**
	 * Test obtenerTamaño
	 * 
	 * Prueba la obtencion del tamaño de una Carpeta.
	 * 
	 */
	@Test
	public void obtenerTamañoTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me1 = new Mensaje(te);
		Mensaje me2 = new Mensaje(te);
		Mensaje me3 = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me1);
		caL.añadir(me2);
		caL.añadir(me3);

		assertEquals(me1.obtenerTamaño() * 3, caL.obtenerTamaño());
	}

	/**
	 * Test obtenerVisualizacion
	 * 
	 * Prueba la obtencion de la visualizacion de una Carpeta.
	 * 
	 * 
	 * 
	 */
	@Test
	public void obtenerVisualizacionTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);

		String expected = "testCarpeta" + " (" + caL.obtenerNoLeidos() + ")";
		assertEquals(expected, caL.obtenerVisualizacion());
	}

	/**
	 * Test obtenerNoLeidos
	 * 
	 * Prueba la obtencion de un item no leido
	 * 
	 */
	@Test
	public void obtenerNoLeidosTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me1 = new Mensaje(te);
		Mensaje me2 = new Mensaje(te);
		Mensaje me3 = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me1);
		caL.añadir(me2);
		caL.añadir(me3);

		int expected = 3;
		assertEquals(expected, caL.obtenerNoLeidos());
	}

	/**
	 * Test estableceLeidoTrue
	 * 
	 * Prueba el establecer un item como leido
	 * 
	 */
	@Test
	public void estableceLeidoTrueTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);
		caL.establecerLeido(true);
		int expected = 0;
		assertEquals(expected, caL.obtenerNoLeidos());
	}

	/**
	 * Test estableceLeidoFalse
	 * 
	 * Prueba el establcer un item como no leido
	 * 
	 */
	@Test
	public void estableceLeidoFalseTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);

		caL.establecerLeido(false);
		int expected = 1;
		assertEquals(expected, caL.obtenerNoLeidos());
	}

	/**
	 * Test obteneIcono
	 * 
	 * Prueba a obtener el Icono de una Carpeta.
	 * 
	 */
	@Test
	public void obtenerIconoTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);
		caL.establecerLeido(true);

		assertEquals(new Integer(1), caL.obtenerIcono());
	}

	/**
	 * Test obtenerPreVisualizacion
	 * 
	 * Prueba la obtencion de la PreVisualizacion de una Carpeta.
	 * 
	 */
	@Test
	public void obtenerPrevisualizacionTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);

		assertEquals(caL.obtenerVisualizacion(), caL.obtenerPreVisualizacion());
	}

	/**
	 * Test explorar .
	 * 
	 * Prueba el explorar una Carpeta
	 * 
	 * 
	 */
	@Test
	public void obtenerExplorarTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);
		Collection expected = new ArrayList();
		expected.add(me);
		Collection p = caL.explorar();
		assertEquals(expected.size(), p.size());

	}

	/**
	 * Test buscar
	 * 
	 * Prueba la busqueda de un item y lo devuelve en forma de colecion
	 * 
	 */
	@Test
	public void buscarTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me1 = new Mensaje(te);
		Mensaje me2 = new Mensaje(te);
		Mensaje me3 = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me1);
		caL.añadir(me2);
		caL.añadir(me3);
		Collection expected = new ArrayList<>();
		expected.add(me1);
		expected.add(me2);
		expected.add(me3);

		assertEquals(expected.size(), caL.buscar("contenido").size());
	}

	/**
	 * Test buscar
	 * 
	 * Prueba la busqueda de un item que no existe
	 * 
	 */
	@Test
	public void buscarNoEncontrarTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);
		Collection expected = new ArrayList<>();
		assertEquals(expected, caL.buscar("test"));
	}

	/**
	 * Test añadir
	 * 
	 * añadir un item a una Carpeta
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void añadirTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);

		assertEquals(1, caL.explorar().size());
	}

	/**
	 * Test eliminar
	 * 
	 * Eliminar un item a una Carpeta
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void eliminarTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca = new Carpeta("testCarpeta");
		CarpetaLimitada caL = new CarpetaLimitada(ca, 4);
		caL.añadir(me);
		caL.eliminar(me);
		assertEquals(0, caL.explorar().size());
	}

	/**
	 * Test eliminar
	 * 
	 * Eliminar un item dentro de una carpeta que a su vez esta en otra Carpeta
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void eliminarCascadaTest() throws OperacionInvalida {
		Texto te = new Texto("test", "contenido");
		Mensaje me = new Mensaje(te);
		Carpeta ca1 = new Carpeta("testCarpeta");
		Carpeta ca2 = new Carpeta("testCarpeta2");
		CarpetaLimitada caL1 = new CarpetaLimitada(ca1, 4);
		CarpetaLimitada caL2 = new CarpetaLimitada(ca2, 4);
		caL1.añadir(caL2);
		caL2.añadir(me);
		caL1.eliminar(me);
		assertEquals(1, caL1.explorar().size());
	}

}

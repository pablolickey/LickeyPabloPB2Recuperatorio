package recuperatorio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void crearUnMontacargas() {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		assertNotNull(montacarga);
	}
	
	@Test
	public void crearUnaCarga() {
		Integer cargaId=1;
		Double pesoDeCarga=800.0;
		Carga carga= new Carga(cargaId,pesoDeCarga);
		
		assertEquals(800.0,carga.getPeso(),0.0);
		
	}
	
	
	@Test 
	public void cargarYobtenerCargaActual() throws NoExisteCarga, PesoExcesivo {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		Double pesoDeCarga=800.0;
		montacarga.cargarCarga(pesoDeCarga);
		
		assertEquals(800.0,montacarga.getCargaActual().getPeso(),0.0);
		
	}
	
	@Test (expected = PesoExcesivo.class)
	public void siLaCargaSuperaAlPesoMaximoLanzarExcepcion() throws NoExisteCarga, PesoExcesivo {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		Double pesoDeCarga=1600.0;
		montacarga.cargarCarga(pesoDeCarga);
		
		
		
	}
	
	@Test(expected = NoExisteCarga.class)
	public void siNoExisteCargaLanzarExcepcion() throws NoExisteCarga {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		assertNull(montacarga.getCargaActual());
	}
	
	@Test(expected = NoExisteCarga.class)
	public void descargarCarga() throws NoExisteCarga, PesoExcesivo {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		Double pesoDeCarga=800.0;
		montacarga.cargarCarga(pesoDeCarga);
		
		montacarga.descargarCarga();
		
		assertEquals((Integer)1,montacarga.getCantidadDeCargasCompletadas());
		assertNull(montacarga.getCargaActual());
	}
	
	@Test
	public void obtenerPromedioDeCargas() throws NoExisteCarga, PesoExcesivo {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		Double pesoDeCarga=800.0;
		montacarga.cargarCarga(pesoDeCarga);
		montacarga.descargarCarga();
		
		Double pesoDeCarga2=900.0;
		montacarga.cargarCarga(pesoDeCarga2);
		montacarga.descargarCarga();
		
		Double pesoDeCarga3=850.0;
		montacarga.cargarCarga(pesoDeCarga3);
		montacarga.descargarCarga();
		
		assertEquals(850.0,montacarga.obtenerPromedioDeCargas(),0.0);
		
	}
}

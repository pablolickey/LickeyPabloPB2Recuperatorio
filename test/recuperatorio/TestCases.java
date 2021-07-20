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
	public void cargarYobtenerCargaActual() throws NoExisteCarga {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		Double pesoDeCarga=800.0;
		montacarga.cargarCarga(pesoDeCarga);
		
		assertEquals(800.0,montacarga.getCargaActual().getPeso(),0.0);
		
	}
	
	@Test(expected = NoExisteCarga.class)
	public void siNoExisteCargaLanzarExcepcion() throws NoExisteCarga {
		Double pesoMaximo=1500.0;
		Montacarga montacarga=new Montacarga(pesoMaximo);
		
		assertNotNull(montacarga.getCargaActual());
	}
}

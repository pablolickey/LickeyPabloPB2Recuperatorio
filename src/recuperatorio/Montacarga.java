package recuperatorio;

import java.util.ArrayList;

public class Montacarga {
	private Double pesoMaximo;
	private Carga cargaActual;
	private Integer cargaId=0;
	private ArrayList<Carga>cargasCompletadas=new ArrayList<Carga>();
	
	public Montacarga(Double pesoMaximo) {
		this.pesoMaximo=pesoMaximo;
	}

	public void cargarCarga(Double pesoDeCarga) throws PesoExcesivo {
		this.cargaId++;
		if(pesoDeCarga<=this.pesoMaximo) {
			this.cargaActual=new Carga(this.cargaId,pesoDeCarga);			
		}else {
			throw new PesoExcesivo();
		}
	}


	public Carga getCargaActual() throws NoExisteCarga {
		if(cargaActual!=null) {			
			return cargaActual;
		}else {
			throw new NoExisteCarga();
		}
	}


	public void descargarCarga(Carga cargaActual) {
		this.cargasCompletadas.add(cargaActual);
		this.cargaActual=null;
	}

	public Integer getCantidadDeCargasCompletadas() {
		return this.cargasCompletadas.size();
	}

	public Double obtenerPromedioDeCargas() {
		Double promedio=0.0;
		Double pesoTotal=0.0;
		for(Carga carga : this.cargasCompletadas) {
			pesoTotal=pesoTotal+carga.getPeso();
		}
		
		promedio=pesoTotal/cargaId;
		
		return promedio;
	}
	
	

}

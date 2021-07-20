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

	public void cargarCarga(Double pesoDeCarga) {
		this.cargaId++;
		this.cargaActual=new Carga(this.cargaId,pesoDeCarga);
	}

	public Double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public Carga getCargaActual() throws NoExisteCarga {
		if(cargaActual!=null) {			
			return cargaActual;
		}else {
			throw new NoExisteCarga();
		}
	}


	public Integer getCargaId() {
		return cargaId;
	}

	public void setCargaId(Integer cargaId) {
		this.cargaId = cargaId;
	}

	public ArrayList<Carga> getCargasCompletadas() {
		return cargasCompletadas;
	}

	public void setCargasCompletadas(ArrayList<Carga> cargasCompletadas) {
		this.cargasCompletadas = cargasCompletadas;
	}
	
	

}

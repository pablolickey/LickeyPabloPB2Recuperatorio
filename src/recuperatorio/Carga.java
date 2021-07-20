package recuperatorio;

public class Carga {
	private Integer cargaId;
	private Double peso;
	
	
	public Carga(Integer cargaId, Double peso) {
		this.cargaId = cargaId;
		this.peso = peso;
	}


	public Integer getCargaId() {
		return cargaId;
	}


	public void setCargaId(Integer cargaId) {
		this.cargaId = cargaId;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	

}

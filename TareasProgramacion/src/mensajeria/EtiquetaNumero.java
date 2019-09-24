package mensajeria;

public class EtiquetaNumero{

	EtiquetaTexto e;
	long id;
	
	
	
	public EtiquetaNumero(EtiquetaTexto e, long id) {
		this.e = e;
		this.id = id;
	}

	

	public EtiquetaTexto getE() {
		return e;
	}



	public void setE(EtiquetaTexto e) {
		this.e = e;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "EtiquetaNumero [e=" + e + ", id=" + id + "]";
	}



	public long asignar_id(){
		this.id++;
		return id;
	}
	
}

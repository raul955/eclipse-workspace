package transporte;

public class Unidades {

	int cantidad;

	public Unidades(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Unidades [cantidad=" + cantidad + "]";
	}
	
	
	
}

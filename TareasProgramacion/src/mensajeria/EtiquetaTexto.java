package mensajeria;

public class EtiquetaTexto {

	String nombre;
	String direccion;
	
	public EtiquetaTexto(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "EtiquetaTexto [nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
}

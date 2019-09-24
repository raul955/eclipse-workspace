package Laboral;

public class DatosIncorrectosException extends Exception {

	DatosIncorrectosException() {
		  super("Datos no introducidos correctamente");
	}

	
	public DatosIncorrectosException(String mensaje) {
		  super(mensaje);
	}
	

}

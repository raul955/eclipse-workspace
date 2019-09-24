package Laboral;
/**
 * Creamos la excepcion para que me imprima por pantalla si da fallo
 */
public class DatosIncorrectosException extends Exception {
	
	/**
	 * Excepcion en caso de fallo
	 */
	DatosIncorrectosException() {
		  super("Datos no introducidos correctamente");
	}

	/**
	 * Menasaje de error
	 * @param mensaje
	 */
	public DatosIncorrectosException(String mensaje) {
		  super(mensaje);
	}
	

}

/**
 * Clase que permite asignarle a las personas la categoria y los anyos que lleva en la empresa
 * ademas de recibir los atributos de la clase padre Persona.
 */
package Laboral;

public class Empleado extends Persona {

	private int categoria;
	int anyos;

	/**
	 * Constructor con parametros
	 * @param nombre El nombre de la persona
	 * @param dni El dni de la persona 
	 * @param sexo El sexo de la persona
	 * @throws DatosIncorrectosException 
	 */
	public Empleado(String nombre, String dni, char sexo) throws DatosIncorrectosException{
		super(nombre, dni, sexo);
		this.categoria = 1;
		this.anyos = 0;

	}
	
	/**
	 * Constructor con parametros
	 * @param nombre El nombre del Empleado
	 * @param dni El dni del Empleado
	 * @param sexo El sexo del Empleado
	 * @param categoria La categoria del Empleado
	 * @param anyos Los anyos del Empleado
	 * @throws DatosIncorrectosException 
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosIncorrectosException {
		super(nombre,dni,sexo);		
		
		this.setCategoria(categoria);
		
		if(anyos < 0) {//Ponemos una condicion para que los anyos sean positivos o si no me salga la excepcion
			throw new DatosIncorrectosException("ANYOS NO INTRODUCIDOS CORRECTAMENTE"); 
		}else {
			this.anyos = anyos;
		}
	}

	/**
	 * Metodo para obtener la categoria de empleado
	 * @return categoria del empleado
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * Metodo que asigne la categoria y salte una excepcion si los datos no estan introducidos correctamente
	 * @param categoria
	 * @throws DatosIncorrectosException
	 */
	public void setCategoria(int categoria) throws DatosIncorrectosException {
		//Ponemos una condicion que solo coja la categoria si esta entre 0 y 10, o si no me salga la excepcion
		if(categoria > 0 && categoria < 10) {
			this.categoria = categoria;
		}else {
			throw new DatosIncorrectosException("CATEGORIA INCORRECTA");
		}
		
	}
	/**
	 * Metodo incremento de anyos empleado:
	 */
	public void incrAnyos() {
		anyos++;
	}
	/**
	 * 
	 */
	public void setSexo(char sexo) throws DatosIncorrectosException {
		if(sexo == 'M' || sexo == 'F') {
			this.sexo = sexo;
		}else {
			throw new DatosIncorrectosException();
		}
	}
	
	/**
	 * Metodo para imprimir los datos de la clase
	 * @return
	 */
	@Override
	public String imprime() {
		String datosempleado = super.imprime()+"categoria:"+categoria+" años:" +anyos+" ";

		return datosempleado;

		
	}
	
}

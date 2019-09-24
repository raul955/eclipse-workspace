package Laboral;

public class Persona {
		//Atributos
		String nombre;
		String dni;
		char sexo;
		/**
		 * Metodo Imprimir. 
		 * @return
		 */
		public String imprime() {
			String datospersona = "nombre:"+nombre+" dni:" +dni+" ";
			return datospersona;
		}
		/**
		 * Constructor con parametros
		 * @param nombre Nombre de la persona
		 * @param dni DNI de la persona
		 * @param sexo SEXO de la persona
		 * @throws DatosIncorrectosException 
		 */
		//Creamos el constructor correspondiente para sus atributos.
		public Persona(String nombre, String dni, char sexo) throws DatosIncorrectosException {
			this.nombre = nombre;
			setDni(dni);
			setSexo(sexo);

		}
		
		/**
		 * Constructor con parametros 
		 * @param nombre Nombre de la persona
		 * @param sexo SEXO de la persona
		 * @throws DatosIncorrectosException 
		 */
		//Creamos otro constructor solo para nombre y sexo.
		public Persona(String nombre, char sexo) throws DatosIncorrectosException {
			this.nombre = nombre;
			setSexo(sexo);
			
		}
		/**
		 * Constructor con parametro
		 * @param dni DNI de la Persona
		 * @throws DatosIncorrectosException
		 */
		//Hago un set del dni

		
		/**
		 * Constructor con parametros
		 * @param sexo Sexo de la Persona
		 * @throws DatosIncorrectosException
		 */
		public void setSexo(char sexo) throws DatosIncorrectosException {
			if(sexo == 'M' || sexo == 'F') {
				this.sexo = sexo;
			}else {
				throw new DatosIncorrectosException("SEXO NO INTRODUCIDO CORRECTAMENTE");
			}
		}

		public void setDni(String dni) {
			this.dni = dni;
		}
		/**
		 * @return the dni
		 */
		public String getDni() {
			return dni;
		}
		
		
		
}

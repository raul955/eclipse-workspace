package Laboral;

public class CalcularNominas {

	public static void main(String[] args) {

		/**
		 * Dentro del metodo main debemos hacer que nos coja la excepcion, 
		 * ademas de crear los nuevos empleados que nos piden, y ponerle los incrementos 
		 * y las asignaciones necesarias.
		 */
		try {//Inicializamos la excepcion para ty-catch para poder conprobar los parametros.
			//Creamos nuevos empleados con sus respectivos parametros.
			Empleado james = new Empleado("James Cosling", "48124096T", 'M', 4,7);
			Empleado ada = new Empleado("Ada Lovelace","48811600B",'F');
			
			escribe(james, ada);
			
			//Hacemos un incremento de años a ada.
			ada.incrAnyos();
			
			//Le asignamos a james la categoria 9.
			james.setCategoria(9);
			
			//Escribimos los empleados para poder comprobar que hemos puesto bien los apartados.
			escribe(james,ada);
		/*
		 * Si los nuevos empleados no estan bien puestos debemos hace que nos salte una excepcion
		 * que nos diga que hemos introducido mal los parametros
		 */
		}catch (DatosIncorrectosException escribe) {//Hacemos que reciba la excepcion de manera que escriba si esta bien o no los datos
			
			System.out.println(escribe.toString());
		
		}

		
	}
	/**
	 * Creamos un metodo aparte del main donde pintaremos el resultado final del codigo despues de cambiar el codigo anteriormente
	 * @param emp1
	 * @param emp2
	 */
	private static void escribe(Empleado emp1, Empleado emp2) {
		
		System.out.println(emp1.imprime()+",sueldo:"+ Nomina.sueldo(emp1));
		System.out.println(emp2.imprime()+",sueldo:"+ Nomina.sueldo(emp2));

	}
	
	

}

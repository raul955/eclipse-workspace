package Laboral;

/*
 * Los errores que presentaba el ejercicio en clase eran:
 * 1.- En los condicionales de las validaciones itilizaba el operador || en lugar de &&.
 * 2-. El método que enviaba el mensaje de la excepción no enviaba ningún mensaje, por lo que he tomado el contenido
 * 	   de la excepción del ejercicio enviado por José Vicente.
 */

public class CalculaNominas {

	public static void main(String args[])  {

		System.out.println("Hola");
		
		try {
			
			Empleado m = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
			Empleado f = new Empleado("Ada Lovelace", "32000031R", 'F');
	
			escribeTodo(m, f);
	
			f.incranyos();
			m.setCategoria(9);
	
			escribeTodo(m, f);
		
		}catch(DatosIncorrectosException e){

			System.out.println(e.toString());
			
		}

	}

	private static void escribeTodo(Empleado emp1, Empleado emp2) {

		System.out.println(emp1.imprime()+",sueldo:"+ Nomina.sueldo(emp1));
		System.out.println(emp2.imprime()+",sueldo:"+ Nomina.sueldo(emp2));

	}



}

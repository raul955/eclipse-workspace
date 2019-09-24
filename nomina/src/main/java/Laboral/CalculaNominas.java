package Laboral;

public class CalculaNominas {

	public static void main(String args[]) {
		
		
		try {
			
			Empleado james = new Empleado("James Cosling", "48124096T", 'M', 4,7);
			Empleado ada = new Empleado("Ada Lovelace","48811600B",'F');
			
			System.out.println("\n");
			System.out.println("**************Primera escritura");
			
			escribe(james,ada);
			
			ada.incrAnyo();
			
			james.setCategoria(9);
			
			System.out.println("\n");
			System.out.println("**************Segunda escritura");
			
			escribe(james,ada);
			
		} catch (DatosIncorrectosException e) {
			
			System.out.println("Datos incorrectos");
		}		
		
	}
	
	private static void escribe(Empleado emp1, Empleado emp2) {
		
		System.out.println(emp1.imprime()+",sueldo:"+ Nomina.sueldo(emp1));
		System.out.println(emp2.imprime()+",sueldo:"+ Nomina.sueldo(emp2));

		
	}
	
}

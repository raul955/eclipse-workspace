package Laboral;
/**
 * Clase estatica que permite calcular los sueldos de los empleados segun sus anyos y su categoria
 */
public class Nomina{

	/**
	 * Array categoria sueldo
	 */
	//Creamos un atributo estatico en el cual ponemos todos los sueldos dados anteriormente
	private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};

	/**
	 * Constructor con parametros
	 * @param emp Sueldo del empleado
	 * @return
	 */
	//Creamos un metodo publico que haga la operacion de calcular los sueldos de los empleados segun su categoria * anyos;
	public static int sueldo(Empleado emp) {
		int sueldo = SUELDO_BASE[emp.getCategoria()-1]+5000*emp.anyos;
		
		
		return sueldo;
	}
		
	

}

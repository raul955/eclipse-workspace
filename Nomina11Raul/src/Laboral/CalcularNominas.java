package Laboral;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;





public class CalcularNominas implements Serializable{

	public static void main(String args[]) {
		
		try {
				
			Leer_Fichero accediendo = new Leer_Fichero();
			
			System.out.println("Primera lectura del fichero");
			accediendo.lee();
					
			Empleado james = new Empleado("James Cosling", "48124096T", 'M', 4,7);
			Empleado ada = new Empleado("Ada Lovelace","48811600B",'F');
			System.out.println("\n");
			System.out.println("-------------------------------------\nPrimera escritura en consola");
			escribe(james, ada);
			
			
			ada.incrAnyos();
			
			
			james.setCategoria(9);
			
			System.out.println("------------------------------------\nEscritura con modificacion de datos");
			escribe(james,ada);
			System.out.println("-------------------------------------");
			System.out.println("Leyendo del fichero datos modificados");
			accediendo.lee();
		
			escribebinario(james, ada);
			
		}catch (DatosIncorrectosException escribe) {
			
			System.out.println(escribe.toString());
		
		}

		
		/**
		 *  CREATE TABLE empleados(
			nombre varchar2(100),
			dni varchar2(100),
			sexo varchar2(100),
			categoria varchar2(100),
			anyos NUMBER(5)
			);

			create table nominas(
			sueldo number(20)
			);
			
			alter table nominas add nombre varchar2(100);
			alter table nominas add dni varchar2(100);
		 */
		
		try{
			
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			
			// 1. Crear conexion
			
			String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");
			
			// 2. Crear objeto statement
			
			Statement miStatement = miConexion.createStatement();
			
			String instruccionSQL="insert into empleados(nombre,dni,sexo,categoria,anyos)values('James Cosling','48124096T','M','4',7)";
			
			miStatement.executeUpdate(instruccionSQL);
			
			String instruccionSQL2="insert into empleados(nombre,dni,sexo,categoria,anyos)values('Ada Lovelace','48811600B','F','','')";
			
			miStatement.executeUpdate(instruccionSQL2);
			
			String instruccionSQL3="DELETE FROM empleados where nombre = 'James Cosling'";
			
			miStatement.executeUpdate(instruccionSQL3);
			
			String instruccionSQL4="DELETE FROM empleados where nombre = 'Ada Lovelace'";
			
			miStatement.executeUpdate(instruccionSQL4);
			
			String instruccionSQL5="insert into empleados(nombre,dni,sexo,categoria,anyos)values('James Cosling','48124096T','M','9',7)";
			
			miStatement.executeUpdate(instruccionSQL5);
			
			String instruccionSQL6="insert into empleados(nombre,dni,sexo,categoria,anyos)values('Ada Lovelace','48811600B','F','1','1')";
			
			miStatement.executeUpdate(instruccionSQL6);
			
			String instruccionSQL7="insert into nominas(sueldo,nombre,dni)values(245000,'James Cosling','48124096T')";
			
			miStatement.executeUpdate(instruccionSQL7);
			
			String instruccionSQL8="insert into nominas(sueldo,nombre,dni)values(55000,'Ada Lovelace','48811600B')";
			
			miStatement.executeUpdate(instruccionSQL8);
			
			System.out.println("\n");
			System.out.println("Los datos se han modificado correctamente en la base de datos");
			
			
		}catch(Exception e){
			
			System.out.println("No ha sido posible la conexión.");
			
			e.printStackTrace();
			
		}
		
		
	}
	

	/**
	 * escribo el dni y el sueldo en un fichero sueldos.txt, ha sido necesario 
	 * añadir un metodo toString en la clase empleado y el get de dni en la clase
	 * persona.
	 * @param emp1
	 * @param emp2
	 */
	public static void escribebinario(Empleado emp1, Empleado emp2) {
		
		String fileSueldos = (emp1.toString()+",sueldo:"+ Nomina.sueldo(emp1));
		String fileSueldos2 = (emp2.toString()+",sueldo:"+ Nomina.sueldo(emp2));
		
		try {
			
			FileWriter escritura =  new FileWriter("sueldos.txt");
			//FileOutputStream escritura = new FileOutputStream("sueldos.dat");
			
			escritura.write(fileSueldos);

			escritura.write(fileSueldos2);
			
			escritura.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Implemento la escritura en el fichero empleados.txt en el método escribe
	 * 
	 * @param emp1
	 * @param emp2
	 */
	private static void escribe(Empleado emp1, Empleado emp2) {
		
		System.out.println(emp1.imprime()+",sueldo:"+ Nomina.sueldo(emp1));
		System.out.println(emp2.imprime()+",sueldo:"+ Nomina.sueldo(emp2));

		String datos = (emp1.imprime()+",sueldo:"+ Nomina.sueldo(emp1));
		String datos2 = (emp2.imprime()+",sueldo:"+ Nomina.sueldo(emp2));
		
		try {
			FileWriter escritura =  new FileWriter("empleados.txt");
			
			escritura.write(datos);
			escritura.append("\r\n");
			escritura.write(datos2);
			
			escritura.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

}

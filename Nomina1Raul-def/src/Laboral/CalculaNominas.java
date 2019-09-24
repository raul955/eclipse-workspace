package Laboral;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CalculaNominas {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		try {

			Empleado m = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
			Empleado f = new Empleado("Ada Lovelace", "32000031R", 'F');

			escribeTodo(m, f);

			f.incranyos();
			m.setCategoria(9);

			escribeTodo(m, f);

			System.out.println(" ");

			Leer_Fichero accediendo = new Leer_Fichero();

			System.out.println("Primera lectura de fichero");
			accediendo.lee();
			System.out.println(" ");

			System.out.println(" ");

			System.out.println("Escribiendo en fichero binario...");
			escribebinario(m, f);

			System.out.println("Modificando datos en empleados.txt...");
			escribeFichero(m, f);

		} catch (DatosIncorrectosException e) {

			System.out.println(e.toString());

		}

		System.out.println("Insertando datos en la BBDD...");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1. Crear conexion

			String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

			// 2. Crear objeto statement

			Statement miStatement = miConexion.createStatement();

			String instruccionSQL = "insert into empleados(nombre,dni,sexo,categoria,anyos)values('James Cosling','32000032G','M','4',7)";

			miStatement.executeUpdate(instruccionSQL);

			String instruccionSQL2 = "insert into empleados(nombre,dni,sexo,categoria,anyos)values('Ada Lovelace','32000031R','F','','')";

			miStatement.executeUpdate(instruccionSQL2);

			String instruccionSQL3 = "UPDATE EMPLEADOS set categoria = '9' where categoria='4' and dni = '32000032G'";

			miStatement.executeUpdate(instruccionSQL3);

			String instruccionSQL4 = "UPDATE EMPLEADOS SET ANYOS = '1' WHERE ANYOS = '' AND DNI = '32000031R'";

			miStatement.executeUpdate(instruccionSQL4);

			String instruccionSQL6 = "UPDATE EMPLEADOS SET CATEGORIA = '1' WHERE CATEGORIA ='' AND DNI = '32000031R'";

			miStatement.executeUpdate(instruccionSQL6);

			String instruccionSQL7 = "insert into nominas(sueldo,dni)values(145000,'32000032G')";

			miStatement.executeUpdate(instruccionSQL7);

			String instruccionSQL8 = "insert into nominas(sueldo,dni)values(50000,'32000031R')";

			miStatement.executeUpdate(instruccionSQL8);

			String instruccionSQL9 = "update nominas set sueldo = 245000 where sueldo = 145000 and dni='32000032G'";

			miStatement.executeUpdate(instruccionSQL7);

			String instruccionSQL810 = "update nominas set sueldo = 55000 where sueldo = dni = 50000 and '32000031R'";

			miStatement.executeUpdate(instruccionSQL8);

			System.out.println("");
			System.out.println("Los datos se han modificado correctamente en la base de datos");

		} catch (Exception e) {

			System.out.println("No ha sido posible la conexiÃ³n 001.");

			e.printStackTrace();
		}

		System.out.println("Dando de alta nuevo empleado en la BBDD...");
		try {

			Empleado t;
			t = new Empleado("raul", "12345678G", 'M', 5, 6);
			Empleado.altaEmpleado(t);
		} catch (DatosIncorrectosException e1) {
			System.out.println("ERR0R Datos incorrectos altaEmpleado");
			e1.printStackTrace();
		}

//		5.1. Mostrar la información existente en la base de datos de todos los empleados
//		(nombre, dni, sexo, categoría y años trabajados).
//		5.2. Mostrar el salario existente en la base de datos de un empleado especificado
//		por su dni.
//		5.3. Mostrar un submenú que permita modificar todos los datos de los empleados
//		almacenados en la base de datos. El sueldo del empleado es un campo
//		calculado y no es posible modificarlo, debiendo actualizarse automáticamente
//		al modificar la categoría o los años trabajados de un empleado.
//		5.4. Recalcular y actualizar el sueldo de un empleado.
//		5.5. Recalcular y actualizar los sueldos de todos los empleados.
//		5.6. Realizar una copia de seguridad de la base de datos en ficheros.

		System.out.println("Realizando copia de seguridad en ficheros...");
		Backup b = new Backup();
		Backup.backups();

		System.out.println(" ");
		// ----------------------------------------------------
		Scanner s = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {

			System.out.println("Elija una de las siguientes opciones: ");
			System.out.println("1-. Mostrar la información de los empleados.");
			System.out.println("2-. Mostrar sueldo por dni.");
			System.out.println("3-. Modificar datos");
			System.out.println("4-. Recalcular y actualizar el sueldo de un empleado.");
			System.out.println("5-. Recalcular y actualizar los sueldos de todos los empleados.");
			System.out.println("6-. Realizar una copia de seguridad de la base de datos en ficheros.");
			System.out.println("Cualquier otro para salir");
			opcion = s.nextInt();

			if (opcion == 1) {

				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");

					// 1. Crear conexion

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

					// 2. Crear objeto statement

					Statement miStatement = miConexion.createStatement();

					// 3. Ejecutar SQL

					ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM empleados");

					// 4. Recorrer el resultSet

					while (miResultSet.next()) {

						System.out.println(miResultSet.getString("NOMBRE") + " " + miResultSet.getString("DNI") + " "
								+ miResultSet.getString("SEXO") + " " + miResultSet.getString("CATEGORIA") + " "
								+ miResultSet.getString("ANYOS"));

					}

				} catch (SQLException e) {

					System.out.println("No ha sido posible la conexión.");

					e.printStackTrace();

				}

			} else if (opcion == 2) {

				try {
					System.out.println("Introduzca DNI");
					String dni = sc.nextLine();

					Class.forName("oracle.jdbc.driver.OracleDriver");

					// 1. Crear conexion

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

					// 2. Crear objeto statement

					Statement miStatement = miConexion.createStatement();

					// 3. Ejecutar SQL

					ResultSet miResultSet = miStatement
							.executeQuery("SELECT sueldo from nominas where dni='" + dni + "'");

					// 4. Recorrer el resultSet

					while (miResultSet.next()) {

						System.out.println(miResultSet.getString("sueldo"));

					}

				} catch (SQLException e) {

					System.out.println("No ha sido posible la conexión.");

					e.printStackTrace();

				}

			} else if (opcion == 3) {

				System.out.println("¿Qué dato desea modificar?");
				System.out.println("1-Nombre");
				System.out.println("2-DNI");
				System.out.println("3-Sexo");
				System.out.println("4-Categoría");
				System.out.println("5-Anyos");
				int opcion2 = s.nextInt();

				if (opcion2 == 1) {

					System.out.println("Introduzca el dni de la persona a modificar");
					String dni = sc.nextLine();
					System.out.println("Introduzca el nuevo nombre.");
					String dato = sc.nextLine();

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

					Statement miStatement = miConexion.createStatement();

					String instruccionSQL = "UPDATE EMPLEADOS set nombre = '" + dato + "' where dni='" + dni + "'";

					miStatement.executeUpdate(instruccionSQL);
				} else if (opcion2 == 2) {

					System.out.println("Introduzca el dni de la persona a modificar");
					String dni = sc.nextLine();
					System.out.println("Introduzca el nuevo dni.");
					String dato = sc.nextLine();

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

					Statement miStatement = miConexion.createStatement();

					String instruccionSQL = "UPDATE EMPLEADOS set dni = '" + dato + "' where dni='" + dni + "'";

					miStatement.executeUpdate(instruccionSQL);

				} else if (opcion2 == 3) {

					System.out.println("Introduzca el dni de la persona a modificar");
					String dni = sc.nextLine();
					System.out.println("Introduzca el nuevo sexo.");
					String dato = sc.nextLine();

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

					Statement miStatement = miConexion.createStatement();

					String instruccionSQL = "UPDATE EMPLEADOS set sexo = '" + dato + "' where dni='" + dni + "'";

					miStatement.executeUpdate(instruccionSQL);

				} else if (opcion2 == 4) {

					System.out.println("Introduzca el dni de la persona a modificar");
					String dni = sc.nextLine();
					System.out.println("Introduzca la nueva categoría.");
					String dato = sc.nextLine();

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

					Statement miStatement = miConexion.createStatement();

					String instruccionSQL = "UPDATE EMPLEADOS set categoria = '" + dato + "' where dni='" + dni + "'";

					miStatement.executeUpdate(instruccionSQL);

				} else if (opcion2 == 5) {

					System.out.println("Introduzca el dni de la persona a modificar");
					String dni = sc.nextLine();
					System.out.println("Introduzca el nuevo Anyo.");
					String dato = sc.nextLine();

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

					Statement miStatement = miConexion.createStatement();

					String instruccionSQL = "UPDATE EMPLEADOS set anyo = '" + dato + "' where dni='" + dni + "'";

					miStatement.executeUpdate(instruccionSQL);
				} else {
					System.out.println("Opción incorrecta.");
				}

			} else if (opcion == 4) {
				// Recalcular y actualizar el sueldo de un empleado

				System.out.println("Introduzca el dni de la persona a modificar");
				String dni = sc.nextLine();
				System.out.println("Introduzca nueva categoria.");
				int cat = s.nextInt();
				System.out.println("Introduzca nuevos anyos.");
				int an = s.nextInt();

				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
				Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

				Statement miStatement = miConexion.createStatement();

				String instruccionSQL = "UPDATE EMPLEADOS set categoria = '" + cat + "' where dni='" + dni + "'";

				miStatement.executeUpdate(instruccionSQL);

				String instruccionSQL3 = "UPDATE EMPLEADOS set anyos = " + an + " where dni='" + dni + "'";

				miStatement.executeUpdate(instruccionSQL3);

				String instruccionSQL2 = "UPDATE nominas set sueldo = " + Nomina.sueldo(cat, an) + " where dni='" + dni
						+ "'";

				miStatement.executeUpdate(instruccionSQL2);

			} else if (opcion == 5) {
				//recalcular y actualizar los sueldos de todos los empleados.
				
				System.out.println("Introduzca nueva categoria para TODOS los empleados.");
				int cat = s.nextInt();
				System.out.println("Introduzca nuevos anyos para TODOS los empleados.");
				int an = s.nextInt();

				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
				Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

				Statement miStatement = miConexion.createStatement();

				String instruccionSQL = "UPDATE EMPLEADOS set categoria = '" + cat + "'";

				miStatement.executeUpdate(instruccionSQL);

				String instruccionSQL3 = "UPDATE EMPLEADOS set anyos = " + an;

				miStatement.executeUpdate(instruccionSQL3);

				String instruccionSQL2 = "UPDATE nominas set sueldo = " + Nomina.sueldo(cat, an);

				miStatement.executeUpdate(instruccionSQL2);
				
			}else if(opcion==6) {
				//Realizar una copia de seguridad de la base de datos en ficheros.
				Backup.backups();
				System.out.println("Copia de seguridad realizada.");
				
			}else {
				System.out.println("Pase un buen día.");
			}

		} while (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 5 || opcion == 4 || opcion == 6);

	}

	public static void escribebinario(Empleado emp1, Empleado emp2) {

		String separador = ";";
		String fileSueldos = (emp1.toString() + separador + Nomina.sueldo(emp1) + separador);
		String fileSueldos2 = (emp2.toString() + separador + Nomina.sueldo(emp2) + separador);

		try {

			FileOutputStream fos = new FileOutputStream("sueldos.dat");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter salida = new BufferedWriter(osw);

			salida.write(fileSueldos);
			salida.append("\r\n");
			salida.write(fileSueldos2);
			salida.flush();
			fos.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void escribeTodo(Empleado emp1, Empleado emp2) {

		String separador = ";";
		System.out.println(emp1.imprime() + separador + Nomina.sueldo(emp1));
		System.out.println(emp2.imprime() + separador + Nomina.sueldo(emp2));

	}

	private static void escribeFichero(Empleado emp1, Empleado emp2) {

		String separador = ";";
		String datos = (emp1.imprime() + separador + Nomina.sueldo(emp1) + separador);
		String datos2 = (emp2.imprime() + separador + Nomina.sueldo(emp2) + separador);

		try {
			FileWriter escritura = new FileWriter("empleados.txt");

			escritura.write(datos);
			escritura.append("\r\n");
			escritura.write(datos2);

			escritura.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

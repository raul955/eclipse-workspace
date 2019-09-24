package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;


/*
 * No creo el método  cargaTablaCochesUnicos() porque el método cargaTablaCoches() ya actua de esa forma
 * al ser primary key no se podrá insertar nunca una matrícula repetida
 */

public class Ejercicio1 {

	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {

		
		creaTablaCoches();
		truncateTable();
		cargaTablaCoches();
		System.out.println(existeCoche());

	}

	public static void creaTablaCoches() throws ClassNotFoundException, SQLException {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

			Statement miStatement = miConexion.createStatement();

			String instruccionSQL = "CREATE TABLE coches (matricula varchar(8) PRIMARY KEY NOT NULL,marca  Varchar(40) NOT NULL,modelo Varchar(40) NOT NULL, color Varchar(40) NOT NULL,anyo number(7) NOT NULL,precio number(7) NOT NULL)";
			miStatement.executeUpdate(instruccionSQL);

			miConexion.close();
			miStatement.close();

		} catch (SQLException e) {

			System.out.println("ERR0R: Don't Worry Be Happy. (La tabla ya existe)");

		}

	}

	public static void cargaTablaCoches() throws SQLException, IOException, ClassNotFoundException {

		// matrícula marca modelo color año precio

		try {

			FileReader entrada = new FileReader("datos.txt");
			BufferedReader mibuffer = new BufferedReader(entrada);

			String linea = "";

			linea = mibuffer.readLine();

			while (linea != null) {

				String[] array = linea.split(" ");

				System.out.println(Arrays.toString(array));

				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
				Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

				Statement miStatement = miConexion.createStatement();

				String instruccionSQL = "INSERT INTO coches (matricula,marca,modelo,color,anyo,precio) VALUES('"
						+ array[0] + "','" + array[1] + "','" + array[2] + "','" + array[3] + "'," + array[4] + ","
						+ array[5] + ")";
				miStatement.executeUpdate(instruccionSQL);

				miConexion.close();
				miStatement.close();

				linea = mibuffer.readLine();
			}

			entrada.close();
			mibuffer.close();

		} catch (SQLException e) {

			System.out.println(
					"ERR0R - Carga de elementos fallida, probablemente PRIMARY KEY violada, ejecuta el método tuncateTable()");

		}

	}

	public static void truncateTable() throws ClassNotFoundException {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

			Statement miStatement = miConexion.createStatement();

			String instruccionSQL = "truncate table coches";
			miStatement.executeUpdate(instruccionSQL);

			miConexion.close();
			miStatement.close();

		} catch (SQLException e) {
			System.out.println("ERR0R - Borrado fallido.");
			e.printStackTrace();
		}

	}
	
	public static boolean existeCoche() throws ClassNotFoundException {
		
		boolean confirma = false;
		
		try {
						
			int existe;
			
			Scanner s = new Scanner(System.in);
			String peticion;
			
			System.out.println("Inserte una matrícula para comprobar su existencia.");
			peticion=s.nextLine();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

			Statement miStatement = miConexion.createStatement();

			String instruccionSQL = "Select matricula from coches where matricula='"+peticion+"'";
			existe=miStatement.executeUpdate(instruccionSQL);
			
			if(existe==1) {
				confirma=true;
			}else if(existe==0) {
				confirma=false;
			}
			
			miConexion.close();
			miStatement.close();
			
		} catch (SQLException e) {
			System.out.println("ERR0R");
			e.printStackTrace();
		}
		return confirma;
			
	}

}

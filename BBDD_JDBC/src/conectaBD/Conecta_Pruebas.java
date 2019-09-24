package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conecta_Pruebas {

	public static void main(String args[]) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1. Crear conexion

			String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "gestion", "gestion");

			// 2. Crear objeto statement

			Statement miStatement = miConexion.createStatement();

			// 3. Ejecutar SQL

			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM articulos");

			// 4. Recorrer el resultSet

			while (miResultSet.next()) {

				System.out.println(miResultSet.getString("codart") + " " + miResultSet.getString("descrip") + " "
						+ miResultSet.getString("precio"));

			}

		} catch (Exception e) {

			System.out.println("No ha sido posible la conexión.");

			e.printStackTrace();

		}

	}

}

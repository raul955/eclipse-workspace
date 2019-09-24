package bbddFichero;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BBDDaFichero {

	public static void main(String args[]) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1. Crear conexion

			String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "gestion", "gestion");

			// 2. Crear objeto statement

			Statement miStatement = miConexion.createStatement();

			// 3. Ejecutar SQL

			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM articulos WHERE precio >500");

			// 4. Recorrer el resultSet e introducir cada registro en un fichero

			while (miResultSet.next()) {

				String contenido = (miResultSet.getString("codart") + " " + miResultSet.getString("descrip") + " "
						+ miResultSet.getString("precio"));
				String contenido2 = " \n ";
				try {
					FileWriter escritura = new FileWriter("contenido.txt", true);

					escritura.write(contenido);
					escritura.append("\r\n");

					escritura.close();

				} catch (IOException e) {

					e.printStackTrace();

				}
			}			
		} catch (Exception e) {

			System.out.println("No ha sido posible la conexión.");

			e.printStackTrace();

		}
	}
}

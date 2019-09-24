package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {

	public static void main(String args[]){
		
		try{
			
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			
			// 1. Crear conexion
			
			String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
			Connection miConexion = DriverManager.getConnection(url, "gestion", "gestion");
			
			// 2. Crear objeto statement
			
			Statement miStatement = miConexion.createStatement();
			
			String instruccionSQL="insert into articulos(codart,descrip,precio)values('123','Un corito sano',1000)";
			
			miStatement.executeUpdate(instruccionSQL);
			
			String instruccionSQL2="UPDATE articulos set precio=precio*2 where codart='123' ";
			
			miStatement.executeUpdate(instruccionSQL2);
			
			String instruccionSQL3="DELETE FROM ARTICULOS where codart = '123'";
			
			miStatement.executeUpdate(instruccionSQL3);
			
			System.out.println("Los datos se han modificado correctamente");
			
			
		}catch(Exception e){
			
			System.out.println("No ha sido posible la conexión.");
			
			e.printStackTrace();
			
		}
		
	}
	
}

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.Scanner" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<form>
<p2>Introduzca el DNI del empleado a modificar:</p2><br>
DNI<input type="text" name="dnibase"/><br>
<p2>----------------------------------------</p2><br>
<p2>Nuevos datos</p2><br>
NUEVO NOMBRE<input type="text" name="nombre"/><br>
NUEVO DNI<input type="text" name="dni"/><br>
NUEVO SEXO(M/F)<input type="text" name="sexo"/><br>
NUEVA CATEGORIA<input type="text" name="categoria"/><br>
NUEVO ANYO<input type="text" name="anyos"/><br>

<input type="submit" value="Enviar"/>




</form>
	
	<%
	
	try{
		
		String dnibase = request.getParameter("dnibase");
		
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String sexo = request.getParameter("sexo");
		String categoria =request.getParameter("categoria");
		String anyo = request.getParameter("anyos");
		
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@192.168.15.30:1521:xe";
		Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

		Statement miStatement = miConexion.createStatement();

		String instruccionSQL = "UPDATE EMPLEADOS set dni = '" + dni + "' where dni='" + dnibase + "'";

		miStatement.executeUpdate(instruccionSQL);
		
		String instruccionSQL2 = "UPDATE EMPLEADOS set nombre = '" + nombre + "' where dni='" + dnibase + "'";

		miStatement.executeUpdate(instruccionSQL2);
		
		String instruccionSQL3 = "UPDATE EMPLEADOS set sexo = '" + sexo + "' where dni='" + dnibase + "'";

		miStatement.executeUpdate(instruccionSQL3);
		
		String instruccionSQL4 = "UPDATE EMPLEADOS set categoria = '" + categoria + "' where dni='" + dnibase + "'";

		miStatement.executeUpdate(instruccionSQL4);
		
		String instruccionSQL5 = "UPDATE EMPLEADOS set anyos = '" + anyo + "' where dni='" + dnibase + "'";

		miStatement.executeUpdate(instruccionSQL5);
		
		
		
	}catch(SQLException e) {

		out.println("No ha sido posible la conexion.");

		e.printStackTrace();
		
		

	}
	
	
	
	
	%>

<a href="index.jsp"><input type="button" value="Volver" style="height: 28px; width: 500px;"/></a>
</body>
</html>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.Scanner" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>


<form>
<p>Introduzca el dni del empleado a consultar: </p>
<input type="text" name="variable"/>
<input type="submit" value="Enviar"/>




</form>

<%


try {
	
	String variable = request.getParameter("variable");
	
	

	Class.forName("oracle.jdbc.driver.OracleDriver");

	// 1. Crear conexion

	String url = "jdbc:oracle:thin:@192.168.15.30:1521:xe";
	Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

	// 2. Crear objeto statement

	Statement miStatement = miConexion.createStatement();

	// 3. Ejecutar SQL

	ResultSet miResultSet = miStatement
			.executeQuery("SELECT sueldo from nominas where dni='" + variable + "'");

	// 4. Recorrer el resultSet

	while (miResultSet.next()) {
		%>
		<br><br>
		<c:out value="El sueldo del empleado es: "+miResultSet.getString("sueldo")" [escapeXML=“true|false”] default=“valor”/>
		<% 
		out.println("El sueldo del empleado es: "+miResultSet.getString("sueldo"));
		

	}

} catch (SQLException e) {

	out.println("No ha sido posible la conexi�n.");

	e.printStackTrace();

}

%>
<br><br>
<a href="index.jsp"><input type="button" value="Volver" style="height: 28px; width: 70px;"/></a>
</body>
</html>
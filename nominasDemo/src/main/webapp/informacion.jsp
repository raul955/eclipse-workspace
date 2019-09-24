<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.Scanner" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Información de los empleados:</h2>
<h4>Nombre | DNI | Sexo | Categoría | Anyos</h4>

<sql:setDataSource var="snapshot" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@192.168.15.30:1521:xe" user="empleado" password="empleado"/>
<sql:query dataSource="${snapshot}" var="result">
select * from empleados
</sql:query>

<c:forEach var="empleado" begin="0" items="${result.row}">
       <tr><td>${row.nombre}</td>
        <td>${row.dni}</td>
        <td>${row.sexo}</td>

</c:forEach>

<%-- <%

try {

	Class.forName("oracle.jdbc.driver.OracleDriver");
	//<c:out value="${estudiante.identificacion}"></c:out>
	// 1. Crear conexion

	String url = "jdbc:oracle:thin:@192.168.15.30:1521:xe";
	Connection miConexion = DriverManager.getConnection(url, "empleado", "empleado");

	// 2. Crear objeto statement

	Statement miStatement = miConexion.createStatement();

	// 3. Ejecutar SQL

	ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM empleados");

	// 4. Recorrer el resultSet

	while (miResultSet.next()) {

		out.print(miResultSet.getString("NOMBRE") + " " + miResultSet.getString("DNI") + " "
				+ miResultSet.getString("SEXO") + " " + miResultSet.getString("CATEGORIA") + " "
				+ miResultSet.getString("ANYOS"));
		 
%>
	
	
	
	<br><br>

<% 
 	}

} catch (SQLException e) {

	out.println("No ha sido posible la conexi�n.");

	e.printStackTrace();

} 

%> --%>



<a href="index.jsp"><input type="button" value="Volver" style="height: 28px; width: 500px;"/></a>

</body>
</html>
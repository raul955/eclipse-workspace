<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Laboral.*"%>
<%@ page import="java.io.BufferedWriter"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.FileOutputStream"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.io.FileWriter"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.util.Scanner"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%

		Connection co = Conexion.getConnection();
		Statement st = co.createStatement();

		String sql = "SELECT * FROM EMPLEADOS";
		
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			out.println("DNI: " + rs.getString(1));
			out.println("Nombre: " + rs.getString(2));
			out.println("Sexo: " + rs.getString(3));
			out.println("Categoría: " + rs.getInt(4));
			out.println("Anyos trabajados: " + rs.getInt(5));
			
			String sql2 = "SELECT SUELDO FROM NOMINAS WHERE DNI = '" + rs.getString(1) + "'";
			
			ResultSet rs2 = st.executeQuery(sql2);
			
				while(rs2.next()) {
					out.println("Sueldo: " + rs2.getInt(1));
				}
			
			out.println("***************************************");
		}

	
	
	%>
</body>
</html>
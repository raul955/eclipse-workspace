package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Ya me he dado cuenta de que con la opción uno del filtrado multiple puedo hacer
 * el filtrado individual, pero esto lo conseguí realizar después tras comemerme mucho la cabeza
 * y ya lo dejo así, almenos me ha servido para practicar.
 */

public class Ejercicio2 {

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);

		int num;
		int num2;
		String car;
		String car2;
		String car3;
		String gordo;
		String gordoDatos;

		do {

			System.out.println("Seleccione una operacion");
			System.out.println("1-. Filtrado Individual");
			System.out.println("2-. Filtrado Múltiple");
			System.out.println("Cualquier otro para salir");
			num = s.nextInt();

			if (num == 1) {

				System.out.println("Seleccione un método de filtrado: ");
				System.out.println("1-. Matrícula");
				System.out.println("2-. Marca");
				System.out.println("3-. Modelo");
				System.out.println("4-. Color");
				System.out.println("5-. Anyo");
				System.out.println("6-. Precio");
				num2 = s.nextInt();

				if (num2 == 1) {

					try {

						int existe;

						System.out.println("Ecriba la matrícula a consultar(MAYÚSCULA):");
						car = sc.nextLine();

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where matricula = '" + car + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement
									.executeQuery("SELECT * FROM coches where matricula = '" + car + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (num2 == 2) {

					try {

						int existe;

						System.out.println("Ecriba la marca a consultar(MAYÚSCULA):");
						car2 = sc.nextLine();

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where marca = '" + car2 + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement
									.executeQuery("SELECT * FROM coches where marca = '" + car2 + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (num2 == 3) {

					try {

						int existe;

						System.out.println("Ecriba el modelo a consultar(MAYÚSCULA):");
						car = sc.nextLine();

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where modelo = '" + car + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement
									.executeQuery("SELECT * FROM coches where modelo = '" + car + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (num2 == 4) {

					try {

						int existe;

						System.out.println("Ecriba el color a consultar(MAYÚSCULA):");
						car3 = sc.nextLine();

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where color = '" + car3 + "'");

						System.out.println(existe);

						if (existe > 0) {

							ResultSet miResultSet = miStatement
									.executeQuery("SELECT * FROM coches where color = '" + car3 + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (num2 == 5) {

					try {

						int existe;

						System.out.println("Ecriba el año a consultar:");
						num = s.nextInt();

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where anyo = " + num + "");

						if (existe > 0) {

							ResultSet miResultSet = miStatement
									.executeQuery("SELECT * FROM coches where anyo = " + num + "");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (num2 == 6) {

					try {

						int existe;

						System.out.println("Ecriba el precio a consultar:");
						num = s.nextInt();

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where precio = " + num + "");

						if (existe > 0) {

							ResultSet miResultSet = miStatement
									.executeQuery("SELECT * FROM coches where precio = " + num + "");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (num2 != 1 && num2 != 2 && num2 != 3 && num2 != 4 && num2 != 5 && num2 != 6) {
					System.out.println("Ha vuelto atrás.");
					System.out.println(" ");
				}

			} else if (num == 2) {

				System.out.println(
						"Introduzca, separados por ',' los métodos de filtrado (matricula,marca,modelo,color,anyo,precio)");
				gordo = sc.nextLine();

				String[] arrayGordo = gordo.split(",");
				int longitud = arrayGordo.length;

				System.out.println(
						"Introduzca, separados por ',' todos los datos a consultar en el orden anteriormente introducido y en MAYÚSCULA.");
				gordoDatos = sc.nextLine();

				String[] arrayDatosGordo = gordoDatos.split(",");
				int longitudDatos = arrayDatosGordo.length;

				if (longitud == 1 && longitudDatos == 1) {

					try {

						int existe;

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate(
								"SELECT * FROM coches where " + arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement.executeQuery(
									"SELECT * FROM coches where " + arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (longitud == 2 && longitudDatos == 2) {

					try {

						int existe;

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where " + arrayGordo[0] + " = '"
								+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1] + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement.executeQuery(
									"SELECT * FROM coches where " + arrayGordo[0] + " = '" + arrayDatosGordo[0]
											+ "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1] + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (longitud == 3 && longitudDatos == 3) {

					try {

						int existe;

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where " + arrayGordo[0] + " = '"
								+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1] + "' and "
								+ arrayGordo[2] + " = '" + arrayDatosGordo[2] + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement.executeQuery(
									"SELECT * FROM coches where " + arrayGordo[0] + " = '" + arrayDatosGordo[0]
											+ "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1] + "' and "
											+ arrayGordo[2] + " = '" + arrayDatosGordo[2] + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (longitud == 4 && longitudDatos == 4) {

					try {

						int existe;

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where " + arrayGordo[0] + " = '"
								+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1] + "' and "
								+ arrayGordo[2] + " = '" + arrayDatosGordo[2] + "' and " + arrayGordo[3] + " = '"
								+ arrayDatosGordo[3] + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM coches where "
									+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '"
									+ arrayDatosGordo[1] + "' and " + arrayGordo[2] + " = '" + arrayDatosGordo[2]
									+ "' and " + arrayGordo[3] + " = '" + arrayDatosGordo[3] + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (longitud == 5 && longitudDatos == 5) {

					try {

						int existe;

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where " + arrayGordo[0] + " = '"
								+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1] + "' and "
								+ arrayGordo[2] + " = '" + arrayDatosGordo[2] + "' and " + arrayGordo[3] + " = '"
								+ arrayDatosGordo[3] + "' and " + arrayGordo[4] + " = '" + arrayDatosGordo[4] + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM coches where "
									+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '"
									+ arrayDatosGordo[1] + "' and " + arrayGordo[2] + " = '" + arrayDatosGordo[2]
									+ "' and " + arrayGordo[3] + " = '" + arrayDatosGordo[3] + "' and " + arrayGordo[4]
									+ " = '" + arrayDatosGordo[4] + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else if (longitud == 6 && longitudDatos == 6) {

					try {

						int existe;

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

						Statement miStatement = miConexion.createStatement();

						existe = miStatement.executeUpdate("SELECT * FROM coches where " + arrayGordo[0] + " = '"
								+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1] + "' and "
								+ arrayGordo[2] + " = '" + arrayDatosGordo[2] + "' and " + arrayGordo[3] + " = '"
								+ arrayDatosGordo[3] + "' and " + arrayGordo[4] + " = '" + arrayDatosGordo[4] + "' and "
								+ arrayGordo[5] + " = '" + arrayDatosGordo[5] + "'");

						if (existe > 0) {

							ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM coches where "
									+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '"
									+ arrayDatosGordo[1] + "' and " + arrayGordo[2] + " = '" + arrayDatosGordo[2]
									+ "' and " + arrayGordo[3] + " = '" + arrayDatosGordo[3] + "' and " + arrayGordo[4]
									+ " = '" + arrayDatosGordo[4] + "' and " + arrayGordo[5] + " = '"
									+ arrayDatosGordo[5] + "'");

							while (miResultSet.next()) {

								System.out.println(miResultSet.getString("matricula") + " "
										+ miResultSet.getString("marca") + " " + miResultSet.getString("modelo") + " "
										+ miResultSet.getString("color") + " " + miResultSet.getString("anyo") + " "
										+ miResultSet.getString("precio"));

							}

							System.out.println(" ");

						} else {
							System.out.println("No hay datos");
							System.out.println(" ");
						}

						miConexion.close();
						miStatement.close();

					} catch (Exception e) {

						System.out.println("No ha sido posible la conexión.");

					}

				} else {
					System.out.println("ERR0R- Introduzca los datos correctamente.");
				}

			}

		} while (num == 1 || num == 2);

	}

}

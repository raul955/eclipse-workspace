package Ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {

	// Engloba los ejercicios 3,4 y 5.

	public static void main(String args[]) throws IOException, ClassNotFoundException {

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
			System.out.println("3-. Modificar o Borrar Datos");
			System.out.println("4-. Crear Backup Fichero");
			System.out.println("5-. Crear Backup BBDD");
			System.out.println("6-. Insertar Nuevo Vehículo");
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

			} else if (num == 3) {

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

							String si;
							System.out.println("¿Desea borrar el vehículo (si/no) ?");
							si = sc.nextLine();

							if (si.equals("si")) {
								String borrado = "delete from coches where " + arrayGordo[0] + " = '"
										+ arrayDatosGordo[0] + "'";
								miStatement.executeUpdate(borrado);
							} else if (si.contentEquals("no")) {
								System.out.println("¿Desea modificar el vehículo?");
								si = sc.nextLine();
								if (si.equals("si")) {
									String valor;
									String cambio;
									System.out.println(
											"Introduzca el campo a modificar(matrícula,marca,modelo,color,año,precio):");
									valor = sc.nextLine();
									System.out.println("Introduzca el nuevo valor:");
									cambio = sc.nextLine();

									String update = "UPDATE coches set " + valor + " = '" + cambio + "' where "
											+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'";
									miStatement.executeUpdate(update);

								}
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

							String si;
							System.out.println("¿Desea borrar el vehículo (si/no) ?");
							si = sc.nextLine();

							if (si.equals("si")) {
								String borrado = "delete FROM coches where " + arrayGordo[0] + " = '"
										+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1]
										+ "'";
								miStatement.executeUpdate(borrado);
							} else if (si.contentEquals("no")) {
								System.out.println("¿Desea modificar el vehículo?");
								si = sc.nextLine();
								if (si.equals("si")) {
									String valor;
									String cambio;
									System.out.println(
											"Introduzca el campo a modificar(matrícula,marca,modelo,color,año,precio):");
									valor = sc.nextLine();
									System.out.println("Introduzca el nuevo valor:");
									cambio = sc.nextLine();

									String update = "UPDATE coches set " + valor + " = '" + cambio + "' where "
											+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'";
									miStatement.executeUpdate(update);

								}
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

							String si;
							System.out.println("¿Desea borrar el vehículo (si/no) ?");
							si = sc.nextLine();

							if (si.equals("si")) {
								String borrado = "delete FROM coches where " + arrayGordo[0] + " = '"
										+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1]
										+ "' and " + arrayGordo[2] + " = '" + arrayDatosGordo[2] + "'";
								miStatement.executeUpdate(borrado);
							} else if (si.contentEquals("no")) {
								System.out.println("¿Desea modificar el vehículo?");
								si = sc.nextLine();
								if (si.equals("si")) {
									String valor;
									String cambio;
									System.out.println(
											"Introduzca el campo a modificar(matrícula,marca,modelo,color,año,precio):");
									valor = sc.nextLine();
									System.out.println("Introduzca el nuevo valor:");
									cambio = sc.nextLine();

									String update = "UPDATE coches set " + valor + " = '" + cambio + "' where "
											+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'";
									miStatement.executeUpdate(update);

								}
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

							String si;
							System.out.println("¿Desea borrar el vehículo (si/no) ?");
							si = sc.nextLine();

							if (si.equals("si")) {
								String borrado = "delete FROM coches where " + arrayGordo[0] + " = '"
										+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1]
										+ "' and " + arrayGordo[2] + " = '" + arrayDatosGordo[2] + "' and "
										+ arrayGordo[3] + " = '" + arrayDatosGordo[3] + "'";
								miStatement.executeUpdate(borrado);

							} else if (si.contentEquals("no")) {
								System.out.println("¿Desea modificar el vehículo?");
								si = sc.nextLine();
								if (si.equals("si")) {
									String valor;
									String cambio;
									System.out.println(
											"Introduzca el campo a modificar(matrícula,marca,modelo,color,año,precio):");
									valor = sc.nextLine();
									System.out.println("Introduzca el nuevo valor:");
									cambio = sc.nextLine();

									String update = "UPDATE coches set " + valor + " = '" + cambio + "' where "
											+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'";
									miStatement.executeUpdate(update);

								}
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

							String si;
							System.out.println("¿Desea borrar el vehículo (si/no) ?");
							si = sc.nextLine();

							if (si.equals("si")) {
								String borrado = "delete FROM coches where " + arrayGordo[0] + " = '"
										+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1]
										+ "' and " + arrayGordo[2] + " = '" + arrayDatosGordo[2] + "' and "
										+ arrayGordo[3] + " = '" + arrayDatosGordo[3] + "' and " + arrayGordo[4]
										+ " = '" + arrayDatosGordo[4] + "'";
								miStatement.executeUpdate(borrado);

							} else if (si.contentEquals("no")) {
								System.out.println("¿Desea modificar el vehículo?");
								si = sc.nextLine();
								if (si.equals("si")) {
									String valor;
									String cambio;
									System.out.println(
											"Introduzca el campo a modificar(matrícula,marca,modelo,color,año,precio):");
									valor = sc.nextLine();
									System.out.println("Introduzca el nuevo valor:");
									cambio = sc.nextLine();

									String update = "UPDATE coches set " + valor + " = '" + cambio + "' where "
											+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'";
									miStatement.executeUpdate(update);

								}
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

							String si;
							System.out.println("¿Desea borrar el vehículo (si/no) ?");
							si = sc.nextLine();

							if (si.equals("si")) {
								String borrado = "delete FROM coches where " + arrayGordo[0] + " = '"
										+ arrayDatosGordo[0] + "' and " + arrayGordo[1] + " = '" + arrayDatosGordo[1]
										+ "' and " + arrayGordo[2] + " = '" + arrayDatosGordo[2] + "' and "
										+ arrayGordo[3] + " = '" + arrayDatosGordo[3] + "' and " + arrayGordo[4]
										+ " = '" + arrayDatosGordo[4] + "' and " + arrayGordo[5] + " = '"
										+ arrayDatosGordo[5] + "'";
								miStatement.executeUpdate(borrado);

							} else if (si.contentEquals("no")) {
								System.out.println("¿Desea modificar el vehículo?");
								si = sc.nextLine();
								if (si.equals("si")) {
									String valor;
									String cambio;
									System.out.println(
											"Introduzca el campo a modificar(matrícula,marca,modelo,color,año,precio):");
									valor = sc.nextLine();
									System.out.println("Introduzca el nuevo valor:");
									cambio = sc.nextLine();

									String update = "UPDATE coches set " + valor + " = '" + cambio + "' where "
											+ arrayGordo[0] + " = '" + arrayDatosGordo[0] + "'";
									miStatement.executeUpdate(update);

								}
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

			} else if (num == 4) {

				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

					Statement miStatement = miConexion.createStatement();
					ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM coches");

					while (miResultSet.next()) {

						String contenido = (miResultSet.getString("matricula") + " " + miResultSet.getString("marca")
								+ " " + miResultSet.getString("modelo") + " " + miResultSet.getString("color") + " "
								+ miResultSet.getString("anyo") + " " + miResultSet.getString("precio"));

						try {
							FileWriter escritura = new FileWriter("backup.txt", true);

							escritura.write(contenido);
							escritura.append("\n");

							escritura.close();

						} catch (IOException e) {

							e.printStackTrace();

						}
					}

				} catch (Exception e) {

					System.out.println("No ha sido posible la conexión.");

					e.printStackTrace();

				}

			} else if (num == 5) {

				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

					Statement miStatement = miConexion.createStatement();
					ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM coches");

					while (miResultSet.next()) {

						String contenido = (miResultSet.getString("matricula") + " " + miResultSet.getString("marca")
								+ " " + miResultSet.getString("modelo") + " " + miResultSet.getString("color") + " "
								+ miResultSet.getString("anyo") + " " + miResultSet.getString("precio"));

						try {
							FileWriter escritura = new FileWriter("backup2.txt", true);

							escritura.write(contenido);
							escritura.append("\n");

							escritura.close();

						} catch (IOException e) {

							e.printStackTrace();

						}
					}

				} catch (Exception e) {

					System.out.println("No ha sido posible la conexión.");

				}

				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "Concesionario_backup",
							"Concesionario_backup");

					Statement miStatement = miConexion.createStatement();

					String instruccionSQL = "CREATE TABLE coches (matricula varchar(8) PRIMARY KEY NOT NULL,marca  Varchar(40) NOT NULL,modelo Varchar(40) NOT NULL, color Varchar(40) NOT NULL,anyo number(7) NOT NULL,precio number(7) NOT NULL)";
					miStatement.executeUpdate(instruccionSQL);

					miConexion.close();
					miStatement.close();

				} catch (SQLException e) {

					System.out.println("ERR0R: Don't Worry Be Happy. (La tabla ya existe)");

				}

				try {

					FileReader entrada = new FileReader("backup2.txt");
					BufferedReader mibuffer = new BufferedReader(entrada);

					String linea = "";

					linea = mibuffer.readLine();

					while (linea != null) {

						String[] array = linea.split(" ");

						System.out.println(Arrays.toString(array));

						Class.forName("oracle.jdbc.driver.OracleDriver");

						String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
						Connection miConexion = DriverManager.getConnection(url, "Concesionario_backup",
								"Concesionario_backup");

						Statement miStatement = miConexion.createStatement();

						String instruccionSQL = "INSERT INTO coches (matricula,marca,modelo,color,anyo,precio) VALUES('"
								+ array[0] + "','" + array[1] + "','" + array[2] + "','" + array[3] + "'," + array[4]
								+ "," + array[5] + ")";
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

			} else if (num == 6) {

				String matricula;
				String marca;
				String modelo;
				String color;
				int anyo;
				int precio;

				System.out.println("Introduzca matricula: ");
				matricula = sc.nextLine();
				System.out.println("Introduzca marca: ");
				marca = sc.nextLine();
				System.out.println("Introduzca modelo: ");
				modelo = sc.nextLine();
				System.out.println("Introduzca color: ");
				color = sc.nextLine();
				System.out.println("Introduzca anyo: ");
				anyo = s.nextInt();
				System.out.println("Introduzca precio: ");
				precio = s.nextInt();

				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");

					String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
					Connection miConexion = DriverManager.getConnection(url, "concesionario", "concesionario");

					Statement miStatement = miConexion.createStatement();

					String instruccionSQL = "INSERT INTO coches (matricula,marca,modelo,color,anyo,precio) VALUES('"
							+ matricula + "','" + marca + "','" + modelo + "','" + color + "'," + anyo + "," + precio
							+ ")";
					miStatement.executeUpdate(instruccionSQL);

					miConexion.close();
					miStatement.close();

				} catch (SQLException e) {

					System.out.println(

							"ERR0R - Carga de elementos fallida, probablemente PRIMARY KEY violada");

				}

			}

		} while (num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6);

	}

}

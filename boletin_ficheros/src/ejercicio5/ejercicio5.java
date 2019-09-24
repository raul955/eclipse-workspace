package ejercicio5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//preguntar por el conteo de posicion
public class ejercicio5 {

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		String fichero;
		String cadena;
		int contadorFila = 0;
		int contadorColumna = 0;
		int sub = 0;
		int cont = 0;
		int cont2 = 0;

		System.out.println("Introduzca el nombre de un fichero existente.");
		fichero = s.nextLine();
		fichero = fichero + ".txt";

		System.out.println("Introduzca una cadena a buscar");
		cadena = s.nextLine();

		try {

			FileReader entrada = new FileReader(fichero);
			BufferedReader mibuffer = new BufferedReader(entrada);

			FileReader entrada2 = new FileReader(fichero);
			BufferedReader mibuffer2 = new BufferedReader(entrada2);

			String linea = "";

			linea = mibuffer.readLine();

			while (linea != null) {

				contadorFila++;

				if (linea.contains(cadena)) {
					System.out.println("La cadena aparece en la fila " + contadorFila);
				}

				linea = mibuffer.readLine();
			}

			entrada.close();
			mibuffer.close();

			linea = mibuffer2.readLine();

			while (linea != null) {

				for (int i = 0; i < linea.length(); i++) {

					contadorColumna++;
					if (linea.charAt(i) == (cadena.charAt(sub)) && sub <= cadena.length()) {
						sub++;

						if (sub == cadena.length()) {
							contadorColumna = contadorColumna - cadena.length();
							System.out.println("La cadena aparece en la posición " + (contadorColumna + 1));
							sub = 0;
						}

					} else {
						sub = 0;
					}

				}

				contadorColumna = 0;

				linea = mibuffer2.readLine();
			}

			entrada2.close();
			mibuffer2.close();

		} catch (IOException e) {

			System.out.println("Archivo no encontrado.");
		}

	}

}

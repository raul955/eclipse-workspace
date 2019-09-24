package Ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		String fichero;
		char a = '/';
		char e = '*';

		System.out.println("Introduzca el nombre de un fichero existente.");
		fichero = s.nextLine();
		fichero = fichero + ".txt";

		File ficheroNew = new File(fichero + "_sin_comentarios.txt");

		try {

			FileReader entrada = new FileReader(fichero);
			BufferedReader mibuffer = new BufferedReader(entrada);

			FileWriter escritura = new FileWriter(ficheroNew + ".txt", false);

			String linea = "";

			linea = mibuffer.readLine();

			/*
			 * Recorremos la cadena buscando dos posiciones seguidas en las que se encuentren los caracteres '\'
			 * al encontrarlo al principio de la linea, esta se iguala a nada y se copia en el fichero
			 * si no est� al principio de una linea, los caract�res se van escribiendo uno por uno
			 * hasta que se topan de nuevo con \\, cuando se iguala la linea a nada y se copia la misma
			 */
			
			while (linea != null) {


				for (int i = 0; i < linea.length(); i++) {
					if (linea.charAt(i) == a && linea.charAt(i + 1) == a || linea.charAt(i) == a && linea.charAt(i + 1) == e || linea.charAt(i)==e) {
						linea=" ";
						escritura.write(linea);
						//escritura.append("\n");
						break;
					}else {
						escritura.write(linea.charAt(i));
					}
				}

				escritura.append("\n");
				linea = mibuffer.readLine();
			}


			escritura.close();
			entrada.close();
			mibuffer.close();

		} catch (IOException d) {

			System.out.println("Archivo no encontrado.");
		}

	}

}

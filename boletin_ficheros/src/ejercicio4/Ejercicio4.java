package ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		String fichero;

		System.out.println("Introduzca el nombre de un fichero existente.");
		fichero = s.nextLine();
		fichero = fichero + ".txt";

		try {

			FileReader entrada = new FileReader(fichero);

			BufferedReader mibuffer = new BufferedReader(entrada);

			String linea = "";

			linea = mibuffer.readLine();

			while (linea != null) {
				
				linea=linea.replace(" ", "");
				linea=linea.replace(".", "");
				linea=linea.replace(",", "");
				linea=linea.replace(";", "");
				linea=linea.replace("-", "");
				
				System.out.println(linea);
	
				linea = mibuffer.readLine();
			}
			
			entrada.close();
			mibuffer.close();
			
			

		} catch (IOException e) {

			System.out.println("Archivo no encontrado.");
		}

	}

}

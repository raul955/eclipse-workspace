package leyendo;

import java.io.FileReader;
import java.io.IOException;

public class Acceso_Fichero {

	public static void main(String args[]) {

		Leer_Fichero accediendo = new Leer_Fichero();

		accediendo.lee();

	}
}

class Leer_Fichero {

	public void lee() {

		try {

			FileReader entrada = new FileReader("escritura.txt");

			int c = entrada.read();

			while (c != -1) {

				char letra = (char) c;

				System.out.print(letra);

				c = entrada.read();

			}

			entrada.close();
			
		} catch (IOException e) {

			System.out.println("Archivo no encontrado.");
		}

	}

}
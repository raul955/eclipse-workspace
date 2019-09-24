package leyendo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroBuffer {

	public static void main(String args[]) {

		Leer_FicheroB accediendo = new Leer_FicheroB();

		accediendo.lee();

	}
}

class Leer_FicheroB {

	public void lee() {

		try {

			FileReader entrada = new FileReader("escritura.txt");
			
			BufferedReader mibuffer= new BufferedReader(entrada);
			
			String linea="";

			while (linea!=null) {

				linea=mibuffer.readLine();

				
				if(linea!=null){
				System.out.println(linea);
				}				

			}

			entrada.close();
			
		} catch (IOException e) {

			System.out.println("Archivo no encontrado.");
		}

	}

}

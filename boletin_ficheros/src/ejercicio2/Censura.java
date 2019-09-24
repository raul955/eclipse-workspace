package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Censura {

	public static void main(String args[]) {

		aplicaCensura();
	}

	public static void aplicaCensura() {

		try {

			String resultado = "";

			FileReader entrada = new FileReader("ficheroEntrada.txt");
			FileReader censura = new FileReader("ficheroCensura.txt");

			BufferedReader mibuffer = new BufferedReader(entrada);
			BufferedReader mibuffer2 = new BufferedReader(censura);

			File ficheroNew = new File("ficheroSalida.txt");
			FileWriter escritura = new FileWriter("ficheroSalida.txt", false);

			String linea = "";

			String cen = mibuffer2.readLine();

			while (cen != null) {

				String[] array = cen.split(" ");
				System.out.println(Arrays.toString(array));

				linea = mibuffer.readLine();
				while (linea != null) {

					if (linea.contains(array[0])) {
						String[] linea2 = linea.split(" ");
						for (int i = 0; i < linea2.length; i++) {
							if (linea2[i].equals(array[0])) {
								linea2[i] = array[1];
							}
						}

						for (String string : linea2) {
							resultado = resultado + string + " ";
						}
					}
					System.out.println(resultado);
					escritura.write(resultado);
					escritura.append("\n");
					resultado = "";
					break;
				}

				cen = mibuffer2.readLine();
			}

			escritura.close();
			mibuffer.close();
			mibuffer2.close();
			entrada.close();
			censura.close();

		} catch (IOException e) {

			System.out.println("Archivo no encontrado.");

		}

	}

}
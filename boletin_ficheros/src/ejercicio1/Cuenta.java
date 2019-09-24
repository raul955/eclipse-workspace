package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Cuenta {
	
	public static void main(String args[]) {
		
		String fichero="cuenta.txt";
		cuentaPalabras(fichero);
		
	}
	
	public static void cuentaPalabras(String fichero) {

			String linea="";
			int contador=0;
			
			
			try {
				
				FileReader entrada = new FileReader("cuenta.txt");			
				BufferedReader mibuffer = new BufferedReader(entrada);
		
				linea=mibuffer.readLine();
				
				while(linea!=null) {
					
					StringTokenizer st = new StringTokenizer(linea);
					st.countTokens();
					contador=contador+st.countTokens();
					
					linea=mibuffer.readLine();
				}
				
				System.out.println("tenemos un total de: "+contador+" palabras");
				
				entrada.close();
				
			} catch (IOException e) {

				System.out.println("Archivo no encontrado.");
			}		
	}
}

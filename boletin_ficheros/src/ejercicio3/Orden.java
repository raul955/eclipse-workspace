package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orden {

	public static void main(String args[]) {

		ordenar();
		
	}

	public static void ordenar() {

		List<String>lista=new ArrayList<>();
		
		try {

			FileReader entrada = new FileReader("numeros.txt");			
			BufferedReader mibuffer = new BufferedReader(entrada);
			
			String linea="";
			
			linea=mibuffer.readLine();
			
			while(linea!=null) {
				
				lista.add(linea);
			
				linea = mibuffer.readLine();
			}

			System.out.println(lista.toString()+"Desordenada");
			
			Collections.sort(lista);
			
			System.out.println(lista.toString()+"Ordenada");
			
			FileWriter escritura =  new FileWriter("numeros.txt",false);
			
			for(int i=0; i<lista.size();i++) {
				escritura.write(lista.get(i));
				escritura.append("\n");
			}
						
			escritura.close();
			mibuffer.close();
			
		} catch (IOException e) {
			System.out.println("ERR0R");
		}

	}
}

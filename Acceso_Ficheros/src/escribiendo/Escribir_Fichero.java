package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {

	public static void main(String args[]){
		
		
		Escribiendo escrituraac = new Escribiendo();
		
		escrituraac.escribir();
		
	}
	
	static class Escribiendo{
		
		public void escribir(){
			
			String frase = "Escribiendo en un fichero";
			
			try {
				FileWriter escritura =  new FileWriter("escritura.txt",true);
				
				escritura.write(frase);
				
				escritura.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}

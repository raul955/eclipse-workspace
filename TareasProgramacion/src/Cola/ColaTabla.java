package Cola;

import java.util.Arrays;

public class ColaTabla implements Cola{

	Integer[] tabla;
	
	public void encolar() {
		tabla= new Integer[10];
		for(int i=tabla.length-1;i>=0;i--){
			System.out.println(tabla[i]=(int) (Math.random()*100));
			
		}
		System.out.println(Arrays.toString(tabla));
	}
	public void desencolar() {
		tabla= new Integer[10];
		for(int i=tabla.length-1;i>=0;i--){
			System.out.println(tabla[i]=0);
		}
		System.out.println(Arrays.toString(tabla));
	}
	
	
}

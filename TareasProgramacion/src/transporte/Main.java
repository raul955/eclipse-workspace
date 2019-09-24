package transporte;

public class Main {

	public static void main(String args[]){
		
		Unidades u = new Unidades(5);
		Caja j = new Caja(2, 3, 4, u);
		
		System.out.println(j.getVolume(2, 3, 4)/10000+"m^3");
		System.out.println(j.toString());
		
	}
	
}

package Cola;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]){
	
	ColaTabla ct = new ColaTabla();
	ColaLista cl = new ColaLista();
	Integer[] tabla = new Integer[10];
	List<Integer>lista= new ArrayList<>();
	
	ct.encolar();
	ct.desencolar();
	
	cl.encolar();
	cl.desencolar();
	}
}

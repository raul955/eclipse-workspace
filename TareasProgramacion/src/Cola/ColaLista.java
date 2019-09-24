package Cola;

import java.util.ArrayList;
import java.util.List;

public class ColaLista implements Cola{
	
	List<Integer>lista;

	@Override
	public void encolar() {
		lista= new ArrayList<>();
		for(int i=0;i<10;i++){
			lista.add((int) (Math.random()*100));
		}
		System.out.println(lista.toString());
	}

	@Override
	public void desencolar() {
		lista= new ArrayList<>();
		
		lista= new ArrayList<>();
		for(int i=0;i<10;i++){
			lista.add((int) (Math.random()*100));
		}
		
		for(int i=0;i<lista.size();i++){
			lista.remove(i);
		}
		System.out.println(lista.toString());
	}

	
}

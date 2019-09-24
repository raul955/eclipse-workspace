package instrumento;
import java.util.ArrayList;
import java.util.List;

public abstract class Instrumento {

	List<String>notas = new ArrayList<>();
	public enum nota {DO,re, mi,fa,sol,la,si}
	
	public Instrumento(List<String> notas) throws Exception{
		
		if(notas.size()<100){
			this.notas = notas;
		}else{
			throw new Exception();
		}		
	}
	
	public void anadirNotas(String nota){
		
		notas.add(nota);
		
	}
	
	public abstract String interpretar();
	
	
}

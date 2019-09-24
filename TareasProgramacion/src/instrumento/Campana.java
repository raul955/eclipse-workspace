package instrumento;

import java.util.List;

public class Campana extends Instrumento{

	public Campana(List<String> notas) throws Exception {
		super(notas);
		// TODO Auto-generated constructor stub
	}

	public String interpretar() {
		
		return notas.toString();
	}
	
}

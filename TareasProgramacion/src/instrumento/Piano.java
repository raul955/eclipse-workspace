package instrumento;

import java.util.List;

public class Piano extends Instrumento{

	public Piano(List<String> notas) throws Exception {
		super(notas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String interpretar() {
		
		return notas.toString();
	}

	
	
}

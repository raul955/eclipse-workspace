package Laboral;

public class Empleado extends Persona{
	
	private int categoria;
	public int anyos;
	
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos)throws DatosIncorrectosException {
		super(nombre, dni, sexo);
		this.categoria = categoria;
		this.anyos = anyos;
				
		if(categoria<0 && categoria >10) {
			throw new DatosIncorrectosException();
		}else {
			this.categoria = categoria;
		}
		
		if (anyos<0) {
			throw new DatosIncorrectosException();
		}else {
			this.anyos = anyos;
		}
		
	}
	
	public Empleado(String nombre, String dni, char sexo) throws DatosIncorrectosException {
		super(nombre, dni, sexo);
		this.categoria = 1;
		this.anyos = 0;
		
		
	}

	/**
	 * @return the categoria
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 * @throws DatosIncorrectosException 
	 */
	public void setCategoria(int categoria) throws DatosIncorrectosException {
		this.categoria = categoria;
		
		if(categoria<0 && categoria >10) {
			throw new DatosIncorrectosException();
		}else {
			this.categoria = categoria;
		}
		
	}


	public void incranyos() {
		anyos++;
	}

	public String imprime() {
		String datosempleado = super.imprime()+"categoria:"+categoria+" años:" +anyos+" ";

		return datosempleado;		
	}

	
	
	

}



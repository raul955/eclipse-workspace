package Laboral;

public class Empleado extends Persona{

	private int categoria;
	int anyos;
	
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosIncorrectosException {
		super(nombre, dni, sexo);
		this.categoria = categoria;
		this.anyos = anyos;
		
		if(anyos < 0) {//Ponemos una condicion para que los anyos sean positivos o si no me salga la excepcion
			throw new DatosIncorrectosException("ANYOS NO INTRODUCIDOS CORRECTAMENTE"); 
		}else {
			this.anyos = anyos;
		}
	}

	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);
		this.categoria = 1;
		this.anyos = 0;
		
	}
	
	public void setCategoria(int categoria) throws DatosIncorrectosException {
		//Ponemos una condicion que solo coja la categoria si esta entre 0 y 10, o si no me salga la excepcion
		if(categoria > 0 && categoria < 10) {
			this.categoria = categoria;
		}else {
			throw new DatosIncorrectosException("CATEGORIA INCORRECTA");
		}
		
	}

	public int getCategoria() {
		return categoria;
	}
	
	public void incrAnyo() {
		
		anyos++;
		
	}

	@Override
	public String imprime() {
		return "Empleado [categoria=" + categoria + ", anyos=" + anyos + ", nombre=" + nombre + ", dni=" + dni
				+ ", sexo=" + sexo + "]";
	}
	
	
	
	
	
	
	
}

package Cliente;

public class Cliente implements Comparable{

	   String dni;
	   String nombre;
	   int edad;
	   int saldo;

	   public Cliente(String dni, String nombre, int edad, int saldo) {
		      this.dni = dni;
		      this.nombre = nombre;
		      this.edad = edad;
		      this.saldo = saldo;
	   }

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object other) {
		
		return dni.compareTo(((Cliente) other).dni);
	}
	   
	   
	   
	   
}

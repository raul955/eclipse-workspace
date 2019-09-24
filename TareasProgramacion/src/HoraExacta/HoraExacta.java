package HoraExacta;

public class HoraExacta {
	protected int hora, minutos, segundos;

	public HoraExacta(int hora, int minutos, int segundos) {

		this.hora = 0;
		this.minutos = 0;
		this.segundos = 0;
		setHora(hora);
		setMinutos(minutos);
		setSegundos(segundos);
	}

	public void inc() {
		segundos++;
		if (segundos > 59 && segundos <= 60) {
			segundos = 0;
			minutos++;
			if (minutos > 59 && hora <= 60) {
				minutos = 0;
				hora++;
				if (hora > 23 && hora <= 24) {
					hora = 0;
				}
			}
		}
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public String toString() {
		String result;
		if (hora < 12) {
			result = hora + ":" + minutos + ":" + segundos + " am";
			return result;
		} else if (hora == 12) {
			result = 12 + ":" + minutos + ":" + segundos + " pm";
			return result;
		} else {
			result = (hora - 12) + ":" + minutos + ":" + segundos + " pm";
			return result;
		}

	}

	public int getHora() {
		return hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}

}
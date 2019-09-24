package HoraExacta;

public class Main {

	static public void main(String args[]) {
		HoraExacta r = new HoraExacta(15, 40, 37);
		if (r.getHora() >= 0 && r.getHora() <= 24 && r.getMinutos() >= 0 && r.getMinutos() <= 60 && r.getSegundos() >= 0
				&& r.getSegundos() <= 60) {
			System.out.println(r);
			for (int i = 1; i <= 61; i++) {
				r.inc();
			}
			System.out.println(r);
			r.setHora(21);
			System.out.println(r);
		} else {
			System.out.println("ERROR! Vuelve a introducir los datos");
		}
	}
}
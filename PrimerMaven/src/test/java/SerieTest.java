import static org.junit.Assert.*;

import org.junit.Test;

public class SerieTest {

	@Test
	public void testIsEntregado() {
		
		boolean entregado=false;
		assertFalse(entregado);
	}

	@Test
	public void testCompareTo() {
		Serie s = new Serie("titulo",10,"genero","creador");
		Serie s2 = new Serie("titulo",11,"genero","creador");
		
		assertEquals(-1,s.compareTo(s2)); 
		
		Serie s11 = new Serie("titulo",11,"genero","creador");
		Serie s22 = new Serie("titulo",10,"genero","creador");
		
		assertEquals(1,s11.compareTo(s22)); 
		
		Serie s111 = new Serie("titulo",10,"genero","creador");
		Serie s222 = new Serie("titulo",10,"genero","creador");
		
		assertEquals(0,s111.compareTo(s222)); 
	}

	@Test
	public void testToString() {
		Serie s = new Serie("titulo",10,"genero","creador");
		
		String ej = "Informacion de la Serie: \n" +
                "\tTitulo: "+"titulo"+"\n" +
                "\tNumero de temporadas: "+10+"\n" +
                "\tGenero: "+"genero"+"\n" +
                "\tCreador: "+"creador";
		
		assertEquals(ej,s.toString());
	}

	@Test
	public void testSerieStringIntStringString() {
		Serie s = new Serie("titulo",10,"genero","creador");
	}

}

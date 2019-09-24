package boletinJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class subscripcionTest {

	@Test
	public void testSubscripcion() {
		Subscripcion s = new Subscripcion(10,10);
	}

	@Test
	public void testPrecioPorMes() {
		
		Subscripcion s = new Subscripcion(10,10);
		
		assertEquals(1,s.precioPorMes());

		
	}

	@Test
	public void testCancel() {
		Subscripcion s1 = new Subscripcion(100, 10);
		s1.cancel();
		assertEquals(0,s1.precioPorMes(),0);
		System.out.println("Hola");
	}

}

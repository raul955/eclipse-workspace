package boletinJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperadorTest {

	@Test
	public void testSuma() {
		
		OperadorAritmetico s = new OperadorAritmetico();
		
		assertEquals(2,s.suma(1, 1));
		
	}

	@Test
	public void testDivision() throws Exception {
		
		try {
		OperadorAritmetico s = new OperadorAritmetico();
		
		assertEquals(2,s.division(4, 2));
		
		assertEquals(2,s.division(4, 0));
		}catch(Exception e) {
			System.out.println("sada");
		}
		
	}

}

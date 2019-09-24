package boletinJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilaTest {
	
	@Test
	public void testPush() {
		Pila p = new Pila();
		
		p.push(5);
		assertEquals(1,p.longitud());
		p.push(1);
		assertEquals(1,p.longitud());
		p.push(30);
		assertEquals(1,p.longitud());
		
	}

	@Test
	public void testPop() {
		Pila p = new Pila();
		
		assertEquals(null, p.pop());
		p.push(3);
		assertEquals(3, p.pop(),0);
		p.pop();
		assertEquals(null, p.pop());
		
	}

	@Test
	public void testIsEmpty() {
Pila p = new Pila();
		
		assertEquals(true, p.isEmpty());
		p.push(3);
		assertEquals(false, p.isEmpty());
	}

	@Test
	public void testTop() {
		Pila p = new Pila();
		assertEquals(null, p.top());

	}

}

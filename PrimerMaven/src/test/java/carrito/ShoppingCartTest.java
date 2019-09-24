package carrito;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void testGetBalance() {
		
		ShoppingCart s = new ShoppingCart();
		
		Product p = new Product("papas",11);
		
		s.addItem(p);
		
		assertEquals(11,s.getBalance(),0);
		
	}
 
	@Test
	public void testGetItemCount() throws ProductNotFoundException {
		
		try {
			
		ShoppingCart s = new ShoppingCart();
		assertEquals(0,s.getItemCount()); 
		
		Product p = new Product("papas",11);
		Product ps = new Product("papas",11);
		
		s.addItem(p);
		
		assertEquals(1,s.getItemCount());
		
		s.removeItem(p);
		assertEquals(0,s.getItemCount());
		
		s.removeItem(ps);
		
		s.empty();
		assertEquals(0,s.getItemCount());
		
		}catch(ProductNotFoundException e) {
			System.out.println("adsadsa");
		}
		
	}

}

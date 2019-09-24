package boletinJUnit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class boaTest {

	private String name;
	private int length; // the length of the boa, in feet
	private String favoriteFood;
	private Boa boa; 
	
	public boaTest(String name, int length, String favoriteFood) {
		this.name = name;
		this.length = length;
		this.favoriteFood = favoriteFood;
		this.boa = new Boa(this.name, this.length, this.favoriteFood);
	}
	
	@Parameters
	public static Collection<Object[]> parametros(){
		return Arrays.asList(new Object[][]{
			{"boa", 10,"granola bars" },{"boa", 20,"granola bars"}
		});
	}
	
	@Test
	public void testIsHealthy() {
		
		assertEquals(true, boa.isHealthy());
	}
	
	@Test
	public void testFitsInCage() {
		
		assertEquals(true, boa.fitsInCage(25));
		assertEquals(false, boa.fitsInCage(9));
	}

}

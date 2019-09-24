package boletinJUnit;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class FridgeTest {

	String item;
	
	@Parameters
	public static Iterable<Object[]> ejemplo(){
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] {"carne"});
		obj.add(new Object[] {"madera"});
		obj.add(new Object[] {"plastico"});
		return obj;
		
	}

	
	public FridgeTest(String item) {
		this.item=item;
	}
	
	@Test
	public void testPut() {
		Fridge fri = new Fridge();
		fri.put("papas");
		assertEquals(true,fri.contains("papas"));

	}


	@Test
	public void testTake()throws NoSuchItemException {
		Fridge fri = new Fridge();
		String item="papas";
		fri.put(item);
		assertEquals(true,fri.contains(item));
		fri.take(item);
		try {
			String item3="asd";
			fri.take(item3);
		}catch(NoSuchItemException e) {
			System.out.println("asda");
		}
	}

}

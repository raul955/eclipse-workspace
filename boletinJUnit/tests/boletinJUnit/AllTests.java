package boletinJUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, boaTest.class, FridgeTest.class, OperadorTest.class, PilaTest.class,
		subscripcionTest.class })
public class AllTests {

}

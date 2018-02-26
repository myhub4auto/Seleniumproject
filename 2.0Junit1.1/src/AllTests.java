import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ firstprog01.class, secondprog02.class, thirdprog03.class })
public class AllTests {

	// @Runwith and @SuiteClassess is responsible for execution
	// Test suite is use to execute the multiple classes at a stretch 
	// when we create the suite it self will select the classes 

}

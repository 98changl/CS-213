package project2;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test class for the Date class.
 * @author Liman Chang, Kenneth Christian
 */
public class DateTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCompareTo() {
		Date one = new Date(10, 7, 2020);
		Date two = new Date(10, 8, 2020);
		Date three = new Date(10, 9, 2020);
		
		int result = one.compareTo(one);
		assertEquals(result, 0);
	}
	
	@Test
	public void testToString() {
		Date date = new Date(10, 8, 2020);
		String stringDate = date.toString();
		assertEquals(stringDate, "10/8/2020");
	}
	
	@Test
	public void testIsValid() {
		
	}

}

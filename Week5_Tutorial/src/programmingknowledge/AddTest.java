package programmingknowledge;

import org.junit.Assert;
import org.junit.Test;

public class AddTest {
	
	@Test
	public void test() {
		MyJUnitClass junit = new MyJUnitClass();
		int result = junit.add(100, 200);
		Assert.assertEquals(300, result);
	}

}

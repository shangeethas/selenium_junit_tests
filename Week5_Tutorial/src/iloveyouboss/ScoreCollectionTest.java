package iloveyouboss;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class ScoreCollectionTest {

	@Test
	public void checkArithmeticMeanOfTwoNumbers() {
		ScoreCollection collection = new ScoreCollection();
		collection.add(() -> 5);
		collection.add(() -> 7);
		
		int actualResult = collection.arithmeticMean();
		Assert.assertThat(actualResult, equalTo(6));
	}

}

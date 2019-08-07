package iloveyouboss;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
	private Profile profile;
	private BooleanQuestion question;
	private Criteria criteria;
	
	@Before
	public void create() {
		profile = new Profile("Hockey Victoria");
		question = new BooleanQuestion(1, "Got bonuses?");
		criteria = new Criteria();
	}
	
	@Test
	public void matchAnswerFalseWhenMustMatchCriteriaNotMet() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(
				new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
		
		boolean matches = profile.matches(criteria);
		Assert.assertFalse(matches);
	}
	
	@Test
	public void matchAnswerTrueForAnyDontCareCriteria() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(
				new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
		boolean matches = profile.matches(criteria);
		Assert.assertTrue(matches);
	}
}

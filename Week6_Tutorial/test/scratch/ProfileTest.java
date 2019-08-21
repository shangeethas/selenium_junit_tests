package scratch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import iloveyouboss.Answer;
import iloveyouboss.Bool;
import iloveyouboss.BooleanQuestion;
import iloveyouboss.Criteria;
import iloveyouboss.Criterion;
import iloveyouboss.Profile;
import iloveyouboss.Question;
import iloveyouboss.Weight;

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
	public void matches() {
		Profile profile = new Profile("Baseball Victoria");
		Question question = new BooleanQuestion(1, "Is nearby?");
		
		
		//answers false when must-match criteria not met
		profile.add(new Answer(question, Bool.FALSE));
		Criteria criteria = new Criteria();
		criteria.add(
					new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
		Assert.assertFalse(profile.matches(criteria));
		
		//answers true for any don't care criteria
		profile.add(new Answer(question, Bool.FALSE));
		criteria = new Criteria();
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
		Assert.assertTrue(profile.matches(criteria));
	}

	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(
					new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
		Assert.assertFalse(profile.matches(criteria));
		
	}
	
	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
		
		boolean matches = profile.matches(criteria);
		
		Assert.assertTrue(matches);
	}
}

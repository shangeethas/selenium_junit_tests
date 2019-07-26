package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pageObjects.OrderPage;
import pageObjects.OrderResultPage;

public class OrderMessageTest extends AbstractWebDriverTest {

	@Before
	public void testSetUp() {
		onHomePage.navigateToWebApp();
		System.out.println("before in test");
	}
	
	@Test
	public void shouldSendOrderMessage() {
		OrderPage onOrderPage = onHomePage.clickOnOrder();
		OrderResultPage onResultPage = onOrderPage.fillFormWithData().submitForm();
		
		Assert.assertTrue(onResultPage.getConfirmationPage().contains("There was a problem"));
	}
}


package com.creatio.crm.application.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements{
	
/*/* Just for an Example to problem created :	
	
	public void verifyCookiesPageIsDisplayed() {

		(cookiesHeader);
			
	}
	
*/
	
	// We need to call the methods of classes into Test class. that requires, Object creation everytime.
	// Even after, object creation. Methods and Elements do not know in which window browser they are needed.
	// PageFactory.initElements(driver, new ClassName());  ==> This is required to be called at every method
	// In addition to the PageFactory initElements(), we need to pass the WebElement driver as the driver element to get called up at every method.
	
	// To reduce that effort of calling mutliple times driver method WebElement at every method.
	// We come up with the creation of CONSTRUCTOR, and paramterized it with driver.
	
	public CookiesPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	
	
	public void verifyCookiesPopUpisDisplayed() {
		//PageFactory.initElements(driver, new CookiesPageSteps());
		
		waitForElement(cookiesHeader, 30);
			
	}
	
	public void verifyCookiesPopUpContent(String expContent) {
		
		//PageFactory.initElements(driver, new CookiesPageSteps());

		String actContent = getElementText(cookiesContent);
		Assert.assertEquals(actContent, expContent);
		
	}
	
	
	public void verifyCookiesPopUpLogos() {
		
		Assert.assertTrue(isElementDisplayed(creatioLogo));
		
		Assert.assertTrue(isElementDisplayed(cookiebotLogo));
		
	}
	
	
	public void verifyCookiesPopUpSelectionButtons() {
		
		Assert.assertTrue(isElementDisplayed(allowAllBtn));
		
		Assert.assertTrue(isElementDisplayed(allowSelectionBtn));
		
		Assert.assertTrue(isElementDisplayed(denyBtn));
		
		
	}

	
	public void verifyCookiesPopUpSwitchButtons() {
		
		Assert.assertTrue(isElementDisplayed(necessarySwitchtn));
		
		Assert.assertTrue(isElementDisplayed(preferencesSwitchBtn));
		
		Assert.assertTrue(isElementDisplayed(statisticsSwitchBtn));
		
		Assert.assertTrue(isElementDisplayed(marketingSwitchBtn));
		
		
	}
	
	
	public void selectTheCookiesOption(String option) {
		
		if(option.equalsIgnoreCase("AllowAll")) {
			
			click(allowAllBtn);
			
		} else if(option.equalsIgnoreCase("AllowSelection")) {
			
				click(allowSelectionBtn);
				
		} else if(option.equalsIgnoreCase("Deny")) {
			
				click(denyBtn);
		}
		
	}
	
	
	public void verifyCookiesPopUpIsClosed() {
		
		waitForElementDisappeared(cookiesHeader, 30);
		
	}

	
	public void clickOnShowDetailsLink() {
		click(showDetailsLink);
	}

	public void verifyCookiesPopUpExpandedView() {
		waitForElement(cookiePopUpExpandedDetails, 10);
	}
	
	
	

}

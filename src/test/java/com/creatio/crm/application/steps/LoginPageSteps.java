package com.creatio.crm.application.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	
	// We need to call the methods of classes into Test class. that requires, Object creation everytime.
		// Even after, object creation. Methods and Elements do not know in which window browser they are needed.
		// PageFactory.initElements(driver, new ClassName());  ==> This is required to be called at every method
		// In addition to the PageFactory initElements(), we need to pass the WebElement driver as the driver element to get called up at every method.
		
		// To reduce that effort of calling mutliple times driver method WebElement at every method.
		// We come up with the creation of CONSTRUCTOR, and paramterized it with driver.
		
		public LoginPageSteps(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}
		
		
		public void launchApplication() {		
			launchTheApplication();
			Assert.assertEquals(getTitle(), prop.getProperty("title"));
		}
		
		public void verifyLoginHeader() {
			waitForElement(loginPageHeader, 5);
			Assert.assertEquals(getElementText(loginPageHeader), prop.get("loginHeader"));
		}
		
		public void enterCredentials(String username, String password) {
			waitForElement(businessEmailTxtb, 5);
			enterText(businessEmailTxtb, username);
			enterText(passwordTxtb, password);
		}
		
		public void clickOnLoginButton() {
			click(loginBtn);
		}
		
		public void clickOnSignUpLink() {
			waitForElement(signUpLink, 5);
			jsClick(signUpLink);
		}

}

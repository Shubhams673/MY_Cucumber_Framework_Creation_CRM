package com.creatio.crm.application.stepDefinitions;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	
	public CookiesPageSteps cookiesPage = null;
	public HomePageSteps homePage = null;
	public LoginPageSteps loginPage = null;
	public SignUpPageSteps signUpPage = null;


	
	// Both parent and child are BeforeMethod, but Parent is required to run first, so making the child dependednt on parent class setup method
	@Given("Initialize all the page objects")

	public void initialisePageObjects() {
		
		WebDriver driver = new BasePage().getDriver();
		
		cookiesPage = new CookiesPageSteps(driver);
		homePage = new HomePageSteps(driver);
		loginPage = new LoginPageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);

		
	}
	
	
	
	


	@Given("Launch the application")
	public void launch_the_application() {
		
		loginPage.launchApplication();

	}

	@Then("Verify cookies Pop-Up is displayed successfully")
	public void verify_cookies_pop_up_is_displayed_successfully() {
	
		cookiesPage.verifyCookiesPopUpisDisplayed();

	}


	// This format is required for content verification.

	@Then("^Verify Cookies Pop-Up (.*)$")
	public void verifyCookiesPopUpContentData(String content) {

		cookiesPage.verifyCookiesPopUpContent(content);

	}

	@Then("Verify Cookies Pop-Up logos are displayed successfully")
	public void verify_cookies_pop_up_logos_are_displayed_successfully() {

		cookiesPage.verifyCookiesPopUpLogos();

	}

	@Then("Verify Cookies Pop-Up selection buttons are displayed successfully")
	public void verify_cookies_pop_up_selection_buttons_are_displayed_successfully() {

		cookiesPage.verifyCookiesPopUpSelectionButtons();

	}

	@Then("Verify Cookies Pop-Up switch buttons are displayed successfully")
	public void verify_cookies_pop_up_switch_buttons_are_displayed_successfully() {

		cookiesPage.verifyCookiesPopUpSwitchButtons();

	}

	@When("User click on the show details link")
	public void user_click_on_the_show_details_link() {
		
		cookiesPage.clickOnShowDetailsLink();
	
	}

	@Then("Verify Cookies Pop-Up should be displayed in expanded view")
	public void verify_cookies_pop_up_should_be_displayed_in_expanded_view() {
		
		cookiesPage.verifyCookiesPopUpExpandedView();
	
	}

	@When("User click on {string} button")
	public void user_click_on_button(String string) {

		cookiesPage.selectTheCookiesOption(string);
	
	}

	@Then("Cookies Pop-Up should be closed")
	public void cookies_pop_up_should_be_closed() {
	
		cookiesPage.verifyCookiesPopUpIsClosed();

	}


	
	
	
	
	

	@Then("Click on login button")
	public void click_on_login_button() {
	    
		loginPage.clickOnLoginButton();

	}

	
	
	@Then("Login should be successful")
	public void login_should_be_successful() {
		
		homePage.verifyLoginIsSuccessful();		

	}

	
	
	
	
	
	
	@When("User click on the signup link")
	public void user_click_on_the_signup_link() {
	    
		loginPage.clickOnSignUpLink();

	}

	@Then("SignUp page should be launched")
	public void sign_up_page_should_be_launched() {
		
		signUpPage.verifySignUpPageIsLaunched();

	}

	

	@Then("Click on continue button")
	public void click_on_continue_button() {
	   
		signUpPage.clickOnContinueButton();

	}

	@Then("Enter company details")
	public void enter_company_details() throws SQLException {
	    
		signUpPage.enterCompanyDetails();

	}

	@Then("Click on signup button")
	public void click_on_signup_button() {
	    
		signUpPage.clickOnSignUpButton();

	}

	@Then("Signup should be successful")
	public void signup_should_be_successful() {
	    
		homePage.verifySignUpIsSuccessful();

	}
	

	
	
	
	
	// Sign Up User Details have different method
	
		@When("^User enter details as (.*) and (.*)$")
		public void enterSignUpData(String user, String pass) {
			signUpPage.enterUserDetails(user, pass);

		}
		
	// Sign Up User Details have different method
		
		@When("^User enter (.*) and (.*)$")
		public void enterCredential(String user, String pass) {
			loginPage.enterCredentials(user, pass);

		}
	

}

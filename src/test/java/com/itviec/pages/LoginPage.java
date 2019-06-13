/**
 * 
 */
package com.itviec.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.itviec.core.BasePage;


/**
 * @author Quynh Lai
 *
 */
public class LoginPage extends BasePage {
	
	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Find Elements
	
	/** Create account form*/
	@FindBy(xpath = "//a[text()='Create Account']")
	private WebElement create_account_button;
	
	@FindBy(xpath = "//input[@value='Create My Account']")
	private WebElement create_my_account_button;
	
	@FindBy(id = "user_name")
	private WebElement username_textbox;
	
	@FindBy(id = "user_email")
	private WebElement email_sign_up_textbox;
	
	@FindBy(id = "user_password")
	private WebElement password_sign_up_textbox;
	
	@FindBy(xpath = "//div[@class='message']/p[1]")
	private WebElement create_account_message;
	
	/** Sign in form*/
	@FindBy(xpath = "//form[@action='/sign_in']//input[@name='user[email]']")
	private WebElement email_sign_in_textbox;
	
	@FindBy(xpath = "//form[@action='/sign_in']//input[@name='user[password]']")
	private WebElement password_sign_in_textbox;
	
	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement sign_in_button;
	
	@FindBy(xpath = "//button[text()='Sign in now']")
	private WebElement sign_in_now_button;
	
	@FindBy(xpath = "//a[text()='Not now']")
	private WebElement not_now_button;

	// Action
	public void loginWith(String email, String password) {
		sleepInMilis(1000);
		sendkeyToElement(email_sign_in_textbox, email);
		sendkeyToElement(password_sign_in_textbox, password + Keys.ENTER);
	}
	
	public void clickCreateAccount () {
		clickOnElement(create_account_button);
	}
	
	public void createNewAccount (String username, String email, String password) {
		username_textbox.sendKeys(username);
		email_sign_up_textbox.sendKeys(email);
		password_sign_up_textbox.sendKeys(password);
		create_my_account_button.click();
	}
	
	public void verifyCreateAccount () {
		waitForElementToAppear(create_account_message);
		String actualText = create_account_message.getText();
		String expectedText = "Cool, you're almost done!";
		Assert.assertEquals(actualText, expectedText);
	}
	
	public void verifyLogin (String name) {
		HeaderPage headerPage = new HeaderPage(driver);
		Assert.assertEquals(headerPage.getCurrentName(), name);
	}

}

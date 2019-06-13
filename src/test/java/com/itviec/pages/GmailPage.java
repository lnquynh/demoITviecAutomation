/**
 * 
 */
package com.itviec.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.itviec.core.BasePage;

/**
 * @author Quynh Lai
 *
 */
public class GmailPage extends BasePage {
	
	// Constructor
	public GmailPage(WebDriver driver) {
		super(driver);
	}
	
	//Gmail element
	@FindBy(id = "identifierId")
	private WebElement gmail_textbox;
	
	@FindBy(name = "password")
	private WebElement password_textbox;
	
	@FindBy(id = "identifierNext")
	private WebElement identifier_next_button;
	
	@FindBy(id = "passwordNext")
	private WebElement password_next_button;
	
	@FindBy(xpath = "//span[@class='bog']/span[contains(text(),'confirm your email address')]")
	private WebElement confirm_email;
	
	@FindBy(xpath = "//a[text()='Confirm my email']")
	private WebElement confirm_email_button;
	
	@FindBy(xpath = "//div[@id='active-user-confirmed-modal']//p[1]")
	private WebElement confirm_email_message;

	/**
	 * @param gmailAddress
	 * @param gmailPassword
	 */
	public void loginGmail(String gmailAddress, String gmailPassword) {
		sendkeyToElement(gmail_textbox, gmailAddress);
		identifier_next_button.click();
		sendkeyToElement(password_textbox, gmailPassword);
		password_next_button.click();
	}
	
	public void confirmEmail () {
		clickOnElement(confirm_email);
		clickOnElement(confirm_email_button);
	}
	
	public void verifyConfirmEmail () {
		String expectedText = "Yay! Email confirmed.";
		String actualText = waitAndGetTextOfElement(confirm_email_message);
		Assert.assertEquals(actualText, expectedText);
	}

}

/**
 * 
 */
package com.itviec.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.itviec.core.BasePage;

/**
 * @author Quynh Lai
 *
 */
public class HeaderPage extends BasePage {
	
	// Constructor
	public HeaderPage(WebDriver driver) {
		super(driver);
	}
	
	//Find Element
	@FindBy(xpath = "//a[text()='Sign In' and @class='pageMenu__link']")
	private WebElement sign_in_link;
	
	@FindBy(xpath = "//*[@id='user-dropdown']/a/span[1]")
	private WebElement name_text;

	//Action
	public void clickSignInLink () {
		clickOnElement(sign_in_link);
	}
	
	public String getCurrentName () {
		return waitAndGetTextOfElement(name_text);
	}
}

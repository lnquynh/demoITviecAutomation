/**
 * 
 */
package com.itviec.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.itviec.core.BasePage;

/**
 * @author Quynh Lai
 *
 */
public class HomePage extends BasePage {
	
	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Find Elements
	@FindBy(xpath = "//*[@id='search_text']/following::input[1]")
	private WebElement search_textbox;
	
	@FindBy(xpath = "//*[@value='Search']")
	private WebElement search_button;
	
	@FindBy(xpath = "//*[@id='job-mail-subscribe-modal']//span[text()='×']")
	private WebElement dismiss_button;
	
	@FindBy(xpath = "//*[@class='job__body']//a")
	private WebElement search_job_result;
	
	//Action
	public void searchJob (String text) {
		search_textbox.sendKeys(text + Keys.ENTER);
	}
	
	public void openJobDetail () {
		clickOnElement(search_job_result);
	}
	
	public void dismissPopup () {
		if (isElementPresent(dismiss_button)) clickOnElement(dismiss_button);
	}

}

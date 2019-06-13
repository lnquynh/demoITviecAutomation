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
public class JobPage extends BasePage {
	
	// Constructor
	public JobPage(WebDriver driver) {
		super(driver);
	}

	// Find Elements
	@FindBy(xpath = "//*[@class='job_info']//a[contains(@href, 'job_applications')]")
	private WebElement apply_job_button;
	
	@FindBy(id = "job_application_fullname")
	private WebElement fullname_textbox;
	
	//@FindBy(xpath = "//*[@class='fake_file']")
	//private WebElement upload_cv_textbox;
	
	@FindBy(xpath = "//*[@id='job_application_cv_local']")
	private WebElement upload_cv_textbox;
	
	@FindBy(id = "//button[contains(text(),'Send my CV')]")
	private WebElement send_cv_button;
	
	public void applyJob (String fullname, String CVPath) {
		clickOnElement(apply_job_button);
		sendkeyToElement(fullname_textbox, fullname);
		//sendkeyToElement(upload_cv_textbox, CVPath);
		clickOnElement(send_cv_button);
	}
	
	public void verifyApplyJob () {
	}

}

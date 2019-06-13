/**
 * 
 */
package com.itviec.test;

import org.testng.annotations.Test;

import com.itviec.core.BaseTest;
import com.itviec.pages.GmailPage;
import com.itviec.pages.HeaderPage;
import com.itviec.pages.HomePage;
import com.itviec.pages.JobPage;
import com.itviec.pages.LoginPage;

/**
 * @author Quynh Lai
 *
 */
public class LoginTest extends BaseTest {
	public LoginPage loginPage;
	public HeaderPage headerPage;
	public HomePage homePage;
	
	@Test (priority = 0)
	public void createAccountAndConfirmEmailTest() {
		String username = "Quynh";
		String email = "tmasittwi3@gmail.com";
		String password = "12345678x@X";
		driver.get("https://itviec.com/");
		
		//Create the new account
		headerPage = new HeaderPage(driver);
		headerPage.clickSignInLink();
		
		loginPage = new LoginPage(driver);
		loginPage.clickCreateAccount();
		loginPage.createNewAccount(username, email, password);
		loginPage.verifyCreateAccount();
		
		//Confirm email
		driver.get("https://gmail.com/");
		
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.loginGmail(email, password);
		gmailPage.confirmEmail();
		gmailPage.switchTab(1);
		gmailPage.verifyConfirmEmail();
	}
	
	@Test (priority = 1)
	public void applyJob () {
		String name = "Quynh";
		String email = "tmasittwi3@gmail.com";
		String password = "12345678x@X";
		String jobName = "QA Automation codelink";
		String cvName = "/Users/Downloads/Manual and Automation CV_Lai Ngoc Quynh.pdf";
		
		driver.get("https://itviec.com/");
		headerPage = new HeaderPage(driver);
		headerPage.clickSignInLink();
		
		loginPage = new LoginPage(driver);
		loginPage.loginWith(email, password);
		loginPage.verifyLogin(name);
		
		homePage = new HomePage(driver);
		homePage.dismissPopup();
		homePage.searchJob(jobName);
		homePage.openJobDetail();
		homePage.switchTab(1);
		
		JobPage jobPage = new JobPage(driver);
		jobPage.applyJob(name, cvName);
	}
}

/**
 * 
 */
package com.itviec.core;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Quynh Lai
 *
 */
public class BasePage {
	private static final int TIMEOUT = 20;
	private static final int POLLING = 100;
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToAppear (WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDisappear (WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForTextToAppear (By locator, String text) {
		wait.until(ExpectedConditions.textToBe(locator, text));
	}
	 
	public void clickOnElement (WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void clickOnXpath (String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
	}
	
	public void sendkeyToElement (WebElement element, String text) {
		element.clear();
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}
	
	public void sendkeyToXpath (String id, String text) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//		WebElement elm = driver.findElement(By.xpath(xpath));
//		elm.clear();
//		elm.sendKeys(text);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('id').setAttribute('value', 'text')");
	}
	
	public String waitAndGetTextOfElement (WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	public void switchTab (int tabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(tabIndex));
	} 
	
    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void sleepInMilis (int milis) {
    	try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

}

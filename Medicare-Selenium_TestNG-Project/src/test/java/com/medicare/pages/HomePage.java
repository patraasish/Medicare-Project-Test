package com.medicare.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicare.base.BaseTest;

public class HomePage  extends BaseTest{
	
	@FindBy(xpath = "//a[contains(@href,'register')]")
	WebElement registerLink;
	
	@FindBy(xpath="//input[@id='search-product']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@id='search-product-button']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeBtn;
	
	
	@FindBy(xpath = "//button[@id='filter-button']")
	WebElement filterBtn;
	
	@FindBy(xpath = "//a[@id='lth']")
	WebElement lowToHigh;
	
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	
	public void click_register_link() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", registerLink);		
	}
	
	public void search_product() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", homeBtn);
		searchBox.sendKeys("Shelcal 500 Calcium+Vitamin D3 Tablet");
		executor.executeScript("arguments[0].click();", searchBtn);	
	}
	
	public void filter_product() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", homeBtn);
		executor.executeScript("arguments[0].click();", filterBtn);
		executor.executeScript("arguments[0].click();", lowToHigh);
	}
}

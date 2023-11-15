package com.medicare.testpages;

import org.testng.annotations.Test;

import com.medicare.base.BaseTest;
import com.medicare.pages.CartPage;
import com.medicare.pages.HomePage;
import com.medicare.pages.LoginPage;
import com.medicare.pages.PlaceOrderPage;
import com.medicare.pages.RegistrationPage;



public class MedicarePageTest extends BaseTest{
	
	HomePage homePage;
	RegistrationPage registrationPage;
	LoginPage loginPage;
	CartPage cartPage;
	PlaceOrderPage placeOrderPage;
	
	
	@Test(priority = 1)
	public void User_Registration() throws InterruptedException {
		homePage=new HomePage(driver);
		registrationPage=new RegistrationPage(driver);
		Thread.sleep(10000);
		homePage.click_register_link();
		Thread.sleep(4000);
		registrationPage.giveName("Asish Patra");
		registrationPage.giveEmail("asish@gmail.com");
		registrationPage.givePassword("1234");
		registrationPage.click_Submit();
		
		}
	
	
	@Test(priority = 2)
	public void User_Login() throws InterruptedException {
		loginPage=new LoginPage(driver);
		loginPage.logout();
		Thread.sleep(4000);
		loginPage.give_email("asish@gmail.com");
		loginPage.give_password("1234");
		loginPage.click_login();
		
	}
	
	
	
	@Test(priority = 3)
	public void Add_To_Cart() throws InterruptedException {
		Thread.sleep(2000);
		cartPage=new CartPage(driver);
		cartPage.add_To_Cart();
		Thread.sleep(2000);
		cartPage.print_successMessage();
	}
	
	@Test(priority = 4)
	public void Place_Order() throws InterruptedException {
		Thread.sleep(2000);
		placeOrderPage=new PlaceOrderPage(driver);
		cartPage.click_home();
		Thread.sleep(2000);
		cartPage.click_Cart();
		Thread.sleep(2000);
		cartPage.click_PlaceOrder();
		Thread.sleep(2000);
		placeOrderPage.Print_success_Message();
	}
	
	@Test(priority = 5)
	public void Search_Product() {
		homePage=new HomePage(driver);
		homePage.search_product();
	}
	
	@Test(priority = 6)
	public void Filter_Product() {
		homePage=new HomePage(driver);
		homePage.filter_product();
	}
	
	
}

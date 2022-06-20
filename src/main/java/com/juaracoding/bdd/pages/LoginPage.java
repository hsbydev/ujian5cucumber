package com.juaracoding.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.bdd.driver.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement btnTap;
	
	@FindBy (id = "SubmitLogin")
	private WebElement btnLogin;
	
	@FindBy (name = "email")
	private WebElement inputEmail;
	
	@FindBy (name = "passwd")
	private WebElement inputPassword;
	
	@FindBy (css = "#center_column > h1")
	private WebElement txtWelcome;
	
	@FindBy (css = "#block_top_menu > ul > li:nth-child(1) > a")
	private WebElement btnWomen;
	
	@FindBy (css = "#subcategories > ul > li:nth-child(2) > div.subcategory-image > a > img")
	private WebElement btnDresses;
	
	@FindBy (css = "#block_top_menu > ul > li:nth-child(3) > a")
	private WebElement btnTshirt;
	
	@FindBy (css ="#center_column > form > p > button > span")
	private WebElement btnProAddress;
	
	@FindBy (css ="#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	private WebElement btnBank;
	
	@FindBy (css ="#cart_navigation > button > span")
	private WebElement confirm;
	
	@FindBy (css ="#columns")
	private WebElement back;
	
	public void signIn(String email, String password) {
		btnTap.click();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}

	public void beliProduk() {
		btnWomen.click();
		//cat 1
		 driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img")).click();
		 tunggu(5);
		 driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		 driver.findElement(By.id("add_to_cart")).click();
		 driver.navigate().refresh();
		
		 
		 driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")).click();
		 tunggu(5);
		 driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		 driver.findElement(By.id("add_to_cart")).click();
		 driver.navigate().refresh();
		
		 
		 driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-in-line.first-item-of-tablet-line.last-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")).click();
		 tunggu(5);
		 driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		 driver.findElement(By.id("add_to_cart")).click();
		 driver.navigate().refresh();
		
		 
//		 //cat 2
		 btnDresses.click();
		 driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")).click();
		 tunggu(5);
		 driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		 driver.findElement(By.id("add_to_cart")).click();
		 driver.navigate().refresh();
		 
		 driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-in-line.first-item-of-tablet-line.last-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")).click();
		 tunggu(5);
		 driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		 driver.findElement(By.id("add_to_cart")).click();
		 driver.navigate().refresh();
		 //back.click();
		 
		 driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.last-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.left-block > div > a.product_img_link > img")).click();
		 tunggu(5);
		 driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		 driver.findElement(By.id("add_to_cart")).click();
				 
	}
	
	public void checkOut() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=order");
		driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")).click();
		btnProAddress.click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.cssSelector("#form > p > button > span")).click();
		btnBank.click();
		confirm.click();
		
	}

	public static void tunggu (int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

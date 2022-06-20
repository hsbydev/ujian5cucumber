package com.juaracoding.bdd;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.bdd.config.AutomationFrameWorkConfig;
import com.juaracoding.bdd.driver.DriverSingleton;
import com.juaracoding.bdd.pages.LoginPage;
import com.juaracoding.bdd.utils.ConfigurationProperties;
import com.juaracoding.bdd.utils.Constants;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameWorkConfig.class)
public class StepDefinition {
	
	private static WebDriver driver;
	private LoginPage loginPage;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
	}
	
	@AfterAll
	public static void quitDriver() {
		tunggu(5);
		driver.quit();
	}
	
	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}
	
	@And("Customer login dengan uname dan password")
	public void customer_login_dengan_uname_dan_password() {
		loginPage.signIn(configurationProperties.getEmail(),configurationProperties.getPassword());
	}
	@When("Customer berhasil login")
	public void customer_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtWelcome(),loginPage.getTxtWelcome());
	}
	
	@Then("Customer membeli barang dan membayar")
	public void customer_membeli_barang_dan_membayar() {
		loginPage.beliProduk();
		loginPage.checkOut();
	}
	
	public static void tunggu (int detik) {
		try {
			Thread.sleep(1000*detik);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

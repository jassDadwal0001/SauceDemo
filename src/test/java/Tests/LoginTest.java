package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        System.out.println("Login test Executed after this");
    }
   
 
    @Test(priority = 1)
    
    public void verifySuccessfullLogin()
    {
    	loginPage.login("standard_user", "secret_sauce");
    	
    	Assert.assertTrue(
    			
    			loginPage.isLoginSuccessful(),"Inventory page not loaded");
    	
    }
    
    @Test(priority = 2)
   
    	public void ErrorMessageForInvalidLogin()
    	{
    		loginPage.login("invalid_user","wrong_password");
    		
    		Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
    				" Error message not displayed"
    				);
    		
    		Assert.assertEquals(loginPage.getErrorMessageText(), 
    				"Epic sadFace: sorry, this user has been locked out"
    				);
    	}

  

    @AfterMethod
    public void closure() {
        driver.quit();
    }
}

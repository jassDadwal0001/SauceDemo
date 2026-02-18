package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public void login(String username, String password) {
        waitForElementToBeVisible(By.id("user-name"));
        usernameField.sendKeys(username);

        waitForElementToBeVisible(By.id("password"));
        passwordField.sendKeys(password);

        waitForElementToBeClickable(By.id("login-button"));
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        waitForElementToBeVisible(By.id("inventory_container"));
        return driver.findElement(By.id("inventory_container")).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        waitForElementToBeVisible(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
  	  return errorMessage.isDisplayed();
        
    }
    
    public String getErrorMessageText() {
    			waitForElementToBeVisible(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
    					return errorMessage.getText();
}
}

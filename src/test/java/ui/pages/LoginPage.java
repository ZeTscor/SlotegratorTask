package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {super(driver);}

    private final By loginInput = By.xpath("//input[@id='UserLogin_username']");
    private final By passwordInput = By.xpath("//input[@id='UserLogin_password']");
    private final By signInButton = By.xpath("//input[@value='Sign in']");

    public LoginPage enterLogin (String login){
        driver.findElement(loginInput).sendKeys(login);
        return this;
    }
    public LoginPage enterPassword (String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    public LoginPage signButtonClick (){
        driver.findElement(signInButton).click();
        return this;
    }

}

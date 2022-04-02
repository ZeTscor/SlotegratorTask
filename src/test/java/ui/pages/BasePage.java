package ui.pages;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.config.UiConfig;

import java.time.Duration;

public class BasePage {
    static UiConfig ui = ConfigFactory.create(UiConfig.class, System.getProperties());

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(ui.explicitWait())).until(ExpectedConditions.visibilityOf(element));
        return element;

    }

    public WebElement waitElementIsNotVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(ui.explicitWait())).until(ExpectedConditions.invisibilityOf(element));
        return element;
    }
}

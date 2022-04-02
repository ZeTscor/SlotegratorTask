package ui.common;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.config.UiConfig;

import java.util.concurrent.TimeUnit;

public class CommonAction {
    static UiConfig ui = ConfigFactory.create(UiConfig.class, System.getProperties());

    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (ui.browser()){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case  "MOZILLA":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                Assertions.fail("INCORRECT BROWSER NAME" + ui.browser() );
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ui.implicitWait() , TimeUnit.SECONDS);
        return driver;
    }
}

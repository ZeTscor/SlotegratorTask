package ui.test;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ui.common.CommonAction;
import ui.config.UiConfig;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;
import ui.pages.PlayersPage;

public class BaseSteps {
    static UiConfig ui = ConfigFactory.create(UiConfig.class, System.getProperties());
    protected WebDriver driver = CommonAction.createDriver();
    protected LoginPage loginPage = new LoginPage(driver);
    protected DashboardPage dashboardPage = new DashboardPage(driver);
    protected PlayersPage playersPage = new PlayersPage(driver);

    @AfterEach
    void clearCookiesAndStorage() {
        if (ui.clearCookies()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    void close() {
            driver.close();
        }
    }


package ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private final By depositPanel = By.xpath("(//div[@class='panel-heading'])[1]");
    private final By userButton = By.xpath("//a[@data-target='#s-menu-users']");
    private final By playersButton = By.xpath("//a[@href='/user/player/admin']");


    public DashboardPage loadPage() {
        waitElementIsVisible(driver.findElement(depositPanel));
        WebElement deposit = driver.findElement(depositPanel);
        Assertions.assertEquals("deposits in 30 days", deposit.getText().toLowerCase());
        return this;
    }

    public DashboardPage clickUserButton() {
        driver.findElement(userButton).click();
        return this;
    }

    public DashboardPage openSideMenu() {
        driver.findElement(playersButton);
        return this;
    }

    public DashboardPage clickPlayers() {
        driver.findElement(playersButton).click();
        return this;
    }

}

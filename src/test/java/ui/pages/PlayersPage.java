package ui.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PlayersPage extends BasePage {
    public PlayersPage(WebDriver driver) {
        super(driver);
    }

    private final By titleElement = By.xpath("//div[@class='panel-heading']");
    private final By exportButton = By.xpath("//a[@href='/user/player/export']");
    private final By playersTable = By.xpath("//div[@id='payment-system-transaction-grid']");
    private final By userNameColumn = By.xpath("(//a[@class='sort-link'])[1]");
    private final By userNameCell = By.xpath("//tr/td[2]");

    public PlayersPage loadPage() {
        waitElementIsVisible(driver.findElement(titleElement));
        driver.findElement(exportButton);
        driver.findElement(playersTable);
        return this;
    }

    public PlayersPage clickSortButton() {
        driver.findElement(userNameColumn).click();
        return this;
    }

    public PlayersPage sortTableByUserName() {
        List<WebElement> notSortedList = driver.findElements(userNameCell);
        driver.findElement(userNameColumn).click();
        waitElementIsNotVisible(driver.findElement(By.xpath("//div[contains(@class, 'grid-view-load')]")));
        List<WebElement> sortedList = driver.findElements(userNameCell);
        Assertions.assertNotEquals(notSortedList, sortedList);
        return this;


    }

}

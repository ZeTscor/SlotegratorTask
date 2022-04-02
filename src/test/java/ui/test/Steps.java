package ui.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps extends BaseSteps {
    @Given("Open {string} site")
    public void openSite(String site) {
        driver.get(site);
    }

    @When("Input login {string} on field")
    public void user_input_login_on_field(String login) {
        loginPage.enterLogin(login);
    }

    @And("Input password {string} on field")
    public void user_input_password_on_field(String password) {
        loginPage.enterPassword(password);
    }

    @And("Click button 'Sign in'")
    public void userClickButtonSignIn() {
        loginPage.signButtonClick();
    }

    @Then("Dashboard is loaded")
    public void dashboardLoad() {
        dashboardPage.loadPage();
        driver.quit();
    }

    @And("Click button bar 'User'")
    public void clickOnUser() {
        dashboardPage.clickUserButton();
    }

    @And("Open side menu")
    public void openSideMenu() {
        dashboardPage.openSideMenu();
    }

    @And("Click button 'Players'")
    public void clickButtonPlayers() {
        dashboardPage.clickPlayers();
    }

    @Then("Table user open")
    public void openTableUser() {
        playersPage.loadPage();
        driver.quit();
    }

    @And("Click sort button 'UserName'")
    public void clickUserNameButton() {
        playersPage.clickSortButton();
    }

    @Then("Table sorted")
    public void sortedTable() {
        playersPage.sortTableByUserName();
        driver.quit();
    }


}

package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.YourCartPage;

public class YourCartSteps {
    YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

    @And("I click on the continue-shopping button")
    public void clickOnContinueShoppingButton(){
        yourCartPage.clickOnContinueShoppingButton();
    }

    @And("I click on the checkout button")
    public void clickOnCheckoutButton(){
        yourCartPage.clickOnCheckoutButton();
    }

    @And("The title of the cart should be displayed")
    public void isCartTitleDisplayed(){
        Assertions.assertTrue(yourCartPage.isCartTitleDisplayed());
    }
}

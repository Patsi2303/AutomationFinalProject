package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @And("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @And("I click on the sidebar button")
    public void clickOnSidebarButton(){
        homePage.clickOnSidebarButton();
    }

    @And("I click on the logout button")
    public void clickOnLogoutButton(){
        homePage.clickOnLogoutButton();
    }

    @And("Login logo should be displayed")
    public void verifyLoginLogoIsDisplayed(){
        Assertions.assertTrue(homePage.isLoginLogoDisplayed());
    }

    @And("The product {string} should be displayed in the home page")
    public void verifyProductIsDisplayed(String productName){
        Assertions.assertTrue(homePage.isProductInHomePage(productName));
    }

    @And("I add to the cart the product {string}")
    public void addProductToCart(String productName) throws InterruptedException {
        homePage.addProductToCart(productName);
    }

    @And("The cart icon should display {string}")
    public void verifyCartIconNumber(String iconNumber){
        Assertions.assertTrue(homePage.verifyCartIconNumber(iconNumber));
    }

    @And("I remove the product {string} from the cart")
    public void removeProductFromCart(String productName){
        homePage.removeProductFromCart(productName);
    }

    @And("I click on the cart button")
    public void clickOnCartIcon(){
        homePage.clickOnCartButton();
    }
}

package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.YourInformationPage;

import java.util.List;

public class YourInformationSteps {
    YourInformationPage yourInformationPage = new YourInformationPage(DriverManager.getDriver().driver);

    @And("I click on the cancel button")
    public void clickOnCancelButton(){
        yourInformationPage.cancelOnContinueButton();
    }

    @And("I fill the checkout information with")
    public void fillCheckoutInformation(DataTable checkoutInformation){
        List<String> data = checkoutInformation.transpose().asList(String.class);
        yourInformationPage.setFirstNameTextBox(data.get(0));
        yourInformationPage.setLastNameTextBox(data.get(1));
        //yourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on the continue button")
    public void clickOnContinueButton() throws InterruptedException {
        yourInformationPage.clickOnContinueButton();
    }

    @And("A error message that says {string} should be displayed")
    public void verifyErrorMessage(String message){
        Assertions.assertTrue(yourInformationPage.errorMessageIsDisplayed(message));
    }
}

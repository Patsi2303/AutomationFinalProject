package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {
    WebDriver driver;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    @FindBy(id = "first-name")
    WebElement firstNameTextBox;

    @FindBy(id="last-name")
    WebElement lastNameTextBox;

    @FindBy(id="postal-code")
    WebElement zipCodeTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    public YourInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameTextBox(String firstName){
        firstNameTextBox.sendKeys(firstName);
    }

    public void setLastNameTextBox(String lastName){
        lastNameTextBox.sendKeys(lastName);
    }

    public void setZipCodeTextBox(String zipCode){
        zipCodeTextBox.sendKeys(zipCode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void cancelOnContinueButton(){
        cancelButton.click();
    }

    public boolean errorMessageIsDisplayed(String message){
        String actualMessage = errorMessage.getText();
        if(message.equalsIgnoreCase(actualMessage)){
            return true;
        }
        return false;
    }
}

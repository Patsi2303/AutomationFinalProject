package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    WebDriver driver;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "title")
    WebElement cartTitle;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public boolean isCartTitleDisplayed(){
        if(cartTitle.isDisplayed()){ return  true;}
        return false;
    }
}

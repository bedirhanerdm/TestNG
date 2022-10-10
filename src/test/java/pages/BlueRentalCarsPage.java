package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCarsPage {

    public BlueRentalCarsPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (xpath = "(//*[@role=\"button\"])[1]")
    public WebElement logInButton1;


    @FindBy (id = "formBasicEmail")
    public WebElement email;


    @FindBy (id = "dropdown-basic-button")
    public WebElement nameVisibility;




}

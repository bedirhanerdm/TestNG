package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HotelMyCampPage {

    public HotelMyCampPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//*[@href=\"/Account/Logon\"]")
    public WebElement logInButton;


    @FindBy (id = "btnSubmit")
    public WebElement LogInButton2;


    @FindBy (id = "UserName")
    public WebElement username;


    @FindBy (id = "Password")
    public WebElement password;


    @FindBy (xpath = "//*[@class=\"caption-subject font-green-sharp bold uppercase\"]")
    public WebElement girdiMi;


    @FindBy (xpath = "//*[text()=\"Try again please\"]")
    public WebElement girmediMi;


    @FindBy (xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagement;


    @FindBy (xpath = "//*[@href=\"/admin/RoomReservationAdmin\"]")
    public WebElement roomReservations;


    @FindBy (xpath = "//*[text()='Add Room Reservation ']")
    public WebElement addRoomReservation;


    @FindBy(id = "IDUser")
    public WebElement selectUser;


    @FindBy(xpath = "(//*[@class=\"day\"])[12]")
    public WebElement dateEnter;


    @FindBy(xpath = "(//*[@class=\"day\"])[19]")
    public WebElement dateQuit;


    @FindBy (id = "AdultAmount")
    public WebElement afterDateText;


    @FindBy (id = "IDHotelRoom")
    public WebElement idHotelRoom;


    @FindBy (id = "Price")
    public WebElement priceText;


}

package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmoothNegativeTest {

    @Test
    public void wrongUser() {


        // Bir test method olustur positiveLoginTest()  https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp"));

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.logInButton.click();


        // test data username: manager ,
        // test data password : manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hmcWrongUser"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hmcPass"));

        hotelMyCampPage.LogInButton2.click();


        // Degerleri girildiginde sayfaya basarili sekilde GIRILEMEDIGINI test et
        Assert.assertTrue(hotelMyCampPage.girmediMi.isDisplayed());

        Driver.closeDriver();
    }




    @Test
    public void wrongPass() {

        // Bir test method olustur positiveLoginTest()  https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp"));

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.logInButton.click();


        // test data username: manager ,
        // test data password : manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hmcUser"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hmcWrongPass"));

        hotelMyCampPage.LogInButton2.click();


        // Degerleri girildiginde sayfaya basarili sekilde GIRILEMEDIGINI test et
        Assert.assertTrue(hotelMyCampPage.girmediMi.isDisplayed());

        Driver.closeDriver();

    }


    @Test
    public void wrongUserPass() {

        // Bir test method olustur positiveLoginTest()  https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp"));

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.logInButton.click();


        // test data username: manager ,
        // test data password : manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hmcWrongUser"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hmcWrongPass"));

        hotelMyCampPage.LogInButton2.click();


        // Degerleri girildiginde sayfaya basarili sekilde GIRILEMEDIGINI test et
        Assert.assertTrue(hotelMyCampPage.girmediMi.isDisplayed());

        Driver.closeDriver();

    }
}

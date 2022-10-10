package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeTest {

    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    @Test
    public void test1() {

        // Bir test method olustur positiveLoginTest()  https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp"));


        hotelMyCampPage.logInButton.click();

    }


    @Test (dependsOnMethods = "test1")
    public void test2() {

        // test data username: manager ,
        // test data password : manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hmcWrongUser"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hmcWrongPass"));

        hotelMyCampPage.LogInButton2.click();

    }


    @Test (dependsOnMethods = "test2")
    public void test3() {


        // Degerleri girildiginde sayfaya basarili sekilde GIRILEMEDIGINI test et
        Assert.assertTrue(hotelMyCampPage.girmediMi.isDisplayed());

        Driver.closeDriver();


    }
}

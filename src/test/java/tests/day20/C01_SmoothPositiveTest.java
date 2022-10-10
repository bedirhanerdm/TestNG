package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SmoothPositiveTest {

    @Test
    public void test1() {

        // Bir test method olustur positiveLoginTest()  https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp"));

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.logInButton.click();



        // test data username: manager
        // test data password : Manager1!
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hmcUser"));

        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("hmcPass"));

        hotelMyCampPage.LogInButton2.click();



        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelMyCampPage.girdiMi.isDisplayed());

        Driver.closeDriver();

    }
}

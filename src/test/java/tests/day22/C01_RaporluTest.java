package tests.day22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class C01_RaporluTest extends TestBaseRapor {

     /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test1() throws InterruptedException {

        extentTest = extentReports.createTest("Pozitif Test", "Gecerli kullanici adi ile siteye giris yapma");

        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcars"));



        // login butonuna bas
        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();

        blueRentalCarsPage.logInButton1.click();

        extentTest.info("Log in butonuna tiklandi");


        // test data user email: customer@bluerentalcars.com ,
        // test data password : 12345 dataları girip login e basın
        // login butonuna tiklayin
        blueRentalCarsPage.email.sendKeys(ConfigReader.getProperty("brcEmail"));

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("brcPass")).sendKeys(Keys.ENTER).perform();

        extentTest.info("Kullanici bilgileriyle siteye giris yapildi");


        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertEquals(blueRentalCarsPage.nameVisibility.getText(), "John Walker");
        extentTest.info("Giris yapildigi dogrulandi");

        extentTest.pass("Sayfaya basarili bir sekilde girildi");
    }
}

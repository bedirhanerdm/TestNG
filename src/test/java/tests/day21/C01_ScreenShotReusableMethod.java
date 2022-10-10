package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {

    @Test
    public void test1() throws IOException {

        // hepsiburadaya git ve ss al
        Driver.getDriver().get("https://hepsiburada.com");

        ReusableMethods.getScreenshot("hepsiburada");

        Driver.closeDriver();
    }


    @Test
    public void test2() throws IOException {

        //Amazona git
        Driver.getDriver().get(ConfigReader.getProperty("amazon"));


        //Nutella arat
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);


        //Arama sonuc yazisi WebElementinin ss sini alin
        ReusableMethods.getScreenshotWebElement("AmazonAramaSonucu",amazonPage.aramaSonucWE);


        Driver.closeDriver();
    }
}

package tests.day17;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C05_PageClass {

    @Test
    public void test1(){

        AmazonPage amazonPage = new AmazonPage();

        Driver.getDriver().get("https://amazon.com");

        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        Driver.closeDriver();

        

    }
}

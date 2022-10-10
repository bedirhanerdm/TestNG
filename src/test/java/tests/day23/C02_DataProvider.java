package tests.day23;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {


    @DataProvider
    public static Object[][] kullanicilar() {

        return new Object[][]{{"bedirhan@gmail.com" , "12345"}, {"evren@gmail.com", "45678"},
                {"erdem@gmail.com", "67890"}};
    }


    @Test (dataProvider = "kullanicilar")
    public void test1(String userEmail, String password) {

        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcars"));


        //login butonuna bas
        BlueRentalCarsPage blueRentalCarsPage = new BlueRentalCarsPage();

        blueRentalCarsPage.logInButton1.click();


        // Data provider ile 3 farkli email ve password girelim
        blueRentalCarsPage.email.sendKeys(userEmail);

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.ENTER).perform();


        // Girilemedigini test edin
        Assert.assertTrue(Driver.getDriver().
                findElement(By.xpath("//*[@type=\"submit\"]")).isDisplayed());
    }
}

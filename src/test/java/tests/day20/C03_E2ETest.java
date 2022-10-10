package tests.day20;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2ETest {

    @Test
    public void E2ETest() throws InterruptedException {

        // https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycamp"));


        // Username ve password metin kutularını locate edin ve asagidaki verileri girin
        // Username : manager
        // Password  : Manager1!
        // Login butonuna tıklayın.
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.logInButton.click();

        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("hmcUser"));

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcPass")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        // Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hotelMyCampPage.hotelManagement.click();
        hotelMyCampPage.roomReservations.click();
        hotelMyCampPage.addRoomReservation.click();


        // Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        // Save butonuna tıklayın.
        Faker faker = new Faker();
        hotelMyCampPage.selectUser.sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/02/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys("Cheers mate")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();



        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='RoomReservation was inserted successfully']")).
                getText().contains("RoomReservation was inserted successfully"));


        //OK butonuna tıklayın.
        Driver.getDriver().findElement(By.xpath("//*[text()='OK']")).click();
    }
}

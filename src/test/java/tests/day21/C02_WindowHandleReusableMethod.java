package tests.day21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class C02_WindowHandleReusableMethod {

    @Test
    public void test1() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");


        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();


        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ArrayList<String> windows = new ArrayList<>(Driver.getDriver().getWindowHandles());

        Driver.getDriver().switchTo().window(windows.get(1));  // 2. pencereye gectik

        Assert.assertEquals(Driver.getDriver().getTitle(), "New Window");


    }


    @Test
    public void test2() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");


        //● Click Here butonuna basın.
        ReusableMethods.waitFor(2);

        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();


        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");

        Assert.assertEquals(Driver.getDriver().getTitle(), "New Window");


        Driver.quitDriver();
    }
}

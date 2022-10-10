package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;


public class C00_Odev extends TestBaseBeforeClassAfterClass {


    @Test
    public void test1() {

        // https://www.amazon.com/ adresine gidin.
        driver.get("https://amazon.com");

        // Test : Amazon ana sayfaya gittiginizi test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));


    }


    @Test (dependsOnMethods = "test1")
    public void test2() {

        // Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        // arama yapin ve aramanizin gerceklestigini Test edin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Nutella"));

    }


    @Test (dependsOnMethods = "test2")
    public void test3() {

        // Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class=\"s-image\"])[1]")).click();

        // ve fiyatinin $12.99 oldugunu test edin
        Assert.assertTrue(driver.findElement(By.id("corePrice_feature_div"))
                .getText().contains("12.99"));


    }
}

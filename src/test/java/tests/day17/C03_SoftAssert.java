package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMehtodAfterMethod;

public class C03_SoftAssert extends TestBaseBeforeMehtodAfterMethod {


    // Hata varsa en sonda kirmizi yazida verir, kodun calismasini durdurmaz


    @Test
    public void test01() {

        SoftAssert softAssert = new SoftAssert();

        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");


        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"), "Girdiginiz kelimeyi icermiyor");


        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        softAssert.assertTrue(aramaKutusu.isEnabled(), "WE erisilemiyor");


        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);


        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(), "SonucWE goruntulenemedi");


        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"), "Sonuc Nutella icermiyor");

        softAssert.assertAll();

        System.out.println("Hata varsa burasi ");
    }
}
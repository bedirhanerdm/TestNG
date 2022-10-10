package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMehtodAfterMethod;


public class C03_Priority extends TestBaseBeforeMehtodAfterMethod {


    /*Testlerimizi çalıştırırken istediğimiz sıraya göre çalışmasını istersek
    priority methodunu kullanırız
     Priority kullanmazsak default olarak 0 dır
     */


    @Test (priority = 1)  // 3. calisir
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }



    @Test // Burayı 0 kabul eder ve ikinci calisir
    public void bestbuyTest() {
        driver.get("https://www.bestbuy.com");
    }


    @Test (priority = 2, groups = "gp1")  // son calisir
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }


    @Test (priority = -1)   // ilk calisir
    public void hepsiburadaTest() {
        driver.get("https://www.hepsiburada.com");
    }
}
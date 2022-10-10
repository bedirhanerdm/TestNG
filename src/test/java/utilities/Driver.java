package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Driver {

    static WebDriver driver;
    static Actions actions;
    static LocalDateTime date;
    static String tarih;


    public static WebDriver getDriver(){

        /*
        Driver objesiyle classlarda islem yaptigimizda surekli yeni sayfa aciyor cunku surekli yeni driver olusturuyor,
        bu yuzden if statement kullaniyoruz driver null ise driver olusturuyor, degilse islem yapmiyor ve tek pencere oluyor.
        driver doluysa da kapatmak icin closeDriver kismina != if statement olusturuyoruz.
         */

        if (driver == null){

            switch (ConfigReader.getProperty("browser")){

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }



        }


        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        tarih = date.format(formater);

        return driver;
    }




    public static void closeDriver(){

        if (driver != null){

            driver.close();

            driver = null;
        }
    }


    public static void quitDriver(){

        if (driver != null){

            driver.quit();

            driver = null;
        }
    }
}

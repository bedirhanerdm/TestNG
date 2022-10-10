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

public class CrossDriver {

    private CrossDriver(){

    }


    static WebDriver driver;
    static Actions actions;
    static LocalDateTime date;
    static String tarih;


    public static WebDriver getDriver(String browser){

        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        // Testlerimizi xml file dan farkli browserlar ile calistirabilmek icin getDriver() methoduna parametre
        // atamamiz gerekir (yukaridaki method basindaki getDriver() icine)

        if (driver == null){

            switch (browser){

                //CrossBrowser icin bizim gönderdigimiz browser uzerinden calismasi icin
                //buraya parametre olarak girdigimiz degeri yazdik

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

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
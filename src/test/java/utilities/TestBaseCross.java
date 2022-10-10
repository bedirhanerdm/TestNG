package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseCross {

    protected WebDriver driver;
    protected Actions actions;
    protected LocalDateTime date;
    protected String tarih;


    @Parameters("browser")


    @BeforeClass
    public void setUp(@Optional String browser) {
        WebDriverManager.chromedriver().setup();
        driver = CrossDriver.getDriver(browser);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        tarih = date.format(formater);
    }



    @AfterClass
    public void tearDown() {
        CrossDriver.closeDriver();
    }

}

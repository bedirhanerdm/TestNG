package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {

    @Test
    public void test1() {

        // Amazona ve facebook sayfasina gidelim
        String urlAmzn = ConfigReader.getProperty("amazon");

        String urlFb = ConfigReader.getProperty("facebook");

        Driver.getDriver().get(urlAmzn);
        Driver.getDriver().get(urlFb);

        Driver.closeDriver();


    }
}

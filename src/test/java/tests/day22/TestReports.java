package tests.day22;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestReports extends TestBaseRapor {

    @Test
    public void test1() {

        extentTest=extentReports.createTest("Seri Test","Calisiyor mu diye test etme");

        Driver.getDriver().get(ConfigReader.getProperty("amazon"));

        extentTest.info("Amazona gidildi");

        extentTest.pass("Basariyla tamamlandi");




    }
}

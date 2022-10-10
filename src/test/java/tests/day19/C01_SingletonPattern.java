package tests.day19;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SingletonPattern {



    @Test
    public void test1() {

        Driver obj = new Driver();


        obj.getDriver().get(ConfigReader.getProperty("amazon"));

    }
}

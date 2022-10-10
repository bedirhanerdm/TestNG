package tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomeWork {

    @Test
    public void test1() {

        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().navigate().to(ConfigReader.getProperty("hepsiburada"));


        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//*[text()='Elektronik'])[1]"))).
                click(Driver.getDriver().
                        findElement(By.xpath("(//*[@href=\"https://www.hepsiburada.com/bilgisayarlar-c-2147483646\"])[1]")));


        //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        //Sayfayı kapatalım


    }
}

package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;


public class C01_PageClassFacebookTest {


    @Test (groups = "gp2")
    public void test1() {

        // https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://facebook.com");



        // POM’a uygun olarak email, sifre kutularini ve giris yap
        // butonunu locate edin
        FacebookPage fbPage = new FacebookPage();



        // Faker class’ini kullanarak email ve sifre degerlerini
        // yazdirip, giris butonuna basin
        Faker faker = new Faker();

        fbPage.email.sendKeys(faker.internet().emailAddress());

        fbPage.pass.sendKeys(faker.internet().password());

        fbPage.login.click();



        // Basarili giris yapilamadigini test edin
        Assert.assertTrue(fbPage.girisYapilamadi.getText().contains("you entered isn't connected"));

        // veya
        Assert.assertTrue(fbPage.girisYapilamadi.isDisplayed());


    }
}

package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HerokuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Practice02 {

    @DataProvider
    public static Object[][] kullanici() {
        return new Object[][]{{ConfigReader.getProperty("email1"),ConfigReader.getProperty("password1")},
                {ConfigReader.getProperty("email2"),ConfigReader.getProperty("password2")},
                {ConfigReader.getProperty("email3"),ConfigReader.getProperty("password3")}};
    }

    @Test(dataProvider ="kullanici")
    public void test02(String email, String password) throws InterruptedException {

   // Negative Test
   // 1.  https://id.heroku.com/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));

   // 2.  Data provider kullanarak mail adres ve passwordleri giriniz
        HerokuPage obj = new HerokuPage();
        obj.email.sendKeys(email);
        Thread.sleep(3000);
        obj.password.sendKeys(password);
        Thread.sleep(3000);

   // 3.  Login butonuna tiklayiniz
        obj.loginButton.click();
        Thread.sleep(3000);

   // 4.  "There was a problem with your login." texti gorunur olduğunu test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(obj.errorMessage.isDisplayed());

   // 5.  sayfalari kapatiniz
        Driver.closeDriver();
        softAssert.assertAll();







    }
}

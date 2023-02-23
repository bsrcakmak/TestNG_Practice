package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    public class Driver {

    /*
        Driver'daki temel mantik extents yontemiyle degil yani TestBase class'ina extent etmek yerine
    Driver class'indan static methodlar kullanarak driver olustruruz.

    1- Ilk olarak public static WebDriver getDriver() methodu olusturmak. Bu method bize bir driver getirecek.
    2- Driver'i kapatacagimiz zaman da public static void closeDriver() methodu olusturmak. Istedigimiz zaman
       bu method ile driver'i kapatacagiz.

     */

        static WebDriver driver;

        public static WebDriver getDriver(){

            if (driver==null){  // Eger Driver'a deger atanmamissa deger ata, eger deger atanmissa driver'i ayni sayfada return et.
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            }
            return driver;
        }

        public static void closeDriver(){
            if (driver!=null){  // Driver'a deger atanmissa
                driver.close();
                driver=null;
            }
        }

        public static void quitDriver(){
            if (driver!=null){  // Driver'a deger atanmissa
                driver.quit();
                driver=null;
            }
        }





    }



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import user.MainPage;

import java.util.concurrent.TimeUnit;

/**
 * @author yuriismac on 4/12/21.
 * @project litecart_project
 */
public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(driver);
//          mainPage.openRegistrationForm()
//                   .registerNewUser("Test1", "Test2", "q12312w@mail.com", "q123456", "q123456");
        /*mainPage.login("q12312w@mail.com", "q123456")
                .selectCampaignProduct()
                .addProductToCart()
                .openCart()
                .orderCheckout("Stryiska1", "lviv", "34333", "+390984444444");*/

        //driver.close();


    }
}

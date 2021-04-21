import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author yuriismac on 4/18/21.
 * @project litecart_project
 */
public class MainAdminClass {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

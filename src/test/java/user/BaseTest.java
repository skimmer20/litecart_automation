package user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import user.MainPage;

/**
 * @author yuriismac on 4/8/21.
 * @project litecart_project
 */
public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public MainPage mainPage;
    private static final String BASE_URL = "http://localhost/litecart/";;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        mainPage = new MainPage(driver);
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}

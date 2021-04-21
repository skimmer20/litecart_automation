package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/19/21.
 * @project litecart_project
 */
    public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private String logoutLocator = "//a[contains(@title,'Logout')]";
    /*@FindBy(xpath = "//ul[@id='box-apps-menu']/li[contains(@data-code,'currencies')]/a")
    private WebElement currenciesTab;*/
    @FindBy(xpath = "//span[@title='Currencies']")
    private WebElement currenciesTab;
    @FindBy(xpath = "//a[contains(@title,'Logout')]")
    private WebElement logoutText;


    public AdminPage(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void waitForElementPresent(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }


    public void waitForElementIsNotPresent(String locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));

    }

    public void waitForLoaderPresent() {
        waitForElementPresent("//div[@class='loader-wrapper']/div[@class='loader']");
    }

    public void waitForLoaderIsNotPresent() {
        waitForElementIsNotPresent("//div[@class='loader-wrapper']/div[@class='loader']");
    }

    public void waitForLoaderIsDisappeared() {
        waitForLoaderPresent();
        waitForLoaderIsNotPresent();
    }

    public CurrenciesPage openCurrenciesPage() {
        waitForElementPresent(logoutLocator);
        currenciesTab.click();
        return new CurrenciesPage(driver);
    }

    public CatalogPage openCatalogPage() {
        waitForElementPresent(logoutLocator);
        currenciesTab.click();
        return new CatalogPage(driver);
    }
}

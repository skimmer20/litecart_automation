package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author yuriismac on 4/19/21.
 * @project litecart_project
 */
public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private String logoutLocator = "//li/a[@title='Logout']";
    private String welcomeText = "//div[(text()=' You are now logged in as admin')]";
    @FindBy(xpath = "//li[@data-code='catalog']/a")
    private WebElement catalogTab;
    /*@FindBy(xpath = "//ul[@id='box-apps-menu']/li[contains(@data-code,'currencies')]/a")
    private WebElement currenciesTab;*/
    @FindBy(xpath = "//*[@id='box-apps-menu']/li[@data-code='currencies']/a")
    private WebElement currenciesTab;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void waitForElementPresent(String locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void waitForElementIsNotPresent(String locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));

    }

    public void waitForLoaderPresent() {
        waitForElementPresent("//div[@class='loader']");
    }

    public void waitForLoaderIsNotPresent() {
        waitForElementIsNotPresent("//div[@class='loader-wrapper']/div[@class='loader']");
    }

    public void waitForLoaderIsDisappeared() {
        waitForLoaderPresent();
        waitForLoaderIsNotPresent();
    }

    public CurrenciesPage openCurrenciesPage() throws InterruptedException {
        waitForElementPresent(logoutLocator);
        Thread.sleep(5000);
        waitForElementClickable(currenciesTab);
        currenciesTab.click();
        return new CurrenciesPage(driver);
    }

    public CatalogPage openCatalogPage() throws InterruptedException {
        waitForElementPresent(logoutLocator);
        Thread.sleep(5000);
        catalogTab.click();
        return new CatalogPage(driver);
    }
}

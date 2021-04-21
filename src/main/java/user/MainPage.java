package user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/12/21.
 * @project litecart_project
 */
public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//li[@class='account dropdown']/a[@class='dropdown-toggle']")
    private WebElement signInDropDown;
    @FindBy(xpath = "//div[@class='input-group']/input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//div[@class='input-group']/input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@class='btn-group btn-block']/button[@type='submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//li[@class='text-center']/a[text()='New customers click here']")
    private WebElement registrationFormButton;
    @FindBy(xpath = "//div[@class='image-wrapper']/img[@alt='Yellow Duck']")
    private WebElement selectProduct;
    @FindBy(xpath = "//div[@class='loader-wrapper']/div[@class='loader']")
    private WebElement loader;

    public WebElement waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public void waitForElementPresent(String locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }


    public void waitForElementIsNotPresent(String locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));

    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
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

    public void clickSignInDropdown() {
        signInDropDown.click();
    }

    public MainPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    public RegistrationPage openRegistrationForm() {
        clickSignInDropdown();
        registrationFormButton.click();
        return new RegistrationPage(driver);
    }

    public MainPage login(String email, String password) {
        signInDropDown.click();
        typeEmail(email);
        typePassword(password);
        clickSignInButton();
        return new MainPage(driver);
    }

    public ProductPage selectCampaignProduct() {
        waitForElementToBeClickable(selectProduct);
        selectProduct.click();
        return new ProductPage(driver);
    }
}

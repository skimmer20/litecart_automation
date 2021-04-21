package user;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/13/21.
 * @project litecart_project
 */
public class ProductPage {

    private WebDriver driver;
    private MainPage mainPage;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
        mainPage = new MainPage(driver);
    }

    @FindBy(xpath = "//select[@name='options[Size]']")
    private WebElement selectDropDownElement;
    @FindBy(xpath = "/option[@value='Medium']")
    private WebElement selectProductSize;
    @FindBy(xpath = "//div[@id='box-cookie-notice']//button[@name='accept_cookies']")
    private WebElement acceptCookiesButton;
    @FindBy(xpath = "//button[@name='add_cart_product']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='cart']/a")
    private WebElement cartButton;
    @FindBy(xpath = "//h1[text()='Yellow Duck']")
    private WebElement productName;
    @FindBy(xpath = "//strong[@class='campaign-price']")
    private WebElement productPrice;
    @FindBy(xpath = "//div[@class='badge quantity']")
    private WebElement badgeQuantity;

    public ProductPage selectSizeFromDropdown(String size) {
        Select select = new Select(selectDropDownElement);
        select.selectByValue(size);
        return this;
    }

    public ProductPage addProductToCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartButton);
        wait.until(ExpectedConditions.textToBePresentInElement(badgeQuantity, "1"));
        return this;
    }

    public CheckoutPage openCart() {
        cartButton.click();
        return new CheckoutPage(driver);
    }
}

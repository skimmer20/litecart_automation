package user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/13/21.
 * @project litecart_project
 */
public class CheckoutPage {

    private MainPage mainPage;
    private ProductPage productPage;
    private WebDriver driver;
    private WebDriverWait wait;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
        mainPage = new MainPage(driver);
    }

    @FindBy(xpath = "//div[@class='form-group col-xs-6']/input[@name='address1']")
    private WebElement addressField;
    @FindBy(xpath = "//div[@class='form-group col-xs-6']/input[@name='city']")
    private WebElement cityField;
    @FindBy(xpath = "//div[@class='form-group col-xs-6']/input[@name='postcode']")
    private WebElement postCodeField;
    @FindBy(xpath = "//div[@class='input-group']/input[@name='phone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//button[@name='save_customer_details']")
    private WebElement saveCustomerDetailsField;
    @FindBy(xpath = "//div[@class='consent text-center']//input[@type='checkbox']")
    private WebElement checkboxSelect;
    @FindBy(xpath = "//div[@class='col-md-3']/button")
    private WebElement confirmOrderButton;

    public CheckoutPage typeAddress(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public CheckoutPage typeCity(String city) {
        cityField.sendKeys(city);
        return this;
    }

    public CheckoutPage typePostCode(String postCode) {
        postCodeField.sendKeys(postCode);
        return this;
    }

    public CheckoutPage typePhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    public CheckoutPage saveCustomerDetails() {
        saveCustomerDetailsField.sendKeys(Keys.ENTER);
        return this;
    }

    public CheckoutPage selectCheckboxField() {
        checkboxSelect.click();
        return this;
    }

    public CheckoutPage confirmOrderButton(){
        confirmOrderButton.sendKeys(Keys.ENTER);
        return this;
    }

    public CheckoutPage orderCheckout(String address, String city, String postCode, String phoneNumber){
        mainPage.waitForLoaderIsDisappeared();
        typeAddress(address);
        typeCity(city);
        typePostCode(postCode);
        typePhoneNumber(phoneNumber);
        saveCustomerDetails();//waiter
        mainPage.waitForLoaderIsDisappeared();
        selectCheckboxField();
        confirmOrderButton();
        return this;
    }
}

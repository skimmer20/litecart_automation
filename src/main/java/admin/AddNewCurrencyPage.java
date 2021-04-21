package admin;

import dto.CurrencyDto;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/20/21.
 * @project litecart_project
 */
public class AddNewCurrencyPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private AdminPage adminPage;

    @FindBy(xpath = "//label[@class='btn btn-default']/input[@value='1']")
    private WebElement enableStatusButton;
    @FindBy(xpath = "//div[@class='form-group col-md-6']//input[@name='name']")
    private WebElement currencyName;
    @FindBy(xpath = "//div[@class='form-group col-md-6 required']/input[@name='code']")
    private WebElement currencyCode;
    @FindBy(xpath = "//div[@class='form-group col-md-6 required']/input[@name='number']")
    private WebElement currencyNumber;
    @FindBy(xpath = "//div[@class='input-group']/input[@name='value']")
    private WebElement currencyValue;
    @FindBy(xpath = "//div[@class='form-group col-md-6']//input[@name='decimals']")
    private WebElement currencyDecimals;
    @FindBy(xpath = "//div[@class='form-group col-md-6']//input[@name='prefix']")
    private WebElement currencyPrefix;
    @FindBy(xpath = "//div[@class='panel-action btn-group']/button[@name='save']")
    private WebElement saveNewCurrencyButton;

    public AddNewCurrencyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        adminPage = new AdminPage(driver);
    }

    public AddNewCurrencyPage typeName(String name) {
        currencyName.sendKeys(name);
        return this;
    }

    public AddNewCurrencyPage typeCode(String code) {
        currencyCode.sendKeys(code);
        return this;
    }

    public AddNewCurrencyPage typeNumber(String number) {
        currencyNumber.sendKeys(number);
        return this;
    }

    public AddNewCurrencyPage typeValue(String value) {
        currencyValue.sendKeys(value);
        return this;
    }

    public AddNewCurrencyPage typeDecimals(String decimals) {
        currencyDecimals.sendKeys(decimals);
        return this;
    }

    public AddNewCurrencyPage typePrefix(String prefix) {
        currencyPrefix.sendKeys(prefix);
        return this;
    }

    public AddNewCurrencyPage enableStatusButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", enableStatusButton);
        return this;
    }

    public CurrenciesPage addNewCurrency(CurrencyDto currencyDto) {
        enableStatusButton();
        typeName(currencyDto.getName());
        typeCode(currencyDto.getCode());
        typeNumber(currencyDto.getNumber());
        typeValue(currencyDto.getValue());
        typeDecimals(currencyDto.getDecimal());
        typePrefix(currencyDto.getPrefix());
        saveNewCurrencyButton.click();
        return new CurrenciesPage(driver);
    }

}

package admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/19/21.
 * @project litecart_project
 */
public class CurrenciesPage {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private AdminPage adminPage;

    private final String addCurrencyLocator = "//li/a[@class='btn btn-default']";
    @FindBy(xpath = "//li/a[@class='btn btn-default']")
    private WebElement addNewCurrencyButton;

    public CurrenciesPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        adminPage = new AdminPage(driver);
    }

    public AddNewCurrencyPage openNewCurrencyPage() {
        adminPage.waitForElementPresent(addCurrencyLocator);
        addNewCurrencyButton.click();
        return new AddNewCurrencyPage(webDriver);
    }
}

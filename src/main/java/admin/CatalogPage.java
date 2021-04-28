package admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/11/21.
 * @project litecart_project
 */
public class CatalogPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private AdminPage adminPage;
    private final String addNewProductLocator = "//li/a[text()=' Add New Product']";
    @FindBy(xpath = "//li/a[text()=' Add New Product']")
    private WebElement addNewProductButton;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        adminPage = new AdminPage(driver);
    }

    public AddNewProductPage openNewProductPage(){
        adminPage.waitForElementPresent(addNewProductLocator);
        addNewProductButton.click();
        return new AddNewProductPage(driver);
    }
}

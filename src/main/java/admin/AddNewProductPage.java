package admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
public class AddNewProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private AdminPage adminPage;

    @FindBy(xpath = "//label[@class='btn btn-default']/input[@value='1']")
    private WebElement enableStatusButton;
    @FindBy(xpath = "///input[@name='name[en]']")
    private WebElement productName;
    /*@FindBy(xpath = "//input[@data-name='Root']")
    private WebElement categoryRootCheckbox;*/
    @FindBy(xpath = "//input[@data-name='Subcategory']")
    private WebElement subcategoryCheckbox;
    @FindBy(xpath = "//input[@name='code']")
    private WebElement productCode;
    @FindBy(xpath = "//div[@class='col-md-4']//input[@name='sku']")
    private WebElement productSku;
    @FindBy(xpath = "//div[@class='col-md-4']//input[@name='mpn']")
    private WebElement productMpn;
    @FindBy(xpath = "//select[@name='default_category_id']/option[contains(@value, '2')]")
    private WebElement defaultCategory;




    public AddNewProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        adminPage = new AdminPage(driver);
    }


}

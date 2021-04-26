package admin;

import dto.ProductDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
public class AddNewProductPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private AdminPage adminPage;
    private String defaultCategoryLocator = "//select[@name='default_category_id']/option[contains(text(), 'Subcategory')]";
    private String manufacturerLocator = "//select[@name='manufacturer_id']/option[contains(text(),'ACME Corp.')]";

    @FindBy(xpath = "//label[contains(text(),'Enabled')]")
    private WebElement enableStatusButton;
    @FindBy(xpath = "//input[@data-name='Subcategory']")
    private WebElement subcategoryCheckbox;//
    @FindBy(xpath = "//select[@name='default_category_id']/option")
    private WebElement defaultCategory;//is not used
    @FindBy(xpath = "//input[@name='date_valid_from']")
    private WebElement selectDateValidFrom;
    @FindBy(xpath = "//input[@name='date_valid_to']")
    private WebElement selectDateValidTo;
    @FindBy(xpath = "//input[@name='name[en]']")
    private WebElement productName;
    @FindBy(xpath = "//input[@name='code']")
    private WebElement productCode;
    @FindBy(xpath = "//div[@id='tab-general']//input[@name='sku']")
    private WebElement productSku;
    @FindBy(xpath = "//div[@id='tab-general']//input[@name='mpn']")
    private WebElement productMpn;
    @FindBy(xpath = "//select[@name='manufacturer_id']/option[contains(text(),'ACME Corp.')]")
    private WebElement productManufacturer;//is not used
    @FindBy(xpath = "//input[@type='file']")
    private WebElement chooseFileButton;
    @FindBy(xpath = "//li/a[contains(text(), 'Information')]")
    private WebElement informationTab;
    @FindBy(xpath = "//li/a[contains(text(), 'Prices')]")
    private WebElement priceTab;
    @FindBy(xpath = "//li/a[contains(text(), 'Stock')]")
    private WebElement stockTab;
    @FindBy(xpath = "//input[@name='short_description[en]']")
    private WebElement shortDescriptionField;
    @FindBy(xpath = "//textarea[@name='description[en]']")
    private WebElement descriptionField;
    @FindBy(xpath = "//textarea[@name='technical_data[en]']")
    private WebElement technicalDataField;
    @FindBy(xpath = "//input[@name='prices[USD]']")
    private WebElement priceUSD;
    @FindBy(xpath = "//input[@name='weight']")
    private WebElement productWeight;
    @FindBy(xpath = "//input[@name='dim_x']")
    private WebElement dimX;
    @FindBy(xpath = "//input[@name='dim_y']")
    private WebElement dimY;
    @FindBy(xpath = "//input[@name='dim_z']")
    private WebElement dimZ;
    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement productQuantity;
    @FindBy(xpath = "//button[@name='save']")
    private WebElement saveProductButton;

    public AddNewProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        adminPage = new AdminPage(driver);
    }

    public AddNewProductPage selectCategory() {
        subcategoryCheckbox.isSelected();
        subcategoryCheckbox.click();
        return this;
    }

    public AddNewProductPage chooseDefaultCategory(String category) throws Exception {
        List<WebElement> allOptions = driver.findElements(By.xpath(defaultCategoryLocator));
        Iterator<WebElement> i = allOptions.iterator();
        while (i.hasNext()) {
            WebElement element = i.next();
            if (element.getText().equals(category)) {
                element.click();
            }
        }
        return this;
    }

    public AddNewProductPage dateValidFrom(String dateFrom) {
        selectDateValidFrom.sendKeys(dateFrom);
        return this;
    }

    public AddNewProductPage dateValidTo(String dateTo) {
        selectDateValidTo.sendKeys(dateTo);
        return this;
    }

    public AddNewProductPage typeName(String name) {
        productName.sendKeys(name);
        return this;
    }

    public AddNewProductPage typeCode(String code) {
        productCode.sendKeys(code);
        return this;
    }

    public AddNewProductPage typeSku(String sku) {
        productSku.sendKeys(sku);
        return this;
    }

    public AddNewProductPage typeMpn(String mpn) {
        productMpn.sendKeys(mpn);
        return this;
    }

    public AddNewProductPage chooseManufacturer(String manufacturer) throws Exception {
        List<WebElement> allOptions = driver.findElements(By.xpath(manufacturerLocator));
        Iterator<WebElement> i = allOptions.iterator();
        while (i.hasNext()) {
            WebElement element = i.next();
            if (element.getText().equals(manufacturer)) {
                element.click();
            }
        }
        return this;
    }

    public AddNewProductPage uploadPhoto(String fileLocalUrl) {
        chooseFileButton.sendKeys(fileLocalUrl);
        return this;
    }

    public AddNewProductPage fillGeneralTab(ProductDto productDto) throws Exception {
        enableStatusButton.click();
        selectCategory();
        chooseDefaultCategory(productDto.getDefaultCategory());
        dateValidFrom(productDto.getDateFrom());
        dateValidTo(productDto.getDateTo());
        typeName(productDto.getName());
        typeCode(productDto.getCode());
        typeSku(productDto.getSku());
        typeMpn(productDto.getMpn());
        chooseManufacturer(productDto.getManufacturer());
        uploadPhoto(productDto.getFileLocalUrl());
        Thread.sleep(2000);
        informationTab.click();
        return this;
    }

    public AddNewProductPage fillInformationTab(ProductDto productDto) throws InterruptedException {
        shortDescriptionField.sendKeys(productDto.getShortDescription());
        descriptionField.sendKeys(productDto.getShortDescription());
        technicalDataField.sendKeys(productDto.getTechnicalData());
        Thread.sleep(2000);
        priceTab.click();
        return this;
    }

    public AddNewProductPage fillPriceTab(ProductDto productDto) throws InterruptedException {
        priceUSD.sendKeys(productDto.getPrice());
        Thread.sleep(2000);
        stockTab.click();
        return this;
    }

    public AddNewProductPage fillStockTab(ProductDto productDto) throws InterruptedException {
        productWeight.sendKeys(productDto.getWeight());
        dimX.sendKeys(productDto.getDimX());
        dimY.sendKeys(productDto.getDimY());
        dimZ.sendKeys(productDto.getDimZ());
        productQuantity.sendKeys(productDto.getQuantity());
        Thread.sleep(2000);
        saveProductButton.click();
        return this;
    }

    public CatalogPage createNewProduct(ProductDto productDto) throws Exception {
        fillGeneralTab(productDto);
        fillInformationTab(productDto);
        fillPriceTab(productDto);
        fillStockTab(productDto);
        return new CatalogPage(driver);
    }


}

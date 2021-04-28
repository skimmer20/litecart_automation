package admin;

import dto.AddNewProductDataProvider;
import dto.CurrencyDto;
import dto.ProductDto;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/27/21.
 * @project litecart_project
 */
public class AddNewProductWithPurchaseTest {

    private ProductDto productDto = new ProductDto();
    @Test
    public void addNewProductWithPurchase() throws Exception {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setName("Pound sterling");
        currencyDto.setNumber("826");
        currencyDto.setCode("GBP");
        currencyDto.setValue("1,39");
        currencyDto.setDecimal("2");
        currencyDto.setPrefix("£");
        /*loginPage.verifyLoginCredentials("admin", "admin")
                .openCurrenciesPage()
                .openNewCurrencyPage()
                .addNewCurrency(currencyDto);//go to catalog
        productDto.setDefaultCategory("Subcategory");
        productDto.setDateFrom("06-03-2021");
        productDto.setDateTo("06-03-2025");
        productDto.setName("BigBen");
        productDto.setCode("rd007");
        productDto.setSku("RD007");
        productDto.setMpn("12340007");
        productDto.setManufacturer("ACME Corp.");
        productDto.setShortDescription(AddNewProductDataProvider.SHORT_DESCRIPTION);
        productDto.setDescription(AddNewProductDataProvider.DESCRIPTION);
        productDto.setTechnicalData(AddNewProductDataProvider.TECHNICAL_DATA_BIG_BEN_DUCK);
        productDto.setPrice("30");
        productDto.setWeight("1");
        productDto.setDimX("6");
        productDto.setDimY("12");
        productDto.setDimZ("8");
        productDto.setQuantity("10");
        AdminPage.open();
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCatalogPage()
                .openNewProductPage()
                .createNewProduct(productDto);*/

    }

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}

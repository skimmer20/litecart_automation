package admin;

import dto.ProductDto;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
public class AddNewProductTest extends BaseTest {

    @Test
    public void addNewProductTest() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setDefaultCategory("Subcategory");
        productDto.setDateFrom("03-03-2021");
        productDto.setDateTo("03-03-2022");
        productDto.setName("Batman");
        productDto.setCode("rd006");
        productDto.setSku("RD006");
        productDto.setMpn("12340006");
        productDto.setManufacturer("ACME Corp.");
        productDto.setFileLocalUrl("/Users/yuriismac/Downloads/batman_duck.png");
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCatalogPage()
                .openNewProductPage()
                .fillGeneralTab(productDto);

    }
}

package admin;

import dto.AddNewProductDataProvider;
import dto.ProductDto;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
public class AddNewProductTest extends BaseTest {

    private ProductDto productDto = new ProductDto();

    @Test
    public void addNewProductTest() throws Exception {
        productDto.setDefaultCategory("Subcategory");
        productDto.setDateFrom("03-03-2021");
        productDto.setDateTo("03-03-2022");
        productDto.setName("Batman");
        productDto.setCode("rd006");
        productDto.setSku("RD006");
        productDto.setMpn("12340006");
        productDto.setManufacturer("ACME Corp.");
        productDto.setShortDescription(AddNewProductDataProvider.SHORT_DESCRIPTION);
        productDto.setDescription(AddNewProductDataProvider.DESCRIPTION);
        productDto.setTechnicalData(AddNewProductDataProvider.TECHNICAL_DATA);
        productDto.setPrice("20");
        productDto.setWeight("1");
        productDto.setDimX("6");
        productDto.setDimY("10");
        productDto.setDimZ("10");
        productDto.setQuantity("20");
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCatalogPage()
                .openNewProductPage()
                .createNewProduct(productDto);

    }
}

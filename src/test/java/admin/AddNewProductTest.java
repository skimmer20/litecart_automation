package admin;

import dto.ProductDto;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
public class AddNewProductTest extends BaseTest {

    private ProductDto productDto = new ProductDto();

    @Test
    public void fillGeneralTest() throws Exception{
        productDto.setDefaultCategory("Subcategory");
        productDto.setDateFrom("03-03-2021");
        productDto.setDateTo("03-03-2022");
        productDto.setName("Batman");
        productDto.setCode("rd006");
        productDto.setSku("RD006");
        productDto.setMpn("12340006");
        productDto.setManufacturer("ACME Corp.");
        productDto.setFileLocalUrl("/Users/yuriismac/Downloads/batman_duck.png");
    }

    @Test
    public void fillInformationTest() throws Exception{
        productDto.setShortDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Suspendisse sollicitudin ante massa, eget ornare libero porta congue.");
        productDto.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Suspendisse sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque dui non consequat sollicitudin. " +
                "Sed pretium tortor ac auctor molestie. Nulla facilisi. Maecenas pulvinar nibh vitae lectus vehicula semper." +
                " Donec et aliquet velit. Curabitur non ullamcorper mauris. In hac habitasse platea dictumst. " +
                "Phasellus ut pretium justo, sit amet bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, viverra nisi. " +
                "Morbi sit amet adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. " +
                "Proin justo massa, convallis vitae consectetur sit amet, facilisis id libero.");
        productDto.setTechnicalData("Colors\n" +
                "Body: Grey\n" +
                "Eyes: Black\n" +
                "Beak: Orange\n" +
                "\n" +
                "Other\n" +
                "Material: Plastic");
    }

    @Test
    public void fillPriceTest() throws Exception{
        productDto.setPrice("20");
    }

    @Test
    public void fillStockTest() throws Exception{
        productDto.setWeight("1");
        productDto.setDimX("6");
        productDto.setDimY("10");
        productDto.setDimZ("10");
        productDto.setQuantity("20");
    }


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
        productDto.setFileLocalUrl("/Users/yuriismac/Downloads/batman_duck.png");
        productDto.setShortDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Suspendisse sollicitudin ante massa, eget ornare libero porta congue.");
        productDto.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Suspendisse sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque dui non consequat sollicitudin. " +
                "Sed pretium tortor ac auctor molestie. Nulla facilisi. Maecenas pulvinar nibh vitae lectus vehicula semper." +
                " Donec et aliquet velit. Curabitur non ullamcorper mauris. In hac habitasse platea dictumst. " +
                "Phasellus ut pretium justo, sit amet bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, viverra nisi. " +
                "Morbi sit amet adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. " +
                "Proin justo massa, convallis vitae consectetur sit amet, facilisis id libero.");
        productDto.setTechnicalData("Colors\n" +
                "Body: Grey\n" +
                "Eyes: Black\n" +
                "Beak: Orange\n" +
                "\n" +
                "Other\n" +
                "Material: Plastic");
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

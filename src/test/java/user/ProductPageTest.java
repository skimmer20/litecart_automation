package user;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/19/21.
 * @project litecart_project
 */
public class ProductPageTest extends BaseTest {

    @Test
    public void addProductToCartTest(){
        ProductPage productPage = new ProductPage(driver);
        String expectedProductQuantity = "1";
        mainPage.login("test@mail.com", "qwerty123")
                .selectCampaignProduct()
                .selectSizeFromDropdown("Small")
                .addProductToCart();
        Assert.assertEquals(productPage.getNumberOfProductsInCart(), expectedProductQuantity);
    }
}

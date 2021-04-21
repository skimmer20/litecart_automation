package user;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/19/21.
 * @project litecart_project
 */
public class ProductPageTest extends BaseTest {

    @Test
    public void addProductToCartTest(){
        mainPage.login("test@mail.com", "qwerty123")
                .selectCampaignProduct()
                .selectSizeFromDropdown("Small")
                .addProductToCart();
    }
}

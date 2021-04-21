package user;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/19/21.
 * @project litecart_project
 */
public class CheckoutPageTest extends BaseTest {

    @Test
    public void orderCheckoutTest() {
        mainPage.login("test@mail.com", "qwerty123")
                .selectCampaignProduct()
                .addProductToCart()
                .openCart()
                .orderCheckout(
                        "Vydunka 74",
                        "Nova Ukrainka",
                        "35323",
                        "+380324447766"
                );
    }
}

package user;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/19/21.
 * @project litecart_project
 */
public class CheckoutPageTest extends BaseTest {

    @Test
    public void orderCheckoutTest() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String expectedText = "Thank you for your purchase. An order confirmation email has been sent. We will process your order shortly.";
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
        Assert.assertEquals(checkoutPage.getSuccessOrderConfirmation(), expectedText);
    }
}

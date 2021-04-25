package admin;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/20/21.
 * @project litecart_project
 */
public class CurrenciesPageTest extends BaseTest {

    @Test
    public void openNewCurrencyPageTest() throws InterruptedException {
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCurrenciesPage()
                .openNewCurrencyPage();
    }
}

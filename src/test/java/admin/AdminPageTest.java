package admin;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/10/21.
 * @project litecart_project
 */
public class AdminPageTest extends BaseTest {

    @Test
    public void openCurrenciesPageTest() throws InterruptedException {
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCurrenciesPage();
    }
}

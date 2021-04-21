package admin;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
public class CatalogPageTest extends BaseTest {

    @Test
    public void openNewProductPageTest(){
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCatalogPage()
                .openNewProductPage();
    }
}

package admin;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
public class AddNewProductTest extends BaseTest {

    @Test
    public void addNewProductTest(){
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCatalogPage();
    }
}

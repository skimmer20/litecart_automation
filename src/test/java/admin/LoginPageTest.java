package admin;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/20/21.
 * @project litecart_project
 */
public class LoginPageTest extends BaseTest {

    @Test
    public void verifyUserCanLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginCredentials("admin", "admin");
    }
}

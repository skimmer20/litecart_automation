package user;

import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/16/21.
 * @project litecart_project
 */
public class MainPageTest extends BaseTest {

    @Test
    public void login(){
        mainPage.login("q12312w@mail.com","q123456");
    }
}

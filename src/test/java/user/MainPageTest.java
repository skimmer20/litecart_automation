package user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/16/21.
 * @project litecart_project
 */
public class MainPageTest extends BaseTest {

    @Test
    public void login() {
        String expectedText = "You are now logged in as Test1 Test2.";
        mainPage.login("q12312w@mail.com", "q123456");
        Assert.assertEquals(mainPage.getSuccessLoginText(), expectedText);
    }
}

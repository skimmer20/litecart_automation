package user;

import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/18/21.
 * @project litecart_project
 */
public class RegistrationPageTest extends BaseTest {

    @Test
    public void registerNewUser() {
        String expectedText = "Your customer account has been created.";
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openRegistrationForm();
        registrationPage.typeFirstName("Yura");
        registrationPage.typeLastName("Pavliuk");
        registrationPage.selectCountry();
        registrationPage.typeEmail("qwerty@email.com");
        registrationPage.typePassword("qwerty123");
        registrationPage.typeConfirmPassword("qwerty123");
        registrationPage.selectTermsAgreed();
        registrationPage.selectNewsletterSubscribe();
        registrationPage.clickSignUpButton();
        Assert.assertEquals(registrationPage.getSuccessRegistrationText(), expectedText);
    }
}

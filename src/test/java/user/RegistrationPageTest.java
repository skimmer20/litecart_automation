package user;

import dto.UserDto;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/18/21.
 * @project litecart_project
 */
public class RegistrationPageTest extends BaseTest {

    @Test
    public void registerNewUser() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openRegistrationForm();
        registrationPage.typeFirstName("Yura");
        registrationPage.typeLastName("pav");
        registrationPage.selectCountry();
        registrationPage.typeEmail("test@mail.com");
        registrationPage.typePassword("qwerty123");
        registrationPage.typeConfirmPassword("qwerty123");
        registrationPage.selectTermsAgreed();
        registrationPage.selectNewsletterSubscribe();
        registrationPage.clickSignUpButton();
    }
}

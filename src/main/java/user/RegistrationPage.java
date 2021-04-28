package user;

import dto.UserDto;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/12/21.
 * @project litecart_project
 */
public class RegistrationPage {

    private MainPage mainPage;
    private WebDriver driver;
    WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 10);
        mainPage = new MainPage(driver);
    }

    @FindBy(name = "firstname")
    private WebElement userFirstName;
    @FindBy(name = "lastname")
    private WebElement userLastName;
    @FindBy(xpath = "//div[@class='select-wrapper']/select[@name='country_code']/option[@value='UA']")
    private WebElement userCountry;
    @FindBy(xpath = "//div[@class='form-group col-xs-6 required']/div[@class='input-group']/input[@type='email']")
    private WebElement userEmail;
    @FindBy(xpath = "//div[@class='form-group col-xs-6 required']/div[@class='input-group']/input[@name='password']")
    private WebElement userPassword;
    @FindBy(xpath = "//div[@class='form-group col-xs-6 required']/div[@class='input-group']/input[@name='confirmed_password']")
    private WebElement userConfirmPassword;
    @FindBy(xpath = "//label[@class='checkbox']/input[@type='checkbox']")
    private WebElement userNewsletterSubscribeCheckbox;
    @FindBy(xpath = "//div[@class='checkbox']/label/input[@name='terms_agreed']")
    private WebElement userTermsAgreed;
    @FindBy(xpath = "//div[@class='btn-group']/button[@name='create_account']")
    private WebElement userSignUpButton;
    @FindBy(css = ".alert.alert-success")
    private WebElement successRegistrationText;

    public RegistrationPage typeFirstName(String firstName) {
        userFirstName.sendKeys(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        userLastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage selectCountry() {
        userCountry.click();
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        userEmail.sendKeys(email);
        return this;
    }

    public RegistrationPage typePassword(String password) {
        userPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage typeConfirmPassword(String confirmPassword) {
        userConfirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public RegistrationPage selectNewsletterSubscribe() {
        userNewsletterSubscribeCheckbox.click();
        return this;
    }

    public RegistrationPage selectTermsAgreed() {
        userTermsAgreed.click();
        return this;
    }

    public MainPage clickSignUpButton() {
        userSignUpButton.sendKeys(Keys.ENTER);
        return new MainPage(driver);
    }

    public RegistrationPage registerNewUser(UserDto userDto) {
        typeFirstName(userDto.getUserFirstName());
        typeLastName(userDto.getUserLastName());
        selectCountry();
        typeEmail(userDto.getUserEmail());
        typePassword(userDto.getUserPassword());
        typeConfirmPassword(userDto.getUserConfirmPassword());
        selectNewsletterSubscribe();
        selectTermsAgreed();
        clickSignUpButton();
        return this;
    }

    public String getSuccessRegistrationText(){
        mainPage.waitForElementVisible(successRegistrationText);
        String textEdited = successRegistrationText.getText().replace("×", "").replace("\n", "");
        return textEdited;
    }
}

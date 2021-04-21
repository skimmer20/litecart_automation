package admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author yuriismac on 4/18/21.
 * @project litecart_project
 */
public class LoginPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @FindBy(xpath = "//div[@class='input-group']//input[@name='username']")
    private WebElement userName;
    @FindBy(xpath = "//div[@class='input-group']//input[@name='password']")
    private WebElement userPassword;
    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;

    public LoginPage typeUserName(String email){
        userName.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password){
        userPassword.sendKeys(password);
        return this;
    }

    public LoginPage loginButton(){
        loginButton.click();
        return this;
    }

    public AdminPage verifyLoginCredentials(String email, String password){
        typeUserName(email);
        typePassword(password);
        loginButton();
        return new AdminPage(webDriver);
    }
}

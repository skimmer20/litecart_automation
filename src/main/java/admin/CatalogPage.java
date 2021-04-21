package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author yuriismac on 4/11/21.
 * @project litecart_project
 */
public class CatalogPage {

    private WebDriver driver;


    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeLogin(String admin) {
        WebElement adminName = driver.findElement(By.xpath("//div[@class='input-group']//input[@name='username']"));
        adminName.sendKeys(admin);
    }
}

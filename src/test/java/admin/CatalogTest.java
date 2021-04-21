package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author yuriismac on 4/11/21.
 * @project litecart_project
 */
public class CatalogTest extends BaseTest {
//Tabs!
    @Test
    public void addNewCatalog() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement adminName = driver.findElement(By.xpath("//div[@class='input-group']//input[@name='username']"));
        adminName.sendKeys("admin");

        //typeLogin("admin");

        WebElement adminPassword = driver.findElement(By.xpath("//div[@class='input-group']//input[@name='password']"));
        adminPassword.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.xpath("//div[@class='footer']/button[@name='login']"));
        loginButton.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@id='box-apps-menu']//span[text()='Catalog']")))).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul[@class='docs']//span[text()='Catalog']")))).click();//!!!!
        /*WebElement currenciesButton = ;
        currenciesButton.click();*/

        // WebElement addNewProductButton = ;

        // WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='panel-action']/ul[@class='list-inline']/li/a[text()=' Add New Product']")))).click();


        /*WebElement generalTab = driver.findElement(By.xpath("//li[@class='active']//a[text()='General']"));
        generalTab.click();*/

        WebElement selectCategory1 = driver.findElement(By.xpath("//label[text()=' [Root]']/input[@data-name='Root']"));
        selectCategory1.click();

        WebElement selectCategory2 = driver.findElement(By.xpath("//label[text()=' Rubber Ducks']/input[@data-name='Rubber Ducks']"));
        selectCategory2.click();

        WebElement productName = driver.findElement(By.xpath("//div[@class='input-group']/input[@name='name[en]']"));
        productName.sendKeys("Black Duck");

        WebElement productCode = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='code']"));
        productCode.sendKeys("rd006");

        WebElement productSKU = driver.findElement(By.xpath("//div[@class='input-group']//input[@name='sku']"));
        productSKU.sendKeys("RD006");

        WebElement productMPN = driver.findElement(By.xpath("//div[@class='input-group']//input[@name='mpn']"));
        productMPN.sendKeys("12340006");
    }

}

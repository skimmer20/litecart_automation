package admin;

import dto.CurrencyDto;
import org.testng.annotations.Test;

/**
 * @author yuriismac on 4/20/21.
 * @project litecart_project
 */
public class AddNewCurrencyPageTest extends BaseTest {

    @Test
    public void addNewCurrencyTest(){
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setName("Pound sterling");
        currencyDto.setNumber("826");
        currencyDto.setCode("GBP");
        currencyDto.setValue("1,39");
        currencyDto.setDecimal("2");
        currencyDto.setPrefix("£");
        loginPage.verifyLoginCredentials("admin", "admin")
                .openCurrenciesPage()
                .openNewCurrencyPage()
                .addNewCurrency(currencyDto);

    }
}

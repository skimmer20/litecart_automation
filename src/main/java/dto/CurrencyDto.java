package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuriismac on 4/20/21.
 * @project litecart_project
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyDto {

    private String name;
    private String code;
    private String number;
    private String value;
    private String decimal;
    private String prefix;
}

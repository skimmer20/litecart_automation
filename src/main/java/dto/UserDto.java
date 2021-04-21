package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuriismac on 4/14/21.
 * @project litecart_project
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

    private String userFirstName;
    private String userLastName;
    private String userCountry;
    private String userEmail;
    private String userPassword;
    private String userConfirmPassword;
}

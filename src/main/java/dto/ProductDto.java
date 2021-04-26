package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuriismac on 4/21/21.
 * @project litecart_project
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private String defaultCategory;
    private String dateFrom;
    private String dateTo;
    private String name;
    private String code;
    private String sku;
    private String mpn;
    private String manufacturer;
    private String fileLocalUrl;
    private String shortDescription;
    private String description;
    private String technicalData;
    private String price;
    private String weight;
    private String dimX;
    private String dimY;
    private String dimZ;
    private String quantity;



}

package com.assignment.fdarecord.api.service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Product {
    @JsonProperty("product_number")
    private String productNumber;
    @JsonProperty("reference_drug")
    private String referenceDrug;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("active_ingredients")
    private List<ActiveIngredients> activeIngredientsList = new ArrayList<>();
    @JsonProperty("reference_standard")
    private String referenceStandard;
    @JsonProperty("dosage_form")
    private String dosageForm;
    private String route;
    @JsonProperty("marketing_status")
    private String marketingStatus;
}

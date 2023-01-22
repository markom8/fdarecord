package com.assignment.fdarecord.api.service.structure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private List<Submission> submissions;
    @JsonProperty("application_number")
    private String applicationNumber;
    @JsonProperty("sponsor_name")
    private String sponsorName;
    private List<Product> products;
    private String term;
    private Integer count;
}

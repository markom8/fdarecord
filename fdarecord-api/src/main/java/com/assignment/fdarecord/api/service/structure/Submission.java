package com.assignment.fdarecord.api.service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Submission {
    @JsonProperty("submission_type")
    private String submissionType;
    @JsonProperty("submission_number")
    private Integer submissionNumber;
    @JsonProperty("submission_status")
    private String submissionStatus;
    @JsonProperty("submission_status_date")
    private Date submissionStatusDate;
    @JsonProperty( "review_priority")
    private String reviewPriority;
    @JsonProperty("submission_class_code")
    private String submissionClassCode;
    @JsonProperty("submission_class_code_description")
    private String submissionClassCodeDescription;
    @JsonProperty("application_docs")
    private List<AplicationDocs> aplicationDocs = new ArrayList<>();
}

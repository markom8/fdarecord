package com.assignment.fdarecord.api.service.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Meta {
    private String disclaimer;
    private String terms;
    private String license;
    @JsonProperty("last_updated")
    private Date lastUpdate;
    private MetaResults results;
}

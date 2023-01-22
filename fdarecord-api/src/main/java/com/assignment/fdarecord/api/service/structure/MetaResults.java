package com.assignment.fdarecord.api.service.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetaResults {
    private Integer skip;
    private Integer limit;
    private Integer total;
}

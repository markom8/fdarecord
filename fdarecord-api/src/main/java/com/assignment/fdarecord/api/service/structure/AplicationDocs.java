package com.assignment.fdarecord.api.service.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AplicationDocs {
    private String id;
    private String url;
    private Date date;
    private String type;
}

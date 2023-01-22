package com.assignment.fdarecord.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fda_record")
public class FdaRecordEntity {
    @Id
    private String applicationNumber;

    private String manufacturerName;
    private String substanceName;
    @ElementCollection(targetClass=String.class)
    private List<String> productNumbers = new ArrayList<>();
}

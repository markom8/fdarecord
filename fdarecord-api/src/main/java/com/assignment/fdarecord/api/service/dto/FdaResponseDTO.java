package com.assignment.fdarecord.api.service.dto;

import com.assignment.fdarecord.api.service.structure.Meta;
import com.assignment.fdarecord.api.service.structure.Result;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FdaResponseDTO {
    private Meta meta;
    private List<Result> results;
}

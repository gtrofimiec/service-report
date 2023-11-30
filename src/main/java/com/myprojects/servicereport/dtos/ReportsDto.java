package com.myprojects.servicereport.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReportsDto {

    @JsonProperty
    private Long reportId;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private Long ministryTime;
    @JsonProperty
    private Long ldcTime;
    @JsonProperty
    private Long studies;
}

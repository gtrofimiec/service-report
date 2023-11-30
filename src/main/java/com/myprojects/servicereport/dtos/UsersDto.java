package com.myprojects.servicereport.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myprojects.servicereport.domain.ServiceGoal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UsersDto {

    @JsonProperty
    private Long userId;
    @JsonProperty
    private String fullName;
    @JsonProperty
    private ServiceGoal serviceGoal;
}

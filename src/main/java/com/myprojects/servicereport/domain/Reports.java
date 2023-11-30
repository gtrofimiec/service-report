package com.myprojects.servicereport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="report")
public class Reports {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="report_id")
    private Long reportId;

    @NotNull
    @Column(name="date")
    private LocalDate date;

    @NotNull
    @Column(name="ministryTime")
    private Long ministryTime;

    @NotNull
    @Column(name="ldcTime")
    private Long ldcTime;

    @NotNull
    @Column(name="studies")
    private Long studies;

    @Column(name = "deleted")
    private boolean deleted = false;
}

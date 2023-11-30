package com.myprojects.servicereport.domain;

import com.myprojects.servicereport.ServiceAs;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name="service_goal")
public class ServiceGoal {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="goal_id")
    private Long goalId;

    @NotNull
    @Column(name="date")
    private LocalDate date;

    @NotNull
    @Column(name="service_as")
    private ServiceAs serviceAs;
}

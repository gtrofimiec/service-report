package com.myprojects.servicereport.domain;

import com.myprojects.servicereport.ServiceAs;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="full_name")
    private String fullName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Users_Goals_Id")
    private ServiceGoal serviceGoal;
}

package com.snowlukin.springlab.EmployeeUni.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team_member")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "middle_name", nullable = false, length = 50)
    private String middleName;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "hiring_date", nullable = false)
    private LocalDate hiringDate;
}

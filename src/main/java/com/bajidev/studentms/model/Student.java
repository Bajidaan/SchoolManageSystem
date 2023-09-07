package com.bajidev.studentms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first name", nullable = false)
    private String firstName;

    @Column(name = "last name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student() {
    }
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


}

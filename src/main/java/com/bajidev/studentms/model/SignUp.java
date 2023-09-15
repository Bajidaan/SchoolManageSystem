package com.bajidev.studentms.model;

import lombok.Data;


@Data
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Category category;

    public SignUp() {
    }
}

package com.bajidev.studentms.controller;

import com.bajidev.studentms.model.*;
import com.bajidev.studentms.service.StudentServiceImpl;
import com.bajidev.studentms.service.TeacherService;
import com.bajidev.studentms.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Set;


@Controller
public class UserController {

    private final UserServiceImp userService;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    PasswordEncoder encoder;


    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
       return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/reg_form")
    public String registrationForm(Model model) {
        SignUp signUp = new SignUp();

        model.addAttribute("signUp", signUp);
        return "registration_form";
    }

    @PostMapping("/reg/save")
    public String saveUser(@ModelAttribute("signUp") SignUp signUp) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        User user = new User();

        if(signUp.getCategory().equals(Category.TEACHER)) {
            teacher.setFirstName(signUp.getFirstName());
            teacher.setLastName(signUp.getLastName());
            teacher.setEmail(signUp.getEmail());
            user.setUsername(signUp.getUsername());
            user.setPassword(encoder.encode(signUp.getPassword()));
            user.setAuthorities(Set.of(
                    new Role("ROLE_USER"),
                    new Role("ROLE_ADMIN")));

            teacherService.saveTeacher(teacher);

        } else {
            student.setFirstName(signUp.getFirstName());
            student.setLastName(signUp.getLastName());
            student.setEmail(signUp.getEmail());
            user.setUsername(signUp.getUsername());
            user.setPassword(encoder.encode(signUp.getPassword()));
            user.setAuthorities(Set.of(new Role("ROLE_USER")));
            studentService.saveStudent(student);
        }

        userService.saveUser(user);
        return "redirect:/students";

    }


}

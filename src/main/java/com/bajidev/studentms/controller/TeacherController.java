package com.bajidev.studentms.controller;

import com.bajidev.studentms.model.Teacher;
import com.bajidev.studentms.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String getAllTeaches(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "students";
    }
}

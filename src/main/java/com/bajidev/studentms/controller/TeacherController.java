package com.bajidev.studentms.controller;

import com.bajidev.studentms.model.Student;
import com.bajidev.studentms.model.Teacher;
import com.bajidev.studentms.service.StudentServiceImpl;
import com.bajidev.studentms.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String addNewTeacher(Model model) {
        Teacher teacher = new Teacher();

        model.addAttribute("teacher", teacher);
        return "create_teacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String editTeacher(@PathVariable Long id, Model model) {

        model.addAttribute("teacher", teacherService.findTeacherById(id));
        return "edit_teacher";
    }

    @PostMapping("/teachers/edit/{id}")
    public String updateTeacher(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher) {

        Teacher existingTeacher = teacherService.findTeacherById(id);

        existingTeacher.setId(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());
        System.out.printf("%s %s %s%n",
                existingTeacher.getFirstName(), existingTeacher.getLastName(), existingTeacher.getEmail());
        teacherService.updateTeacher(existingTeacher);

        return "redirect:/teachers";
    }

    @GetMapping("teachers/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return "redirect:/teachers";
    }


}

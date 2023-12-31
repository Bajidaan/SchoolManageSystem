package com.bajidev.studentms.controller;

import com.bajidev.studentms.model.Student;
import com.bajidev.studentms.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudent(Model model){
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        // Student Object to hold student form data
        Student student = new Student();

        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }


    @PostMapping("/{id}")
    public  String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save updated student
        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
    //buy: 9.9952
    //loss: 8.87056
    //gain: 12.10328
}

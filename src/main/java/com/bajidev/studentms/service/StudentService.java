package com.bajidev.studentms.service;

import com.bajidev.studentms.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);

}

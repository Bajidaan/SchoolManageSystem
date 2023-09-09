package com.bajidev.studentms.service;

import com.bajidev.studentms.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void saveStudent(Student student);
    Student getStudentById(Long id);

    void deleteStudent(Long id);

}

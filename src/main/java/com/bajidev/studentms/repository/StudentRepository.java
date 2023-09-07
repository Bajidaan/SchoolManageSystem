package com.bajidev.studentms.repository;

import com.bajidev.studentms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

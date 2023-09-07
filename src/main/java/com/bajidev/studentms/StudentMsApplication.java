package com.bajidev.studentms;

import com.bajidev.studentms.model.Student;
import com.bajidev.studentms.model.Teacher;
import com.bajidev.studentms.repository.StudentRepository;
import com.bajidev.studentms.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMsApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository) {
//        return args -> {
//            teacherRepository.save(new Teacher("Babajide", "Daniju", "bajidan4u@gmail.com"));
//            teacherRepository.save(new Teacher("Ruth", "Odufuwa", "ruth.com"));
//           teacherRepository.save(new Teacher("Faruk", "Daniju", "bajidax4u@gmail.com"));
//        };
//    }

}

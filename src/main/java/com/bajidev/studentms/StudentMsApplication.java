package com.bajidev.studentms;


import com.bajidev.studentms.config.RepositoryInitializer;
import com.bajidev.studentms.repository.RoleRepository;
import com.bajidev.studentms.repository.StudentRepository;
import com.bajidev.studentms.repository.TeacherRepository;
import com.bajidev.studentms.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class StudentMsApplication {

    public static void main(String[] args) {


        SpringApplication.run(StudentMsApplication.class, args);



    }

    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository, StudentRepository repository,
                                        UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        return args -> {

//            RepositoryInitializer initializer = new RepositoryInitializer(teacherRepository, repository, userRepository, roleRepository, encoder);
//            initializer.init();


        };
    }

}

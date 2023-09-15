package com.bajidev.studentms.config;

import com.bajidev.studentms.model.Role;
import com.bajidev.studentms.model.Student;
import com.bajidev.studentms.model.Teacher;
import com.bajidev.studentms.model.User;
import com.bajidev.studentms.repository.RoleRepository;
import com.bajidev.studentms.repository.StudentRepository;
import com.bajidev.studentms.repository.TeacherRepository;
import com.bajidev.studentms.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RepositoryInitializer {


    private final TeacherRepository teacherRepository;


    private final StudentRepository repository;


    private final UserRepository userRepository;


    private final RoleRepository roleRepository;


    private final PasswordEncoder encoder;


    public RepositoryInitializer(TeacherRepository teacherRepository, StudentRepository repository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.teacherRepository = teacherRepository;
        this.repository = repository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }


    public void init() {
        teacherRepository.save(new Teacher("Babajide", "Daniju", "bajidan4u@gmail.com"));
        teacherRepository.save(new Teacher("Ruth", "Odufuwa", "ruth.com"));
        teacherRepository.save(new Teacher("Faruk", "Daniju", "bajidax4u@gmail.com"));
        repository.save(new Student("Jame", "Okoro", "bajidan4u@gmail.com"));
        repository.save(new Student("Titi", "Adebowale", "ruth.com"));
        repository.save(new Student("Jonas", "Jones", "bajidax4u@gmail.com"));


        Role role1 = new Role("ROLE_ADMIN"); // Create a role with the name "ROLE_ADMIN"
        Set<Role> roles1 = new HashSet<>(); // Create a set to hold the roles
        roles1.add(role1); // Add the role to the set

        Role role2 = new Role("ROLE_USER"); // Create a role with the name "ROLE_ADMIN"
        Set<Role> roles2 = new HashSet<>(); // Create a set to hold the roles
        roles2.add(role2); // Add the role to the set studentSchool

        User user = new User("john", encoder.encode("password123"), roles1); // Create a user with a username, password, and roles
        User user2 = new User("bajidan", encoder.encode("jide"), roles2); // Create a user with a username, password, and roles
        User user3 = new User("dev", encoder.encode("password"), roles2); // Create a user with a username, password, and roles

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}

package com.bajidev.studentms.repository;

import com.bajidev.studentms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long id);
}

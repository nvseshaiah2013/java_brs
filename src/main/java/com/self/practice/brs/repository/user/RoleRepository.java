package com.self.practice.brs.repository.user;

import com.self.practice.brs.model.user.Role;
import com.self.practice.brs.model.user.UserRoles;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(UserRoles role);
}

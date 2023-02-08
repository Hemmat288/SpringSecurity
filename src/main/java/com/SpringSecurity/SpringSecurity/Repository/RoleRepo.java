package com.SpringSecurity.SpringSecurity.Repository;

import com.SpringSecurity.SpringSecurity.Entity.AppUser;
import com.SpringSecurity.SpringSecurity.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName (String name);
}

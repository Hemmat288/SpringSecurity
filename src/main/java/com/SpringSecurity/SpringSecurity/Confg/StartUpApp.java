package com.SpringSecurity.SpringSecurity.Confg;


import com.SpringSecurity.SpringSecurity.Entity.AppUser;
import com.SpringSecurity.SpringSecurity.Entity.Role;
import com.SpringSecurity.SpringSecurity.Service.RoleService;
import com.SpringSecurity.SpringSecurity.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {

    private final UserService userService;

    private final RoleService roleService;


    @Override
    public void run(String... args) throws Exception {


        if (roleService.findAll().isEmpty()) {
            roleService.save(new Role(null, "admin"));
            roleService.save(new Role(null, "user"));
            roleService.save(new Role(null, "employee"));
        }


        if (userService.findAll().isEmpty()) {

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(roleService.findByName("admin"));

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(roleService.findByName("user"));

            Set<Role>  empRoles = new HashSet<>();
            empRoles.add(roleService.findByName("employee"));

            userService.save(new AppUser(null,"Hemmat mofty","hmm","123",adminRoles));

            userService.save(new AppUser(null, "Ali Mohamed", "ali", "123", adminRoles));

            userService.save(new AppUser(null, "Ahmed Mahmoud", "ahmed", "123",adminRoles));
        }

    }

}

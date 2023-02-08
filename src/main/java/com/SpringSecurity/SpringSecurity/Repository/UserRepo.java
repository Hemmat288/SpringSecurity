package com.SpringSecurity.SpringSecurity.Repository;

import com.SpringSecurity.SpringSecurity.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByuseName (String useName) ;
}

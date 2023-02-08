package com.SpringSecurity.SpringSecurity.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sec_users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
private String fullName;
private String useName;
private String password;
@ManyToMany
@JoinTable(name = "sec_user_role",
        joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "role_id"))

@OrderColumn(name = "id")
private Set<Role>roles = new HashSet<>();

    public AppUser(Long userId) {
    }
}



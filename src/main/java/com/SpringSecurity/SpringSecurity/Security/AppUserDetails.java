package com.SpringSecurity.SpringSecurity.Security;

import com.SpringSecurity.SpringSecurity.Entity.AppUser;
import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
public class AppUserDetails implements UserDetails {
    private Long id;
    private String fullName;
    private String useName;
    private String password;

    private List<GrantedAuthority> authorities ;


    private boolean isEnabled;

    private boolean isCredentialsNonExpired;

    private boolean isAccountNonLocked;

    private boolean isAccountNonExpired;




    public AppUserDetails() {
        super();

    }

    public AppUserDetails(AppUser user) {
        super();
        this.id= user.getId();
        this.fullName =user.getFullName();
        this.useName= user.getUseName();
        this.password= user.getPassword();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(!user.getRoles().isEmpty()) {
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
        }

    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return useName;
    }


    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return isEnabled;
    }
}

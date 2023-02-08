package com.SpringSecurity.SpringSecurity.Service;


import com.SpringSecurity.SpringSecurity.Entity.AppUser;
import com.SpringSecurity.SpringSecurity.Repository.UserRepo;
import com.SpringSecurity.SpringSecurity.Security.AppUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService  {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder ;
    public List<AppUser> findAll (){

        return userRepo.findAll();
    }

    public AppUser findById (Long id){

        return userRepo.findById(id).orElse(null);
    }
    public AppUser save(AppUser Entity){
        Entity.setPassword(passwordEncoder.encode(Entity.getPassword()));
        return userRepo.save(Entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser =	userRepo.findByuseName(username);

        if (!appUser.isPresent()) {

            throw new UsernameNotFoundException("This User Not found with selected user name :- " + username);
        }
        return new AppUserDetails(appUser.get());


//////////// user for return only  userName,password,Authentication
//        return new User(appUser.get().getUseName(),appUser.get().getPassword(),getAuthorities(appUser.get()));


    }





//    	private static List<GrantedAuthority> getAuthorities(AppUser user) {
////////////////// هخزن ال roles اللي عندي علي شكلGrantedAuthority دي الطرقه اللي بيفهمها userDetailsService
//		List<GrantedAuthority> authorities = new ArrayList<>();
//
//		 if(!user.getRoles().isEmpty()) {
//		        	user.getRoles().forEach(role -> {
//		        		authorities.add(new SimpleGrantedAuthority(role.getName()));
//		        	});
//		        }
//		     return authorities;
//		}




}

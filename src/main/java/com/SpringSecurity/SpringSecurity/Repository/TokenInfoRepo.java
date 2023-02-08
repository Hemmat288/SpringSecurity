package com.SpringSecurity.SpringSecurity.Repository;

import java.util.Optional;

import com.SpringSecurity.SpringSecurity.Entity.TokenInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TokenInfoRepo extends JpaRepository<TokenInfo, Long> {

    Optional<TokenInfo> findByRefreshToken (String refreshToken);

}
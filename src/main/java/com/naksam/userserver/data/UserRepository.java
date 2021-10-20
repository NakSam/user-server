package com.naksam.userserver.data;

import com.naksam.userserver.domain.UserDomain;
import com.naksam.userserver.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

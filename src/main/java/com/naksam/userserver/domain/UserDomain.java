package com.naksam.userserver.domain;

import com.naksam.userserver.data.UserRepository;
import com.naksam.userserver.domain.entity.User;
import com.naksam.userserver.dto.JsonWebToken;
import com.naksam.userserver.dto.LoginForm;
import com.naksam.userserver.dto.UserInfo;
import com.naksam.userserver.feign.AccountRetryClient;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDomain {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AccountRetryClient accountRetryClient;

    public UserInfo login(LoginForm loginForm) {
        User user = userRepository.findByEmail(loginForm.getEmail())
                .orElseThrow(() -> new RuntimeException("가입된 회원이 없습니다"));

        user.checkPassword(loginForm.getPassword(), passwordEncoder);

        return new UserInfo(accountRetryClient.createToken(user.createMemberPayload())
                .getJsonWebToken(), user.id());
    }

    public User findDetail(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("가입된 회원이 없습니다"));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("가입된 회원이 없습니다"));
    }
}

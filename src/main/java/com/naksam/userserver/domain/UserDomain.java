package com.naksam.userserver.domain;

import com.naksam.userserver.data.UserRepository;
import com.naksam.userserver.domain.entity.User;
import com.naksam.userserver.dto.JsonWebToken;
import com.naksam.userserver.dto.LoginForm;
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

    public String login(LoginForm loginForm) {
        System.out.println(loginForm);
        User user = userRepository.findByEmail(loginForm.getEmail())
                .orElseThrow(() -> new RuntimeException("가입된 회원이 없습니다"));

        user.checkPassword(loginForm.getPassword(), passwordEncoder);

        return accountRetryClient.createToken(user.createMemberPayload())
                .getJsonWebToken();
    }

    public User findDetail(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("가입된 회원이 없습니다"));
    }
}

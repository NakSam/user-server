package com.naksam.userserver.service;

import com.naksam.userserver.domain.UserDomain;
import com.naksam.userserver.dto.LoginForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionService {
    private final UserDomain userDomain;

    public String login(LoginForm loginForm, int duration) {
        return userDomain.login(loginForm, duration);
    }
}

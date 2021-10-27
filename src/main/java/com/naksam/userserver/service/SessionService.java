package com.naksam.userserver.service;

import com.naksam.userserver.domain.UserDomain;
import com.naksam.userserver.dto.LoginForm;
import com.naksam.userserver.dto.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionService {
    private final UserDomain userDomain;

    public UserInfo login(LoginForm loginForm) {
        return userDomain.login(loginForm);
    }
}

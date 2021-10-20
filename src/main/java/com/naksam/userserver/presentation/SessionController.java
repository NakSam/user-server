package com.naksam.userserver.presentation;

import com.naksam.userserver.common.CookieFactory;
import com.naksam.userserver.dto.LoginForm;
import com.naksam.userserver.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/session")
public class SessionController {
    private final static int duration = 60 * 60 * 24 * 365;

    private final static String JWT_COOKIE_NAME = "naksam";

    private final SessionService sessionService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String jwt = sessionService.login(loginForm);

        if (jwt == null || jwt.isEmpty()) {
            throw new RuntimeException("로그인 실패");
        }

        httpServletResponse.addCookie(createCookie(jwt, httpServletRequest));

        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    private Cookie createCookie(String jwt, HttpServletRequest httpServletRequest) {
        return CookieFactory.createCookie(conf -> conf
                .name(JWT_COOKIE_NAME)
                .value(jwt)
                .expires(duration)
                .secure("https".equals(httpServletRequest.getScheme()))
        );
    }
}

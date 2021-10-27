package com.naksam.userserver.presentation;

import com.naksam.userserver.common.CookieFactory;
import com.naksam.userserver.dto.LoginForm;
import com.naksam.userserver.dto.UserInfo;
import com.naksam.userserver.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/session")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SessionController {
    private final static int duration = 60 * 60 * 24 * 365;

    private final static String JWT_COOKIE_NAME = "naksam";

    private final SessionService sessionService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserInfo userInfo = sessionService.login(loginForm);

        if (userInfo.getJwt() == null || userInfo.getJwt()
                .isEmpty()) {
            throw new RuntimeException("로그인 실패");
        }

        httpServletResponse.addCookie(createCookie(userInfo.getJwt(), httpServletRequest));

        return ResponseEntity.ok(userInfo.getUserId());
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

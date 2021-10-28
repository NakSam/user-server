package com.naksam.userserver.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Stream;

public class HttpSupport {
    public static String getToken(HttpServletRequest req, String name) {
        return getAuthorizationToken(req).orElseThrow(() -> new RuntimeException("토큰이 없습니다"));
    }

    public static Optional<Cookie> getCookie(HttpServletRequest req, String name) {
        return Stream.of(req.getCookies())
                .filter(cookie -> name.equals(cookie.getName()) && !cookie.getValue()
                        .isEmpty())
                .findFirst();
    }

    private static Optional<String> getAuthorizationToken(HttpServletRequest req) {
        return Optional.ofNullable(req.getHeader("authorization"))
                .map(token -> token.replaceAll("Bearer", "")
                        .trim());
    }
}

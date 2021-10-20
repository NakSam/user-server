package com.naksam.userserver.presentation;

import com.naksam.userserver.dto.UserDetailResponse;
import com.naksam.userserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/detail")
    public ResponseEntity<?> findUserDetail(HttpServletRequest req) {
        UserDetailResponse response = userService.findDetail(req);
        return ResponseEntity.ok(response);
    }
}

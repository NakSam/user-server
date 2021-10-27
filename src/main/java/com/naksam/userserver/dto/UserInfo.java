package com.naksam.userserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfo {
    private String jwt;
    private Long userId;
}

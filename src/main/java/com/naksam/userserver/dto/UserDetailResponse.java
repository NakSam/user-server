package com.naksam.userserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDetailResponse {
    private Long id;
    private String email;
    private String name;
}

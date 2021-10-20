package com.naksam.userserver.dto;

import lombok.Data;

@Data
public class JsonWebToken {
    private String jsonWebToken;

    public JsonWebToken() {
    }

    public JsonWebToken(String jsonWebToken) {
        this.jsonWebToken = jsonWebToken;
    }
}

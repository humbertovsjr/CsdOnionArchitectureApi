package csd.architecture.onionapi.api.controller.views;

import csd.architecture.onionapi.abstractions.tokens.Token;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private String accessToken;

    public LoginResponse(Token token) {
        this.accessToken = token.id().toString();
    }

    public String getAccessToken() {
        return accessToken;
    }
}

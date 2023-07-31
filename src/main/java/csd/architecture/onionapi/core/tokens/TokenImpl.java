package csd.architecture.onionapi.core.tokens;

import csd.architecture.onionapi.abstractions.tokens.Token;

public class TokenImpl implements Token {

    private String id;

    public TokenImpl(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return this.id;
    }

    public String getId() {
        return id;
    }
}

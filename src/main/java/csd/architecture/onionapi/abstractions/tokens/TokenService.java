package csd.architecture.onionapi.abstractions.tokens;

public interface TokenService {
    Token gerarToken(String username, String password);
}

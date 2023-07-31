package csd.architecture.onionapi.core.tokens;

import csd.architecture.onionapi.abstractions.tokens.Token;
import csd.architecture.onionapi.abstractions.tokens.TokenService;
import csd.architecture.onionapi.abstractions.users.User;
import csd.architecture.onionapi.abstractions.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserService userService;

    @Override
    public Token gerarToken(String username, String password) {
        User user = userService.getByUsername(username);
        if(user == null) return null;

        if(!user.passwordCheck(password))
            return null;
        return new TokenImpl(gerarToken());
    }

    private String gerarToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        String token = encoder.encodeToString(bytes);
        return token;
    }
}




package csd.architecture.onionapi.api.controller;

import csd.architecture.onionapi.abstractions.tokens.Token;
import csd.architecture.onionapi.abstractions.tokens.TokenService;
import csd.architecture.onionapi.api.controller.models.LoginRequest;
import csd.architecture.onionapi.api.controller.views.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UsuarioController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/usuario/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        if( loginRequest == null || !loginRequest.valido())
            return ResponseEntity.badRequest().build();

        Token token = tokenService.gerarToken(loginRequest.getUser(), loginRequest.getPassword());
        if(token == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return new ResponseEntity(new LoginResponse(token), HttpStatus.OK);

    }

}

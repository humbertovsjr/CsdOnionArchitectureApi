package csd.architecture.onionapi;

import csd.architecture.onionapi.api.controller.models.LoginRequest;
import csd.architecture.onionapi.api.controller.UsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LoginTests {

    @Autowired
    private UsuarioController usuarioController;

    @Test
    public void badRequest(){
        assertThat(usuarioController.login(new LoginRequest(null, null)).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void badUsername(){
        assertThat(usuarioController.login(new LoginRequest("usuarioX", "123")).getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void usuarioNaoAutorizado(){
        assertThat(usuarioController.login(new LoginRequest("usuario", "senhaErrada")).getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void usuarioLogado(){
        assertThat(usuarioController.login(new LoginRequest("usuario", "senha")).getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

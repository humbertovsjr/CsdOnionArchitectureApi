package csd.architecture.onionapi.api.controller.models;

public class LoginRequest {

    private String user;
    private String password;

    public LoginRequest(String usuario, String senha) {
        this.user = usuario;
        this.password = senha;
    }

    public boolean valido(){
        return user != null && password != null;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

package csd.architecture.onionapi.abstractions.users;

public class UserDto {

    public Long id;
    public String username;
    public String passwordHash;

    public UserDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.passwordHash = PasswordHelper.hash(password, id.toString());
    }
}

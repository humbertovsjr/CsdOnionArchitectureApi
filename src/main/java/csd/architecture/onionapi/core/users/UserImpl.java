package csd.architecture.onionapi.core.users;

import csd.architecture.onionapi.abstractions.users.PasswordHelper;
import csd.architecture.onionapi.abstractions.users.User;
import csd.architecture.onionapi.abstractions.users.UserDto;

import java.util.Optional;

public class UserImpl implements User {

    private Long id;
    private String username;
    private String passwordHash;

    public UserImpl(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.passwordHash = PasswordHelper.hash(password, id.toString());
    }

    public UserImpl(UserDto userDto) throws IllegalArgumentException {
        this.id = Optional.of(userDto.id).orElseThrow(IllegalArgumentException::new);
        this.username =  Optional.of(userDto.username).orElseThrow(IllegalArgumentException::new);
        this.passwordHash =  Optional.of(userDto.passwordHash).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Boolean passwordCheck(String password){
        if(password == null)
            return false;
        return PasswordHelper.hash(password, id.toString()).equals(passwordHash);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}

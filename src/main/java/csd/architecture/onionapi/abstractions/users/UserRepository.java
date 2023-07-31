package csd.architecture.onionapi.abstractions.users;

public interface UserRepository {
    UserDto getByUsername(String username);
}

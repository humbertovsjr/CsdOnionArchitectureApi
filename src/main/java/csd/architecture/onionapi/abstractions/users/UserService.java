package csd.architecture.onionapi.abstractions.users;

public interface UserService {
    User getByUsername(String username);
}

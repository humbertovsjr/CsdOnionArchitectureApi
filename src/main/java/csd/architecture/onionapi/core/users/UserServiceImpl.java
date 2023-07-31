package csd.architecture.onionapi.core.users;

import csd.architecture.onionapi.abstractions.users.User;
import csd.architecture.onionapi.abstractions.users.UserDto;
import csd.architecture.onionapi.abstractions.users.UserService;
import csd.architecture.onionapi.infrastructure.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public User getByUsername(String username) {
        UserDto userDto = userRepository.getByUsername(username);
        return userDto != null ? new UserImpl(userDto) : null;

    }
}

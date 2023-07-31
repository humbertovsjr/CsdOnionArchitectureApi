package csd.architecture.onionapi.infrastructure;

import csd.architecture.onionapi.abstractions.users.UserRepository;
import csd.architecture.onionapi.abstractions.users.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<UserDto> usuarios;

    public UserRepositoryImpl(){
        usuarios = new ArrayList<UserDto>();
        usuarios.add(new UserDto(1l,"usuario","senha"));
        usuarios.add(new UserDto(2l,"usuario1","senha1"));
        usuarios.add(new UserDto(3l,"usuario2","senha2"));
    }


    @Override
    public UserDto getByUsername(String username) {
        return usuarios.stream().filter(u -> u.username.equals(username)).findFirst().orElse(null);
    }

}

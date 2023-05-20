package reg.services.interfaces;

import reg.entity.User;
import reg.entity.UserDTO;
import reg.exceptions.UserAlreadyExistsException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user) throws UserAlreadyExistsException;
    UserDTO findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
    List<UserDTO> findAllUsers();
}
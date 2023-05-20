package reg.services;

import reg.entity.User;
import reg.entity.UserDTO;
import reg.exceptions.UserAlreadyExistsException;
import reg.repos.UserRepository;
import reg.services.interfaces.UserService;
import reg.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Converter mapperService;


    @Override
    @Transactional
    public void saveUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } else
            throw new UserAlreadyExistsException("User already exists!");
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findUserByEmail(String email) {
        return mapperService.mapDTOFromUser(userRepository.findByEmail(email));
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream()
                .map(mapperService::mapDTOFromUser)
                .collect(Collectors.toList());
    }

}

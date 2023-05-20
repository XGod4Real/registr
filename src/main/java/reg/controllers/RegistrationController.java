package reg.controllers;

import reg.entity.User;
import reg.entity.UserDTO;
import reg.exceptions.UserAlreadyExistsException;
import reg.services.interfaces.UserService;
import reg.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RegistrationController {
    private final Converter converter;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> forTestApi(@RequestBody UserDTO dto) throws UserAlreadyExistsException {
        User user = converter.mapUserFromDTO(dto);
        user.setPassword(dto.getPassword());
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }
}

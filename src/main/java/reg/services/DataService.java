package reg.services;


import reg.entity.User;
import reg.enums.Roles;
import reg.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataService implements ApplicationRunner {

    private final UserService userService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userService.findUserByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setSurname("Petrov");
            admin.setRole(Roles.ADMIN);
            admin.setEmail("admin@hmail.com");
            admin.setName("Ivan");
            admin.setPassword("123");
            userService.saveUser(admin);
        }
    }
}

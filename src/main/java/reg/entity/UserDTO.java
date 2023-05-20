package reg.entity;


import reg.enums.Roles;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO{
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String patronymic;
    private String email;
    private LocalDate date;
    private String password;
    private String phone;
    private String country;
    private String city;
    private String university;
    private String about;
    private Roles role;
    private boolean active;
}

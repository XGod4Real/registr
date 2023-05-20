package reg.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {

    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
    private String name;
    private String role;
    private long id;

    public JwtResponse(String accessToken, String refreshToken, String name, String role) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.name = name;
        this.role = role;
    }

    public JwtResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}

package reg.services;

import reg.entity.JwtToken;
import reg.repos.JwtRepo;
import reg.services.interfaces.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor

public class JwtServiceImpl implements JwtService {
    private final JwtRepo jwtRepo;

    @Override
    @Transactional
    public void saveJwt(String username, String token) {
        JwtToken jwtToken = jwtRepo.getByUsername(username);
        if (jwtToken == null) {
            jwtToken = new JwtToken();
            jwtToken.setRefreshToken(token);
            jwtToken.setUsername(username);
        } else
            jwtToken.setRefreshToken(token);
        jwtRepo.save(jwtToken);
    }

    @Override
    @Transactional(readOnly = true)
    public String getTokenByUsername(String username) {
        JwtToken byUsername = jwtRepo.getByUsername(username);
        if (byUsername != null) {
            return byUsername.getRefreshToken();
        } else {
            return "";
        }
    }

}

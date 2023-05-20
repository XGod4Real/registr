package reg.repos;

import reg.entity.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRepo extends JpaRepository<JwtToken, Long> {
    JwtToken getByUsername(String username);
}

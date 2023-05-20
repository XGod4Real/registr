package reg.services.interfaces;


public interface JwtService {
    void saveJwt(String username, String token);
    String getTokenByUsername(String username);

}

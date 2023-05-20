package reg.services.interfaces;


import reg.jwt.JwtAuthentication;
import reg.jwt.JwtRequest;
import reg.jwt.JwtResponse;
import jakarta.security.auth.message.AuthException;
import lombok.NonNull;


public interface AuthService {
    JwtResponse login(@NonNull JwtRequest authRequest) throws AuthException;
    JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException;
    JwtResponse refresh(@NonNull String refreshToken) throws AuthException;
    JwtAuthentication getAuthInfo();
}

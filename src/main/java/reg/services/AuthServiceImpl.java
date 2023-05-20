package reg.services;

import reg.entity.User;
import reg.jwt.JwtAuthentication;
import reg.jwt.JwtProvider;
import reg.jwt.JwtRequest;
import reg.jwt.JwtResponse;
import reg.services.interfaces.AuthService;
import reg.services.interfaces.JwtService;
import reg.services.interfaces.UserService;
import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse login(@NonNull JwtRequest authRequest) throws AuthException {
        User user = userService.findUserByUsername(authRequest.getUsername())
                .orElseThrow(() -> new AuthException("User not find!"));
        if (passwordEncoder.matches(authRequest.getPassword(),user.getPassword())) {
            String accessToken = jwtProvider.generateAccessToken(user);
            String refreshToken = jwtProvider.generateRefreshToken(user);
            jwtService.saveJwt(user.getUsername(), refreshToken);
            return new JwtResponse(accessToken, refreshToken, user.getName(), user.getRole().getAuthority());
        } else
            throw new AuthException("Incorrect password!");

    }

    @Override
    public JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = jwtService.getTokenByUsername(login);
            if (saveRefreshToken.equals(refreshToken)) {
                final User user = userService.findUserByUsername(login)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, refreshToken, user.getName(), user.getRole().getAuthority());
            }
        }
        return new JwtResponse();
    }

    @Override
    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = jwtService.getTokenByUsername(login);
            if (saveRefreshToken.equals(refreshToken)) {
                final User user = userService.findUserByUsername(login)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                jwtService.saveJwt(user.getUsername(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken, user.getName(), user.getRole().getAuthority());
            }
        }
        throw new AuthException("Невалидный JWT токен");
    }

    @Override
    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}

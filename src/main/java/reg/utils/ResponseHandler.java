package reg.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reg.jwt.JwtResponse;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(JwtResponse token) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", token.getType());
        map.put("accessToken", token.getAccessToken());
        map.put("refreshToken", token.getRefreshToken());
        map.put("role", token.getRole());
        map.put("id", token.getId());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public static ResponseEntity<Object> generateResponse(String message)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("message",message);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}

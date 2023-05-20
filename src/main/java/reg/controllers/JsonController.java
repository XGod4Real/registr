package reg.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JsonController {


   /* @PostMapping("/json")
    public ResponseEntity<String> handleJson(@RequestBody UserDto userDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // конвертация userDto в JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(userDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // отправка JSON на другой сайт
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://sgspunom.com/api/user",
                HttpMethod.POST,
                request,
                String.class);

        return ResponseEntity.ok("Ответ от сервера: " + response.getBody());
    }*/
}

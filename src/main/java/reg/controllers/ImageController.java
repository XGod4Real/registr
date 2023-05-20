package reg.controllers;

import reg.entity.ImageDTO;
import reg.services.interfaces.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("image")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class ImageController {

    private final ImageService imageService;

    @PostMapping()
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            ImageDTO imageDTO = imageService.saveImage(file);
        }

        return ResponseEntity.ok().build();
    }
}


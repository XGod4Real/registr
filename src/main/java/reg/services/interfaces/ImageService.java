package reg.services.interfaces;

import reg.entity.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ImageDTO saveImage(MultipartFile file) throws IOException;
}

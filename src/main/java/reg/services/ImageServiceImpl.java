package reg.services;

import reg.entity.Image;
import reg.entity.ImageDTO;
import reg.repos.ImageRepository;
import reg.services.interfaces.ImageService;
import reg.utils.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final Converter converter;

    @Value("${filepath}")
    private String filePath;

    @Override
    public ImageDTO saveImage(MultipartFile file) throws IOException {
        long size = file.getSize();
        Image image = new Image();
        image.setPicname(file.getOriginalFilename());
        image.setSize(size);
        image.setFilePath(filePath+file.getOriginalFilename());
        saveFile(file);
        image = imageRepository.save(image);
        return converter.mapImageDTOFromImage(image);
    }

    private void saveFile(MultipartFile multipartFile){
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(filePath).resolve(multipartFile.getOriginalFilename()));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            e.printStackTrace();
        }
    }

}
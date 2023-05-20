package reg.utils;

import reg.entity.Image;
import reg.entity.ImageDTO;
import reg.entity.User;
import reg.entity.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public User mapUserFromDTO(UserDTO dto)
    {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setUsername(dto.getUsername());
        user.setPatronymic(dto.getPatronymic());
        user.setEmail(dto.getEmail());
        user.setDate(dto.getDate());
        user.setPatronymic(dto.getPatronymic());
        user.setPhone(dto.getPhone());
        user.setCountry(dto.getCountry());
        user.setCity(dto.getCity());
        user.setUniversity(dto.getUniversity());
        user.setAbout(dto.getAbout());
        user.setRole(dto.getRole());
        return user;
    }

    public UserDTO mapDTOFromUser(User user)
    {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setUsername(user.getUsername());
        dto.setPatronymic(user.getPatronymic());
        dto.setEmail(user.getEmail());
        dto.setDate(user.getDate());
        dto.setPatronymic(user.getPatronymic());
        dto.setPhone(user.getPhone());
        dto.setCountry(user.getCountry());
        dto.setCity(user.getCity());
        dto.setUniversity(user.getUniversity());
        dto.setAbout(user.getAbout());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());
        return dto;
    }

    public Image mapImageFromDTO(ImageDTO dto)
    {
        Image image = new Image();
        image.setId(dto.getId());
        image.setPicname(dto.getPicname());
        image.setSize(dto.getSize());
        image.setFilePath(dto.getFilePath());
        return image;
    }

    public ImageDTO mapImageDTOFromImage(Image image)
    {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setPicname(image.getPicname());
        dto.setSize(image.getSize());
        dto.setFilePath(image.getFilePath());
        return dto;
    }
}

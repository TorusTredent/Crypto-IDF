package by.cryptoidf.service;

import by.cryptoidf.dto.UpdateProfileDTO;
import by.cryptoidf.entity.User;

public interface UserService {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    User save(User user);

    User updateProfile(UpdateProfileDTO updateProfileDTO);
}

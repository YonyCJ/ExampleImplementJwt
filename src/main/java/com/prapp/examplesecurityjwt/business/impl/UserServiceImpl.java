package com.prapp.examplesecurityjwt.business.impl;

import com.prapp.examplesecurityjwt.dao.entity.ProfileEntity;
import com.prapp.examplesecurityjwt.dao.entity.UserEntity;
import com.prapp.examplesecurityjwt.dao.entity.UserProfileEntity;
import com.prapp.examplesecurityjwt.dao.repository.ProfileRepository;
import com.prapp.examplesecurityjwt.dao.repository.UserProfileRepository;
import com.prapp.examplesecurityjwt.dao.repository.UserRepository;
import com.prapp.examplesecurityjwt.expose.dto.UserDto;
import com.prapp.examplesecurityjwt.expose.dto.UserProfileDto;
import com.prapp.examplesecurityjwt.business.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public UserDto.Response register(UserDto.Request request) {
        if (userRepository.findByUsernameAndIsActiveTrue(request.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }
        if (userRepository.findByEmailAndIsActiveTrue(request.getEmail()).isPresent()) {
            throw new RuntimeException("El correo electrónico ya está en uso.");
        }
        // Crear la entidad UserEntity y configurar sus campos
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setIsActive(true);
        // Guardar el usuario primero para generar el ID
        UserEntity userEntityCreated = userRepository.save(userEntity);

        // Asignar los perfiles asociados
        if (request.getProfiles() != null && !request.getProfiles().isEmpty()) {
            for (UserProfileDto.Request profileDto : request.getProfiles()) {
                UserProfileEntity userProfileEntity = new UserProfileEntity();
                Optional<ProfileEntity> profile = profileRepository.findById(profileDto.getProfile().getId());
                if (profile.isEmpty()) {
                    throw new RuntimeException("El perfil no existe.");
                }
                userProfileEntity.setUser(userEntityCreated);
                userProfileEntity.setProfile(profile.get());

                userProfileEntity.setState(1);
                userProfileRepository.save(userProfileEntity);
            }
        }else {
                UserProfileEntity userProfileEntity = new UserProfileEntity();
                ProfileEntity profile = new ProfileEntity();
                profile.setId(UUID.fromString("a138a822-700c-455d-bf55-907632a8f536"));
                userProfileEntity.setUser(userEntityCreated);
                userProfileEntity.setProfile(profile);
                userProfileEntity.setState(1);
                userProfileRepository.save(userProfileEntity);
        }

        // Crear respuesta
        UserDto.Response response = new UserDto.Response();
        response.setId(userEntity.getId());
        response.setUsername(userEntity.getUsername());
        response.setEmail(userEntity.getEmail());

        return response;

    }
}

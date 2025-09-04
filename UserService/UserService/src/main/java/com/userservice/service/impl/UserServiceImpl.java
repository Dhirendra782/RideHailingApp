package com.userservice.service.impl;

import com.userservice.exception.ResourceNotFoundException;
import com.userservice.mapper.ModelMapper;
import com.userservice.mapper.UserMapper;
import com.userservice.model.Role;
import com.userservice.model.User;
import com.userservice.payload.RegisterRequest;
import com.userservice.payload.UserProfileDto;
import com.userservice.repository.UserRepository;
import com.userservice.serviceinterface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    //Create Registration
    @Override
    public void registerUser(RegisterRequest request) {
        //Check username is exists or not
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("UsernMe already taken");
        }

        //Check email exists no not
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already taken");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole() == null ? Role.RIDER: request.getRole())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .licenseNumber(request.getLicenseNumber())
                .vehicleDetails(request.getVehicleDetails())
                .build();

        userRepository.save(user);

    }

    //Get profile by username
    @Override
    public UserProfileDto getProfileByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", username));

        return userMapper.fromUser(user); // <-- complete the call here

    }

    //update profile
    @Override
    public void updateProfile(String username, UserProfileDto profileDto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",username));

        user.setFullName(profileDto.getFullName());
        user.setPhoneNumber(profileDto.getPhoneNumber());

        if(user.getRole() == Role.DRIVER) {
            user.setLicenseNumber(profileDto.getLicenseNumber());
            user.setVehicleDetails(profileDto.getVehicleDetails());
        }

        userRepository.save(user);
    }

}

package com.userservice.serviceinterface;

import com.userservice.payload.RegisterRequest;
import com.userservice.payload.UserProfileDto;

public interface UserService {

    //create user registration
    void registerUser(RegisterRequest request);

    //get user profile by Username
    UserProfileDto getProfileByUsername(String username);

    //update user profile
    void updateProfile(String username, UserProfileDto profileDto);



}

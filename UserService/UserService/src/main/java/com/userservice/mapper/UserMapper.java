package com.userservice.mapper;

import com.userservice.model.User;
import com.userservice.payload.UserProfileDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public static UserProfileDto fromUser(User user) {

        return UserProfileDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .licenseNumber(user.getLicenseNumber())
                .vehicleDetails(user.getVehicleDetails())
                .build();

    }

}

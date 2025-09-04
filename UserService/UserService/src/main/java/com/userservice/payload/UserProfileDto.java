package com.userservice.payload;

import com.userservice.model.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDto {


    private String username;
    private String email;
    private Role role;
    private String fullName;
    private String phoneNumber;

    //Driver - specific fields
    private String licenseNumber;
    private String vehicleDetails;



}

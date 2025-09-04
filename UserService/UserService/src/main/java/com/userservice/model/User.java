package com.userservice.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // RIDER OR DRIVER


    //Profile fields (shared by both Riders and Drivers)
    private String fullName;
    private String phoneNumber;

    //Driver specific info
    private String licenseNumber;
    private String vehicleDetails;


}

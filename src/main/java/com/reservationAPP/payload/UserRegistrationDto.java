package com.reservationAPP.payload;

import jakarta.persistence.Lob;

public class UserRegistrationDto {

    private long id;
    private String name;
    private String email;
    private String password;

     //Annotation for image uploading
    private byte [] profilePicture;
}

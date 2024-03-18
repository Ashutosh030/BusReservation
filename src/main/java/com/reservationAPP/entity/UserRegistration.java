package com.reservationAPP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_registration")
public class UserRegistration {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String email;
private String password;

@Lob  //Annotation for image uploading
@Column (name ="profile_picture", length = 1024)
private byte [] profilePicture;

}

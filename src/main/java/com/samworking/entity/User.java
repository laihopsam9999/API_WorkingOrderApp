package com.samworking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    private Position position;

    private String address;

    @Column(name = "identity_number")
    private String identityNumber;

    @OneToMany (mappedBy = "payments", cascade = CascadeType.ALL)
    private Collection<Payment> paymentId;

    private enum Position {
        NORMAL,
        MANAGER,
        DIRECTOR,
        SALER,
        ADMIN,
    }

}

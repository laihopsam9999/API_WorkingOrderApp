package com.samworking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name="user_account")
public class UserAccount {
    @Id
    @Column (name = "account_name")
    private String accountName;

    private String password;

    @Column (name = "create_date")
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "account_name")
    private User users;

//    @OneToOne
    private Long levelId;

}

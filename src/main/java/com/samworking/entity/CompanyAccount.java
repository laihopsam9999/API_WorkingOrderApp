package com.samworking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table (name = "company_account")
public class CompanyAccount {
    @Id
    @Column (name = "account_name")
    private String accountName;

    private String password;

    @Column (name = "create_date")
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "account_name")
    private Customer customer;
}

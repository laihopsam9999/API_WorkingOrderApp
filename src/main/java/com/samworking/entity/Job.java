package com.samworking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table (name = "job")
public class Job {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private Float salary;

    private Integer member;

    private String address;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "expiry_date")
    private Date expiryDate;

//    @ManyToOne
    private Long customerId;
    
//    @OneToMany
    private Long insuranceId;
    
//    @OneToMany
    private Long majorId;

    @ManyToMany(mappedBy = "jobs")
    private Collection<Customer> customers;
}

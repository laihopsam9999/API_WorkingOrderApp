package com.samworking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table (name = "customer")
public class Customer {
    @Id
    private Long id;

    @Column (name = "customer_type")
    private CustomerType customerType;

    @Column (name = "customer_name")
    private String customerName;

    @Column (name = "birth_date")
    private Date birthDate;

    @Column (name = "identity_number")
    private String identityNumber;

    private String address;

    @Column (name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Collection<Payment> paymentId;

    @OneToMany(mappedBy = "customer")
    private Collection<TransactionHistory> historyId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "booking",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private Collection<Job> jobs;

    private enum CustomerType {
        PERSONAL,
        COMPANY,
    }

}

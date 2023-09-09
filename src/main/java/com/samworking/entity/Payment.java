package com.samworking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table (name = "payment")
public class Payment {
    @Id
    private paymentName id;

    @Column(name = "payment_type")
    private paymentType paymentType;

    @Column(name = "payment_name")
    private String paymentName;

    @Column(name = "payment_number")
    private paymentType paymentNumber;

    @Column(name = "cvc")
    private paymentType cvc;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @ManyToOne
    @JoinColumn (name = "payment_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private User users;

    public enum paymentName {
        BIDV, SACOMBANK, TECHCOMBANK
    }

    public enum paymentType {
        CREDITCARD, DEBITCARD, E_WALLET,
    }
}

package com.samworking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class TransactionHistory {
    @Id
    private Long id;

    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "history_id")
    private Customer customer;
}

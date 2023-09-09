package com.samworking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "major")
public class Major {
    @Id
    private Long id;

    @Column (name = "major_name")
    private String majorName;
}

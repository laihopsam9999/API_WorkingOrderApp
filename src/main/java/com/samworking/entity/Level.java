package com.samworking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "level")
public class Level {
    @Id
    private Long id;

    @Column (name = "level_name")
    private String levelName;

    @Column (name = "point")
    private Integer point;


}

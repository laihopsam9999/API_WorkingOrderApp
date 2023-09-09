package com.samworking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "insurance")
public class Insurance {
    @Id
    private Long id;

    @Column (name = "insurance_name")
    private String insuranceName;

    @Column (name = "insurance_type")
    private InsuranceType insuranceType;

    @Column (name = "insurance_company")
    private String insuranceCompany;

    private enum InsuranceType {
        NONCOMPULSORY ,
        COMPULSORY,
    }
}

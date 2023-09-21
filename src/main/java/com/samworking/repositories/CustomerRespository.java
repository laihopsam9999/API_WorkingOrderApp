package com.samworking.repositories;

import com.samworking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRespository extends JpaRepository<Customer, Long> {

}

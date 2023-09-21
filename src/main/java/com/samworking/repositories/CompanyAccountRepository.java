package com.samworking.repositories;

import com.samworking.entity.CompanyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, String> {
    List<CompanyAccount> findByAccountName (String accountName);
}

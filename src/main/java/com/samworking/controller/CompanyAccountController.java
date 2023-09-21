package com.samworking.controller;

import com.samworking.entity.CompanyAccount;
import com.samworking.entity.ResponseObject;
import com.samworking.repositories.CompanyAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CompanyAccountController {

    @Autowired
    CompanyAccountRepository companyAccountRepository;

   @GetMapping("/accounts")
    List<CompanyAccount> getAllAccounts(){
       return companyAccountRepository.findAll();
   }

    @GetMapping("/details/{name}")
    ResponseEntity<ResponseObject> findById (@PathVariable String name) {
       Optional<CompanyAccount> foundCompanyAccount = companyAccountRepository.findById(name);
       return foundCompanyAccount.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
               new ResponseObject("OK", "Query product successfully", foundCompanyAccount)
       ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
               new ResponseObject("KO OK ", "Can not found with Name" + name, null)
       );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject>insertAccounts(@RequestBody CompanyAccount newCompanyAccount) {
       List<CompanyAccount> findByAccountName = companyAccountRepository.findByAccountName(newCompanyAccount.getAccountName().trim());
       if (findByAccountName.size() > 0) {
           return ResponseEntity.status(HttpStatus.OK).body(
                   new ResponseObject("ProductName exists", "failed", null));
       }else {
           return ResponseEntity.status(HttpStatus.OK).body(
                   new ResponseObject("Sign up successfully ", "ok", companyAccountRepository.save(newCompanyAccount)));
       }
    }

    @PutMapping("/update/{name}")
     ResponseEntity<ResponseObject> updateAccount(@PathVariable String name, @RequestBody CompanyAccount newCompanyAccount) {
        CompanyAccount updateAccount = companyAccountRepository.findById(name)
          .map(account -> {
              account.setAccountName(newCompanyAccount.getAccountName());
              return companyAccountRepository.save(account);
          }).orElseGet(()->{
              newCompanyAccount.setAccountName(name);
              return companyAccountRepository.save(newCompanyAccount);
          });
      return ResponseEntity.status(HttpStatus.OK).body(
              new ResponseObject("update successfully", "true", updateAccount)
      );
    }

    @DeleteMapping("/delete")
    ResponseEntity<ResponseObject> deleteById (@PathVariable String name) {
       boolean exists = companyAccountRepository.existsById(name);
       if(exists){
           companyAccountRepository.deleteById(name);
           return ResponseEntity.status(HttpStatus.OK).body(
                   new ResponseObject("Delete Account successfully", "OK", "")
           );
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                   new ResponseObject("Delete account name failed", "failed", "")
           );
       }
    }

}

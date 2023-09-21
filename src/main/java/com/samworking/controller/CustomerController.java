package com.samworking.controller;

import com.samworking.entity.Customer;
import com.samworking.entity.ResponseObject;
import com.samworking.repositories.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRespository customerRespository;

    @GetMapping("/customers")
    List<Customer> getAllCustomers () {
        return customerRespository.findAll();
    }

    @GetMapping("/details/{id}")
    ResponseEntity<ResponseObject> findCustomerById (@PathVariable Long id) {
        Optional<Customer> foundCustomer = customerRespository.findById(id);

        return foundCustomer.isPresent() ? (
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject(" Query product successfully ", "OK", foundCustomer)
                )
                ) : (
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject(" Not found customer with Id: "+ id, "failed", "")
                )
                );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertCustomer (@RequestBody Customer newCustomer) {
        boolean foundCustomers = customerRespository.existsById(newCustomer.getId());
        if (foundCustomers) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("save customer with Id" + newCustomer.getId() + "failed", "failed", "")
            );
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("save successfully", "OK", customerRespository.save(newCustomer))
            );
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> updateCustomer (@PathVariable Long id, @RequestBody Customer newCustomer) {
        Optional<Customer> foundCustomer = customerRespository.findById(id)
        .map(customer->{
            customer.setCustomerName(newCustomer.getCustomerName());
            customer.setCustomerType(newCustomer.getCustomerType());
            customer.setAddress(newCustomer.getAddress());
            customer.setBirthDate(newCustomer.getBirthDate());
            customer.setIdentityNumber(newCustomer.getIdentityNumber());
            customer.setHistoryId(newCustomer.getHistoryId());
            return customerRespository.save(customer);
        });
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("update successfully", "ok", foundCustomer)
        );
    }

    @DeleteMapping("/delete")
    ResponseEntity<ResponseObject> deleteCustomer (@PathVariable Long id) {
        customerRespository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("", "", "")
        );
    }
}

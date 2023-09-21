//package com.example.ApiServer.controllers;
//
//import com.example.ApiServer.models.Product;
//import com.example.ApiServer.models.ResponseObject;
//import com.example.ApiServer.respositories.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path = "/api")
//public class ProductController {
//    // DI: Dependency Injection
//    @Autowired
//    private ProductRepository productRepository;
//
//    @GetMapping("products")
//    List<Product> getAllProducts() {
//        return productRepository.findAll();
//        // you must save this to the Postman, Now we have H2 DB = In-memory Database
//    }
//
//    @GetMapping("details/{id}")
//    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
//        Optional<Product> foundProduct = productRepository.findById(id);
//        return foundProduct.isPresent() ?
//                ResponseEntity.status(HttpStatus.OK).body(
//                        new ResponseObject("ok", "Query product successfully", foundProduct))
//                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                new ResponseObject("false", "Can not find product with Id" + id, null));
//    }
//
//    @PostMapping("/insert")
//    ResponseEntity<ResponseObject> insertProducts(@RequestBody Product newProduct) {
//        List<Product> foundProducts = productRepository.findByProductName(newProduct.getProductName().trim());
//        if (foundProducts.size() > 0) {
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("ProductName exists", "failed", "")
//            );
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("Insert Product successfully", "ok", productRepository.save(newProduct))
//        );
//    }
//
//    @PutMapping("/update/{productId}")
//    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long productId) {
//        Product updateProduct = productRepository.findById(productId)
//                .map(product -> {
//                    product.setProductName(newProduct.getProductName());
//                    product.setProductUrl(newProduct.getProductUrl());
//                    product.setPrice(newProduct.getPrice());
//                    return productRepository.save(product);
//                }).orElseGet(() -> {
//                    newProduct.setProductId(productId);
//                    return productRepository.save(newProduct);
//                });
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("update successfully", "ok", updateProduct)
//        );
//    }
//
//    @DeleteMapping("delete/{productId}")
//    ResponseEntity<ResponseObject> DeleteById(@PathVariable Long productId) {
//        boolean exists = productRepository.existsById(productId);
//        if (exists) {
//            productRepository.deleteById(productId);
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("delete product successfully", "OK", "")
//            );
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                    new ResponseObject("not found product to delete", "failed", "")
//            );
//        }
//    }
//}

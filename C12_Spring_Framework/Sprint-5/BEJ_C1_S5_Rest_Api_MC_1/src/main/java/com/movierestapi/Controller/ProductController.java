package com.movierestapi.Controller;

import com.movierestapi.Domain.Product;
import com.movierestapi.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private IProductService iProductService;

    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/saveProduct-details")
    public ResponseEntity<?> saveProductData(@RequestBody Product product){
        return new ResponseEntity<>(iProductService.saveProductDetails(product), HttpStatus.CREATED);
    }

    @GetMapping("/getProduct-details")
    public ResponseEntity<?> getProductData(){
        return new ResponseEntity<>(iProductService.getProductDetails(),HttpStatus.FOUND);

    }
}

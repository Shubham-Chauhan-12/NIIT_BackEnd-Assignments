package com.sprint1pc1.Controller;

import com.sprint1pc1.Domain.Product;
import com.sprint1pc1.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product/v1")

public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save-products")
    public ResponseEntity<?> saveProductFunction(@RequestBody Product productObj){
        productService.saveProduct(productObj);
        return new ResponseEntity<>("Data-Saved", HttpStatus.CREATED);
    }

    @GetMapping("/get-product/{pid}")
    public ResponseEntity<?> fetchProductByIdFunction(@PathVariable int pid ){
        return new ResponseEntity<>(productService.productById(pid),HttpStatus.OK);
    }


    @GetMapping("/get-products")
    public ResponseEntity<?> fetchAllProductsFunction(){
        return new ResponseEntity<>(productService.fetchAllProduct(),HttpStatus.FOUND);
    }


    @DeleteMapping("/delete-products/{pid}")
    public ResponseEntity<?> deleteProductByIdFunction(@PathVariable int pid){
        productService.deleteProduct(pid);
        return new ResponseEntity<>("Data-Deleted Successfully",HttpStatus.OK);
    }


}

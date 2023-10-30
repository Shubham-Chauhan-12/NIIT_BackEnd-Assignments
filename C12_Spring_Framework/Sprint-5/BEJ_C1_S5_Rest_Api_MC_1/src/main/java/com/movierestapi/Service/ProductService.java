package com.movierestapi.Service;

import com.movierestapi.Domain.Product;
import com.movierestapi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProductDetails(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductDetails(){
        return (List<Product>) productRepository.findAll();
    }

}

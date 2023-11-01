package com.sprint1pc1.Services;

import com.sprint1pc1.Domain.Product;
import com.sprint1pc1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(int productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public List<Product> fetchAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> productById(int productId) {
        return productRepository.findById(productId);
    }
}

package com.sprint1pc1.Services;

import com.sprint1pc1.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public Product saveProduct(Product product);
    public boolean deleteProduct(int productId);
    public List<Product> fetchAllProduct();
    public Optional<Product> productById(int productId);
}

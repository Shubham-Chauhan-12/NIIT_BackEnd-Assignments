package com.movierestapi.Service;

import com.movierestapi.Domain.Product;

import java.util.List;

public interface IProductService {

    public Product saveProductDetails(Product product);
    public List<Product> getProductDetails();
}

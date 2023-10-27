package org.productinfo.config;

import org.productinfo.domain.Product;
import org.springframework.context.annotation.Bean;

public class productConfig {

    @Bean("product1")
    public Product getProduct1(){
        return new Product(101,"Realme neckband","Wireless Audio",3499.00,4.5f);
    }

    @Bean("product2")
    public Product getProduct2(){
        return new Product(102,"Boat wired 100","Wired",349.00,4.0f);
    }

    @Bean("product3")
    public Product getProduct3(){
        return new Product(103,"Blaupunkt Charger","Wired-type",599.00,4.3f);
    }

    @Bean("product4")
    public Product getProduct4(){
        return new Product(104,"Logitech cam 235","Webcam",2499.00,4.9f);
    }
}

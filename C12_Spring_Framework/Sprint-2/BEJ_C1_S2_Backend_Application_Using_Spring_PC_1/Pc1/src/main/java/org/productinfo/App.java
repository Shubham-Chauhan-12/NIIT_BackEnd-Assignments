package org.productinfo;

import org.productinfo.config.productConfig;
import org.productinfo.domain.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(productConfig.class);

        Product prod1=(Product) context.getBean("product1");
        System.out.println("Product Details : "+ prod1);

        Product prod2=(Product) context.getBean("product2");
        System.out.println("Product Details : "+ prod2);

        Product prod3=(Product) context.getBean("product3");
        System.out.println("Product Details : "+ prod3);

        Product prod4=(Product) context.getBean("product4");
        System.out.println("Product Details : "+ prod4);

    }
}

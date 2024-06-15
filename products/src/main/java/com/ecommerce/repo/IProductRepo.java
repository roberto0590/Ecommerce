package com.ecommerce.repo;

import com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepo extends IGenericRepo<Product, Integer>{
    @Query("SELECT p FROM Product p WHERE p.idProduct = ?1")
    public Product findByProduct(Integer product);
    @Query("SELECT p FROM Product p WHERE p.idProduct = ?1 or p.title = ?2")
    public Product findByProductOrTitle(Integer product,String title);
}

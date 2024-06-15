package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Balance;
import com.ecommerce.entity.Product;

import java.util.List;


public interface IProductService extends ICRUD<Product, Integer> {
    public Product findByProduct(Integer product);
    public List<Product> findAllProducts();
    public List<ProductDTO> findAllProductsAnSaveBD();
    public ProductDTO findByProductIdOrTitle(Integer product, String title);
}

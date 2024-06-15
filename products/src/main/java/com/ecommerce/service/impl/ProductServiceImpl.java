package com.ecommerce.service.impl;

import com.ecommerce.client.ProductFeignClient;
import com.ecommerce.dto.ProductDTO;
//import com.ecommerce.dto.ProductMapper;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repo.IProductRepo;
import com.ecommerce.service.IProductService;
import com.ecommerce.repo.IGenericRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {

	@Autowired
	private IProductRepo repoProduct;
	@Autowired
	private ProductFeignClient productFeignClient;

	@Override
	protected IGenericRepo<Product, Integer> getRepo() {
		return repoProduct;
	}

	public Product findByProduct(Integer product){
		Product prod = repoProduct.findByProduct(product);
		return prod;
	}

	public ProductDTO findByProductIdOrTitle(Integer product, String title){
		Product prod = repoProduct.findByProductOrTitle(product,title);
		ProductDTO productDTO = ProductMapper.mapper.productToProductDto(prod);

		return productDTO;
	}

	public List<Product> findAllProducts(){
		List<Product> products = productFeignClient.getProducts();
		return products;
	}
	public List<ProductDTO> findAllProductsAnSaveBD(){
		List<Product> products = productFeignClient.getProducts();
		repoProduct.deleteAll();
		repoProduct.saveAll(products);
		List<ProductDTO> productsDTO = products.stream().map(product -> ProductMapper.mapper.productToProductDto(product)).collect(Collectors.toList());
		return productsDTO;
	}
}

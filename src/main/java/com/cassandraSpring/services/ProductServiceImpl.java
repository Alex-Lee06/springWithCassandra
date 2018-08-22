package com.cassandraSpring.services;

import com.cassandraSpring.commands.ProductForm;
import com.cassandraSpring.converters.ProductFormToProduct;
import com.cassandraSpring.domain.Product;
import com.cassandraSpring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct){
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<Product> listAll(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(UUID id){
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product product){
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(UUID id){
        productRepository.deleteById(id);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm){
        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}

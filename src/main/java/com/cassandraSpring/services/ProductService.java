package com.cassandraSpring.services;

import com.cassandraSpring.commands.ProductForm;
import com.cassandraSpring.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> listAll();

    Product getById(UUID id);

    Product saveOrUpdate(Product product);

    void delete(UUID id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}

package com.adminPanel.app.service;

import com.adminPanel.app.exception.BadRequestException;
import com.adminPanel.app.exception.ProductExceptionHandler;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
     void deleteById(int id);
    ProductDetails insert(ProductDetails productDetails) throws BadRequestException;
    Product findById(int id)throws ProductExceptionHandler;
    ProductDetails update(ProductDetails productDetails);
    ProductDetails findByProductId(int id);
     List<Product>findByName(String c);
}

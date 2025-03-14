package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.exception.BadRequestException;
import com.adminPanel.app.exception.ProductExceptionHandler;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Component
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Transactional
    @Override
    public List<Product> getAllProducts() {
        try {

            return productDAO.getAllProducts();
        }catch (Exception exception)
        {
            System.out.println("hello from catch in service");
            exception.printStackTrace();
        }
        return null;
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        try {
            System.out.println("hello from try in  delete service");
            productDAO.deleteById(id);
            System.out.println("hello from try in  after delete service");
        }catch (Exception exception)
        {
            System.out.println("hello from catch in  delete service");
            exception.printStackTrace();
        }


    }
    @Transactional
    @Override
    public ProductDetails insert(ProductDetails productDetails) throws BadRequestException {
        if ((!productDetails.getName().isEmpty())) {
            return productDAO.insert(productDetails);
        }
      else
          throw new  BadRequestException("there is missing data ");
    }
    @Transactional
    @Override
    public Product findById(int id) throws ProductExceptionHandler {
        if (id <= 0)
        {
            throw new ProductExceptionHandler("must be positive");
        }

       else{
            Product product=productDAO.findById(id);
            if(product==null)
                throw new ProductExceptionHandler("no product with id = "+id);
            else
                return product;
        }

    }
    @Transactional
    @Override
    public ProductDetails update(ProductDetails productDetails) {
        try {
            System.out.println("hello from update in service");

          //  ProductDetails oldproductDetails =productDAO.findByProductId(oldproductDetails.getId());
            return productDAO.update(productDetails);
           // System.out.println(productDetails);//done
            //return productDAO.update(productDetails);

        }catch (Exception exception)
        {
            System.out.println("hello from catch update in service");
            exception.printStackTrace();
        }
        return null;
    }


    @Transactional
    @Override
    public ProductDetails findByProductId(int id) {
        try {
            System.out.println("hello from try in  findByProductId service");
            return productDAO.findByProductId(id);

        }catch (Exception exception)
        {
            System.out.println("hello from catch in findByProductId service");
            exception.printStackTrace();
        }
        return null;
    }
    @Transactional
    public List<Product> findByName(String c) {
        try {
            System.out.println("hello from search service try");

            return productDAO.findByName(c);

        }catch (Exception exception)
        {
            System.out.println("hello from search service catch");

            exception.printStackTrace();
        }
        return null;
    }
}

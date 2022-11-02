package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    
    ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo){
        this.repo = repo;
    }
 
    public List<Product> getAllProducts(){
        return repo.findAll();
    }
    public ProductType getProductType(String typeName) {
        return repo.findProductTypeByName(typeName);
    }
    public List<Product> getProductsCheaperThan(double price) {
        return repo.findAllProductsCheaper(price);
    }
    public Product save(Product p){
        return repo.save(p);       
    }
    public List<ProductType> findAllProductTypes(){
        return repo.findAllProductTypes();
    }
   /*
    public List<Product> getProductsCheaperThan(double price) {
        return null;
    }

    public ProductType getProductType(String typeName) {
        return null;
    }

   
    */
    
}

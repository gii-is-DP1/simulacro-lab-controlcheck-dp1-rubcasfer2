package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    
    List<Product> findAll();
    @Query("SELECT pt from ProductType pt")
    List<ProductType> findAllProductTypes();
    @Query("Select pt from ProductType pt where pt.name = ?1")
    ProductType findProductTypeByName(String name);
    @Query("SELECT p from Product p where p.price < ?1")
    List<Product> findAllProductsCheaper(Double price);
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
     
}

package hle.lib.crsj.dao;

import hle.lib.crsj.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByProductName(String productName);
}

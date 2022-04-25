package cub.lib.crsj.controllers;

import cub.lib.crsj.dao.ProductRepository;
import cub.lib.crsj.dto.PostProduct;
import cub.lib.crsj.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/byname")
    Product getProductByName(@RequestParam String name) {
        return productRepository.findProductByProductName(name);
    }

    @PostMapping
    Product createProduct(@RequestBody PostProduct newProduct) {
        var product = new Product();
        product.setProductName(newProduct.getName());
        product.setCategory(newProduct.getCategory());
        product.setImageUrl(newProduct.getImageUrl());
        product.setPrice(newProduct.getPrice());
        product.setStock(newProduct.getStock());
        product.setDescription(newProduct.getDescription());

        Instant now = Instant.now();
        product.setCreatedDate(now);
        product.setLastModifiedDate(now);

        return productRepository.save(product);
    }
}

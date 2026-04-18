package com.gcu;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gcu.business.ProductsBusinessService;
import com.gcu.model.ProductModel;

@RestController
@RequestMapping("/service")
public class ProductsRestController {

    private final ProductsBusinessService productsBusinessService;

    public ProductsRestController(ProductsBusinessService productsBusinessService) {
        this.productsBusinessService = productsBusinessService;
    }

    @GetMapping("/products")
    public List<ProductModel> getAllProducts() {
        return productsBusinessService.getProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable int id) {
        ProductModel product = productsBusinessService.getProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }
}
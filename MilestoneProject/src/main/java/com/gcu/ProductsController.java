package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.business.ProductsBusinessService;
import com.gcu.model.ProductModel;

/**
 * This controller displays product pages and handles creation
 * of new products.
 */
@Controller
public class ProductsController {

    private final ProductsBusinessService productsBusinessService;

    public ProductsController(ProductsBusinessService productsBusinessService) {
        this.productsBusinessService = productsBusinessService;
    }

    /**
     * Displays the form for adding a new product.
     *
     * @param model the model used to pass an empty product object to the view
     * @return the new product form view
     */
    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new ProductModel());
        return "product-form";
    }

    /**
     * Processes the submitted product form and saves the new product.
     *
     * @param product the product entered by the user
     * @return redirect to the home page after the product is saved
     */
    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute("product") ProductModel product) {
        productsBusinessService.createProduct(product);
        return "redirect:/home";
    }

    /**
     * Displays all products.
     *
     * @param model the model used to pass product data to the view
     * @return the products page view
     */
    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productsBusinessService.getProducts());
        return "products";
    }
}
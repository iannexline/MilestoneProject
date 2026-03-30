package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    /**
     * Handles GET request to display the edit product form.
     * Retrieves the product by its ID and adds it to the model so the form can be pre-filled with existing data.
     *
     * @param id the ID of the product to edit
     * @param model the Model object used to pass data to the view
     * @return the name of the edit product form view
     */
    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") int id, Model model) {
        ProductModel product = productsBusinessService.getProductById(id);
        model.addAttribute("product", product);
        return "product-edit-form";
    }
    
    /**
     * Handles POST request to update an existing product.
     * Receives the updated product data from the form and calls the business service to save the changes.
     *
     * @param product the ProductModel object containing updated data
     * @return redirect to the products list page after update
     */
    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute("product") ProductModel product) {
        productsBusinessService.updateProduct(product);
        return "redirect:/products";
    }

    /**
     * Handles GET request to delete a product by its ID.
     * Calls the business service to remove the product and then redirects back to the product list.
     *
     * @param id the ID of the product to delete
     * @return redirect to the products list page after deletion
     */
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productsBusinessService.deleteProduct(id);
        return "redirect:/products";
    }
}
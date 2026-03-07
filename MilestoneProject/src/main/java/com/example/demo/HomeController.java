package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.ProductsBusinessService;
import com.gcu.model.ProductModel;

@Controller
public class HomeController {
	
	private final ProductsBusinessService productsBusinessService;
	
	public HomeController(ProductsBusinessService productsBusinessService) {
		this.productsBusinessService = productsBusinessService;
	}

    @GetMapping("/home")
    public String showHomePage(Model model) {
    	List<ProductModel> products = productsBusinessService.getProducts();
    	model.addAttribute("products",products);
    	return "home";
    }
}
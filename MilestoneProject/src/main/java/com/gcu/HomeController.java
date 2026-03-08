package com.gcu;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.business.ProductsBusinessService;
import com.gcu.model.ProductModel;

/**
 * This controller retrieves product data from the business service layer and sends it to the view so that the products can be displayed on the home page using Thymeleaf.
 * It also retrieves session information to display the logged in user's username on the page. 
 */
@Controller
public class HomeController {
	
	private final ProductsBusinessService productsBusinessService;
	
	public HomeController(ProductsBusinessService productsBusinessService) {
		this.productsBusinessService = productsBusinessService;
	}

	/**
	 * This method retrieves the username from the HTTP session and retrieves the list of products from the business service layer.
	 * The data is then passed to the view for display.
	 * @param model The model used to pass product data to the view.
	 * @return the home page view
	 */
    @GetMapping("/home")
    public String showHomePage(Model model) {
    	List<ProductModel> products = productsBusinessService.getProducts();
    	model.addAttribute("products",products);
    	return "home";
    }
}
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class CarsController {
	
	@GetMapping(value = "/")
	public String getHomePage() {
		return "index.html";
	}
	
	@GetMapping(value = "/searchByBrand")
	public String getSearchByBrandPage() {
		return "userSelectedBrand.html";
	}
	
	@GetMapping(value = "/carsSearchResult")
	public String getCarSearchResult() {
		return "carsSearchResult.html";
	}
	
	@GetMapping(value = "/userSelectedBrand")
	public String getuserSelectedBrandPage() {
		return "userSelectedBrand.html";
	}
	
	@GetMapping(value = "/userSelectedPrice")
	public String getuserSelectedPricePage() {
		return "userSelectedPrice.html";
	}
	

}

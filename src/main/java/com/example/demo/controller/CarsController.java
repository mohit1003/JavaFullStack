package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationTemp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.CarsModel;
import com.example.demo.service.CarService;

@Controller
public class CarsController {
	
	@Autowired
	private CarService service;
	
	@GetMapping(value = "/")
	public String getHomePage() {
		return "index.html";
	}
	
	@RequestMapping(value = "/searchByBrandResp", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<CarsModel> getSearchByBrandPageResponse() {
		return service.findByCarPriceMoreThan5L();
	}
	
	@GetMapping(value = "/searchByBrand")
	public String getSearchByBrandPage() {
		List<String> brandList = service.getCarManufacturerList();
		return "userSelectedBrand.html";
	}
	
	@GetMapping(value = "/carsSearchResult")
	public String getCarSearchResult() {
		List<CarsModel> carsModels = service.findByBrandName("Tata");
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

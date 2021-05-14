package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationTemp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.CarsModel;
import com.example.demo.service.CarService;
import com.sun.istack.NotNull;

@Controller
public class CarsController {
	
	@Autowired
	private CarService service;
	
	private List<CarsModel> carResult;
	
	@GetMapping(value = "/")
	public String getHomePage(Model m) {
		return "index.html";
	}
	
	@RequestMapping(value = "/searchByBrandResp", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<CarsModel> getSearchByBrandPageResponse() {
		return service.findByCarPriceMoreThan5L();
	}
	
	@GetMapping(value = "/searchByBrand")
	public String getSearchByBrandPage(Model carManufacturers) {
//		carManufacturers.addAttribute("brand", new String());
		carManufacturers.addAttribute("carManufacturers", new HashSet<>(service.getCarManufacturerList()));
		return "userSelectedBrand.html";
	}
	
	@GetMapping(value = "/carsSearchResult")
	public String getCarSearchResult(@Valid @NotEmpty(message = "Brand cannot be empty") String brand, Model selectedBrandCars) {
		if(brand == null || brand.equals("0")) {
			selectedBrandCars.addAttribute("carManufacturers", new HashSet<>(service.getCarManufacturerList()));
			selectedBrandCars.addAttribute("error", "Please select an option");
			return "userSelectedBrand.html";
		}
		List<CarsModel> carsModels = service.findByBrandName(brand);
		carResult = new ArrayList<>();
		carResult = carsModels;
		selectedBrandCars.addAttribute("selectedBrandCars", carsModels);
		return "carsSearchResult.html";
	}
	
	@GetMapping(value = "/carsSearchResultPrice")
	public String getCarSearchResultPrice(@Valid String price, Model selectedBrandCars) {
		carResult = new ArrayList<>();
		if(selectedBrandCars.containsAttribute("error")) {
			selectedBrandCars = null;
		}
		if(price == null) {
			selectedBrandCars.addAttribute("error", "Please select an option");
			return "userSelectedPrice.html";
		}
		if(price.equalsIgnoreCase("gt5")) {
			carResult = service.findByCarPriceMoreThan5L();
			selectedBrandCars.addAttribute("selectedBrandCars", carResult);
		}
		else {
			carResult = service.findByCarPriceLessThan5L();
			selectedBrandCars.addAttribute("selectedBrandCars", carResult);
		}
		

		
		return "carsSearchResult.html";
	}
	
	@GetMapping(value = "/userSelectedBrand")
	public String getuserSelectedBrandPage() {
		return "userSelectedBrand.html";
	}
	
	@GetMapping(value = "/searchByPrice")
	public String getuserSelectedPricePage( Model m) {
		m.addAttribute("price", "");
		return "userSelectedPrice.html";
	}
	
	@GetMapping(value = "/bookingConfirm")
	public String bookingDone(@Valid String id, Model m) {
		System.out.println("+++++++++++ "+id);
		if(id == null) {
			m.addAttribute("error", "Please select an Option");
			m.addAttribute("selectedBrandCars", carResult);
			return "carsSearchResult.html";
		}
		return "bookingconfirm.html";
	}
	

}

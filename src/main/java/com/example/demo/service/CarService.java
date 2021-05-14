package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.CarsModel;
import com.example.demo.repo.CarsRepository;

@Service
public class CarService {
	
	@Autowired
	private CarsRepository carsRepository;
	
	public List<String> getCarManufacturerList() {
		return carsRepository.getCarManufacturers();
	}
	
	public List<CarsModel> findByBrandName(String brand) {
		return carsRepository.findByBrand(brand);
	}
	
	public List<CarsModel> findByCarPriceLessThan5L() {
		return carsRepository.findByPriceLessThan5L();
	}
	
	public List<CarsModel> findByCarPriceMoreThan5L() {
		return carsRepository.findByPriceLMoreThan5L();
	}
	
}

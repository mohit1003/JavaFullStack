package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.CarsModel;

public interface CarsRepository extends JpaRepository<CarsModel, String> {
	
	@Query(value = "select brand from CARS_MODEL", nativeQuery = true)
	public List<String> getCarManufacturers();
	
	public List<CarsModel> findByBrand(String brand);
	
	@Query(value = "select * from CARS_MODEL where price <= 500000", nativeQuery = true)
	public List<CarsModel> findByPriceLessThan5L();
	
	@Query(value = "select * from CARS_MODEL where price > 500000", nativeQuery = true)
	public List<CarsModel> findByPriceLMoreThan5L();
}

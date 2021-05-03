package com.example.demo.model;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Entity
public class CarsModel {
	@javax.persistence.Id
	private String Id;
	
	private String brand;
	private String model;
	@Pattern(regexp = "^\\d{4}$")
	private String year;
	private int noOfKM;
	private String price;
	@Pattern(regexp = "(petrol|diesel)")
	private String fuel;
	public CarsModel(String id, String brand, String model, @Pattern(regexp = "^\\d{4}$") String year, int noOfKM,
			String price, @Pattern(regexp = "(petrol|diesel)") String fuel) {
		super();
		Id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.noOfKM = noOfKM;
		this.price = price;
		this.fuel = fuel;
	}
	public CarsModel() {
		super();
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getNoOfKM() {
		return noOfKM;
	}
	public void setNoOfKM(int noOfKM) {
		this.noOfKM = noOfKM;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	
	
	

	

}

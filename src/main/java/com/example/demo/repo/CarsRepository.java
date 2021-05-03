package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CarsModel;

public interface CarsRepository extends JpaRepository<CarsModel, String> {

}

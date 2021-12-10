package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.FoodDTO;

@Repository
public interface FoodRepo extends JpaRepository<FoodDTO, Long> {

	FoodDTO findTitleByFoodName(String foodName);
}
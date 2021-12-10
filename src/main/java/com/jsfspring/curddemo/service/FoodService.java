
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.FoodUITO;

public interface FoodService {

	List<FoodUITO> getAllFood();

	FoodUITO getFood(FoodUITO foodUITO);

}
/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jsfspring.curddemo.entity.FoodDTO;
import com.jsfspring.curddemo.repositry.FoodRepo;
import com.jsfspring.curddemo.service.FoodService;
import com.jsfspring.curddemo.uito.FoodUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodRepo foodRepo;

	@Override
	public List<FoodUITO> getAllFood() {
		List<FoodUITO> foodUITOLst = new ArrayList<>();
		List<FoodDTO> foodDTOLst = foodRepo.findAll();

		foodDTOLst.forEach(dto -> {
			FoodUITO tmpUiTO = new FoodUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			foodUITOLst.add(tmpUiTO);
		});

		return foodUITOLst;
	}

	@Override
	public FoodUITO getFood(FoodUITO foodUITO) {
		System.out.println(">>>>> "+foodUITO.getFoodName());
		FoodDTO dto = foodRepo.findTitleByFoodName(foodUITO.getFoodName());
		FoodUITO uito = new FoodUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}
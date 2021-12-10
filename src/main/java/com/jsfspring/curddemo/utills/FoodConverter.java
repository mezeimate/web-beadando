package com.jsfspring.curddemo.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.jsfspring.curddemo.uito.FoodUITO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.curddemo.service.FoodService;

@Service
public class FoodConverter implements Converter {

	@Autowired
	private FoodService foodService;

	private static final Logger LOG = LoggerFactory.getLogger(FoodConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + foodService);

		FoodUITO foodUITO = new FoodUITO();
		foodUITO.setFoodName(string);
		foodUITO = foodService.getFood(foodUITO);
		System.out.println(foodUITO.toString());
		return foodUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof FoodUITO) {
			FoodUITO dept = (FoodUITO) obj;
			LOG.info("getAsString def name: " + dept.getFoodName());
			return dept.getFoodName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of FoodUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}
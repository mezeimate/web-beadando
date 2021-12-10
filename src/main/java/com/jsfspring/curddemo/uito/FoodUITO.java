package com.jsfspring.curddemo.uito;

import java.io.Serializable;
import java.util.List;

public class FoodUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long foodId;
	private String foodName;
	private List<OrderUITO> orderUITOLst;

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public List<OrderUITO> getOrderUITOLst() {
		return orderUITOLst;
	}

	public void setOrderUITOLst(List<OrderUITO> orderUITOLst) {
		this.orderUITOLst = orderUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodUITO other = (FoodUITO) obj;
		if (foodId == null) {
			if (other.foodId != null)
				return false;
		} else if (!foodId.equals(other.foodId))
			return false;
		return true;
	}

}

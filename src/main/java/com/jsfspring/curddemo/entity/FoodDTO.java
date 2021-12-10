package com.jsfspring.curddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "FOOD_MASTER")
public class FoodDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FOOD_ID")
	private Long foodId;
	@Column(name = "FOOD_Name")
	private String foodName;

	@OneToMany(mappedBy = "foodDTO")
	private List<OrderDTO> orderdtolst;

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

	public List<OrderDTO> getOrderdtolst() {
		if (null == orderdtolst) {
			orderdtolst = new ArrayList<>();
		}
		return orderdtolst;
	}

	public void setOrderdtolst(List<OrderDTO> employeedtolst) {
		this.orderdtolst = employeedtolst;
	}
}

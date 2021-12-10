/**
 * 
 */
package com.jsfspring.curddemo.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class OrderUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840260415183676656L;
	private Long orderId;
	private String orderName;
	private String password;
	private String address1;
	private String emailId;
	private FoodUITO foodUITO;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public FoodUITO getFoodUITO() {
		return foodUITO;
	}

	public void setFoodUITO(FoodUITO foodUITO) {
		this.foodUITO = foodUITO;
	}

	@Override
	public String toString() {
		return "EmployeeUITO [empId=" + orderId + ", empName=" + orderName + ", password=" + password + ", address1="
				+ address1 + ", emailId=" + emailId + ", departmentUITO=" + foodUITO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderName == null) ? 0 : orderName.hashCode());
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
		OrderUITO other = (OrderUITO) obj;
		if (orderName == null) {
			if (other.orderName != null)
				return false;
		} else if (!orderName.equals(other.orderName))
			return false;
		return true;
	}

}

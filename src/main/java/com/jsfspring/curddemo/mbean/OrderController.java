/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import com.jsfspring.curddemo.uito.FoodUITO;
import com.jsfspring.curddemo.uito.OrderUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.service.FoodService;
import com.jsfspring.curddemo.service.OrderService;

@Controller("orderController")
@SessionScope
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private FoodService foodService;

	private String actionLabel;
	private OrderUITO orderUiTO;
	private List<OrderUITO> orderUiToList;

	private List<FoodUITO> foodUiToList;

	/**
	 * add or update new Record in DB
	 * 
	 * @return
	 */
	public void doSaveInfoOrder() {
		System.out.println(this.getOrderUiTO());
		orderService.doSaveOrder(this.getOrderUiTO());
		getAllOrder();
		this.setOrderUiTO(new OrderUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Order Details", "Order Details added/Updated Successfully."));

	}

	/**
	 * Default load all the Order info
	 */
	@PostConstruct
	public void getAllOrder() {
		if (!this.getOrderUiToList().isEmpty()) {
			this.getOrderUiToList().clear();
			this.getFoodUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + orderService);
		this.getOrderUiToList().addAll(orderService.doFetchAllOrder());
		this.getFoodUiToList().addAll(foodService.getAllFood());
		this.setActionLabel("Add");
	}

	/**
	 * Remove selected Order info
	 * 
	 * @return
	 */

	public void deleteOrder(OrderUITO orderUiTO) {
		orderService.doDeleteOrder(orderUiTO);
		getAllOrder();
	}

	public void editOrder(OrderUITO orderUiTO) {
		this.setActionLabel("Update");
		BeanUtils.copyProperties(orderUiTO, this.getOrderUiTO());
		System.out.println(this.getOrderUiTO());
	}

	public OrderUITO getOrderUiTO() {
		if (orderUiTO == null) {
			orderUiTO = new OrderUITO();
		}
		return orderUiTO;
	}

	public void setOrderUiTO(OrderUITO orderUiTO) {
		this.orderUiTO = orderUiTO;
	}

	public List<OrderUITO> getOrderUiToList() {
		if (null == orderUiToList) {
			orderUiToList = new ArrayList<>();
		}
		return orderUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<FoodUITO> getFoodUiToList() {
		if (foodUiToList == null) {
			foodUiToList = new ArrayList<>();
		}
		return foodUiToList;
	}

	public void setFoodUiToList(List<FoodUITO> foodUiToList) {
		this.foodUiToList = foodUiToList;
	}
}
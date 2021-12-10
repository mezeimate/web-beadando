
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.OrderUITO;

public interface OrderService {
	OrderUITO doSaveOrder(OrderUITO orderUiTO);

	List<OrderUITO> doFetchAllOrder();

	OrderUITO doGetOrder(OrderUITO orderUiTO);

	void doDeleteOrder(OrderUITO orderUiTO);
}
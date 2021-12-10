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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.FoodDTO;
import com.jsfspring.curddemo.entity.OrderDTO;
import com.jsfspring.curddemo.repositry.OrderRepo;
import com.jsfspring.curddemo.service.OrderService;
import com.jsfspring.curddemo.uito.FoodUITO;
import com.jsfspring.curddemo.uito.OrderUITO;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepo orderRepo;

	@Override
	@Transactional(readOnly = false)
	public OrderUITO doSaveOrder(OrderUITO orderUiTO) {
		OrderDTO dto = UiToToDto(orderUiTO);
		dto = orderRepo.save(dto);
		BeanUtils.copyProperties(dto, orderUiTO);

		dtoToUito(orderUiTO, dto);
		return orderUiTO;
	}

	private void dtoToUito(OrderUITO employeeUiTO, OrderDTO dto) {
		FoodUITO uitTO = new FoodUITO();
		BeanUtils.copyProperties(dto.getFoodDTO(), uitTO);
		employeeUiTO.setFoodUITO(uitTO);
	}

	private OrderDTO UiToToDto(OrderUITO orderUiTO) {
		OrderDTO dto = new OrderDTO();
		FoodDTO foodDto = new FoodDTO();
		BeanUtils.copyProperties(orderUiTO, dto);
		BeanUtils.copyProperties(orderUiTO.getFoodUITO(), foodDto);
		dto.setFoodDTO(foodDto);
		List<OrderDTO> lst = new ArrayList<>();
		lst.add(dto);
		foodDto.getOrderdtolst().addAll(lst);
		return dto;
	}

	@Override
	public List<OrderUITO> doFetchAllOrder() {
		List<OrderDTO> dtoLst = orderRepo.findAll();
		List<OrderUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			OrderUITO tmpUiTO = new OrderUITO();
			System.out.println(dto.getFoodDTO());
			BeanUtils.copyProperties(dto, tmpUiTO);

			dtoToUito(tmpUiTO, dto);
			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public OrderUITO doGetOrder(OrderUITO orderUiTO) {
		if (null != orderUiTO.getEmailId()) {
			OrderDTO dto = new OrderDTO();

			BeanUtils.copyProperties(orderUiTO, dto);
			dto = orderRepo.getOne(dto.getOrderId());

			BeanUtils.copyProperties(dto, orderUiTO);
		}
		return orderUiTO;
	}

	@Override
	@Transactional
	public void doDeleteOrder(OrderUITO employeeUiTO) {
		orderRepo.deleteById(employeeUiTO.getOrderId());
	}

}
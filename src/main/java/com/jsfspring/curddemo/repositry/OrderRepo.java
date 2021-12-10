package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.OrderDTO;

@Repository
public interface OrderRepo extends JpaRepository<OrderDTO, Long> {
}
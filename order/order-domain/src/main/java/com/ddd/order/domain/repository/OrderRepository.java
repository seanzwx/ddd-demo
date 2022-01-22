package com.ddd.order.domain.repository;

import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.model.OrderProduct;

import java.util.List;

public interface OrderRepository
{
	public void saveOrder(Order order);

	public void saveOrderProduct(long orderId, OrderProduct product);

	public Order getOrder(long orderId);

	public List<OrderProduct> getOrderProduct(long orderId);
}
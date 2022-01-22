package com.ddd.order.repository;

import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.model.OrderProduct;
import com.ddd.order.domain.repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository
{
	@Override
	public void saveOrder(Order order)
	{
	}

	@Override
	public void saveOrderProduct(long orderId, OrderProduct product)
	{
	}

	@Override
	public Order getOrder(long orderId)
	{
		return null;
	}

	@Override
	public List<OrderProduct> getOrderProduct(long orderId)
	{
		return null;
	}
}
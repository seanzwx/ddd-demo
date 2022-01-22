package com.ddd.order.domain.repository;

import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.model.OrderProduct;

import java.util.LinkedList;
import java.util.List;

public class OrderRepositoryMock implements OrderRepository
{
	@Override
	public void saveOrder(Order order)
	{
		order.orderId = 1;
	}

	@Override
	public void saveOrderProduct(long orderId, OrderProduct product)
	{
		product.productId = 1;
	}

	@Override
	public Order getOrder(long orderId)
	{
		Order order = new Order();
		order.userId = 1;
		order.orderId = orderId;
		order.phone = "15980546806";
		order.status = "待发货";
		return order;
	}

	@Override
	public List<OrderProduct> getOrderProduct(long orderId)
	{
		List<OrderProduct> orderProductList = new LinkedList<>();

		OrderProduct product = new OrderProduct();
		product.productId = 1;
		product.num = 1;
		orderProductList.add(product);

		return orderProductList;
	}
}

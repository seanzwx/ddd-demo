package com.ddd.order.domain.repository;

import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.model.OrderProduct;

import java.util.List;

public interface OrderRepository
{
	/**
	 * 保存订单
	 * @param order
	 */
	void saveOrder(Order order);

	/**
	 * 保存订单商品
	 * @param orderId
	 * @param product
	 */
	void saveOrderProduct(long orderId, OrderProduct product);

	/**
	 * 获取订单
	 * @param orderId
	 * @return
	 */
	Order getOrder(long orderId);

	/**
	 * 获取订单商品列表
	 * @param orderId
	 * @return
	 */
	List<OrderProduct> getOrderProduct(long orderId);
}
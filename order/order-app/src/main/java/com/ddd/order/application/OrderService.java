package com.ddd.order.application;

import com.ddd.order.domain.dto.AddressDTO;
import com.ddd.order.domain.dto.CartProductDTO;
import com.ddd.order.domain.model.Order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService
{
	/**
	 * 创建订单
	 *
	 * @param userId
	 * @param productList
	 * @param address
	 * @return
	 */
	@Transactional
	public long create(long userId, List<CartProductDTO> productList, AddressDTO address) throws Exception
	{
		Order order = Order.create(userId, productList, address);
		return order.orderId;
	}

	/**
	 * 供应商发货
	 *
	 * @param orderId
	 */
	@Transactional
	public void send(long orderId) throws Exception
	{
		Order order = Order.get(orderId);
		order.send();
	}

	/**
	 * 确认收货
	 *
	 * @param orderId
	 * @param rate
	 */
	@Transactional
	public void recieve(long orderId, int rate) throws Exception
	{
		Order order = Order.get(orderId);
		order.receive(rate);
	}
}

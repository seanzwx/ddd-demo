package com.ddd.order.domain.repository;

import com.ddd.order.domain.model.AddressInfo;
import com.ddd.order.domain.model.Buyer;
import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.model.OrderProduct;
import com.ddd.order.domain.model.Saler;

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
		Buyer buyer = new Buyer();
		buyer.userId = 1;
		buyer.addressInfo = new AddressInfo();
		buyer.addressInfo.name = "张三";
		buyer.addressInfo.phone = "15980546806";
		buyer.addressInfo.address = "福建省福州市";

		Saler saler = new Saler();
		saler.salerId = 1;
		saler.addressInfo = new AddressInfo();
		saler.addressInfo.name = "福州旗舰店";
		saler.addressInfo.phone = "15980546806";
		saler.addressInfo.address = "福建省福州市民后县";

		Order order = new Order();
		order.orderId = orderId;
		order.status = "待发货";
		order.buyer = buyer;
		order.saler = saler;
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

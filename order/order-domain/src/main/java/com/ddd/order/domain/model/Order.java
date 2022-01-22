package com.ddd.order.domain.model;

import com.ddd.order.domain.dto.AddressDTO;
import com.ddd.order.domain.dto.CartProductDTO;
import com.ddd.order.domain.repository.Factory;
import com.netsky.ddd.common.BusinessException;
import com.netsky.ddd.common.DtoUtil;

import java.util.LinkedList;
import java.util.List;

public class Order
{
	public long orderId;
	public String status;

	public Saler saler;
	public Buyer buyer;

	public List<OrderProduct> productList;

	/**
	 * 创建订单
	 * @param userId
	 * @param productList
	 * @param address
	 * @return
	 * @throws BusinessException
	 */
	public static Order create(long userId, List<CartProductDTO> productList, AddressDTO address) throws BusinessException
	{
		// 检查库存
		for (CartProductDTO it : productList)
		{
			if (it.num > Factory.getApiRepository().getWarehouseProductNum(it.productId))
			{
				throw new BusinessException("库存不足");
			}
		}

		// 保存订单
		Order order = new Order();
		order.status = "待发货";

		// 买方信息
		order.buyer = new Buyer();
		order.buyer.userId = userId;
		order.buyer.addressInfo = DtoUtil.copyObject(address, AddressInfo.class);

		order.productList = new LinkedList<>();
		Factory.getOrderRepository().saveOrder(order);

		// 保存订单商品
		for (CartProductDTO it : productList)
		{
			OrderProduct product = DtoUtil.copyObject(it, OrderProduct.class);
			Factory.getOrderRepository().saveOrderProduct(order.orderId, product);
			order.productList.add(product);
		}

		// 返回订单
		return get(order.orderId);
	}

	/**
	 * 获取订单
	 * @param orderId
	 * @return
	 */
	public static Order get(long orderId)
	{
		// 读取订单
		Order order = Factory.getOrderRepository().getOrder(orderId);
		// 读取订单商品
		order.productList = Factory.getOrderRepository().getOrderProduct(orderId);
		return order;
	}

	/**
	 * 供应商发货
	 */
	public void send()
	{
		this.status = "供应商发货";
		Factory.getOrderRepository().saveOrder(this);
	}

	/**
	 * 用户确认收货
	 * @param rate
	 */
	public void receive(int rate)
	{
		this.status = "已收货";
		Factory.getOrderRepository().saveOrder(this);
	}
}

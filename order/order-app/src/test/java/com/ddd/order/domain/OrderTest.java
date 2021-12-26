package com.ddd.order.domain;

import com.alibaba.fastjson.JSON;
import com.ddd.order.domain.dto.AddressDTO;
import com.ddd.order.domain.dto.CartProductDTO;
import com.ddd.order.domain.factory.Factory;
import com.ddd.order.domain.model.Order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderTest
{
	@Before
	public void before()
	{
		Factory.TestMode = true;
	}

	@Test
	public void create() throws Exception
	{
		AddressDTO address = new AddressDTO();
		address.name = "WishZ";
		address.phone = "15980546806";

		List<CartProductDTO> productList = new LinkedList<>();
		CartProductDTO productDTO = new CartProductDTO();
		productDTO.productId = 1;
		productDTO.num = 4;
		productList.add(productDTO);

		Order order = Order.create(1, productList, address);
		System.out.println(JSON.toJSONString(order, true));
		Assert.assertNotEquals(order.orderId, 0);
	}
}

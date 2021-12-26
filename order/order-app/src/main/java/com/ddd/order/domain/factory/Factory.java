package com.ddd.order.domain.factory;

import com.ddd.order.domain.repository.ApiRepository;
import com.ddd.order.domain.repository.ApiRepositoryMock;
import com.ddd.order.domain.repository.OrderRepository;
import com.ddd.order.domain.repository.OrderRepositoryMock;

public class Factory
{
	public static boolean TestMode = false;

	public static OrderRepository getOrderRepository()
	{
		if (TestMode)
		{
			return new OrderRepositoryMock();
		}
		return null;
	}

	public static ApiRepository getApiRepository()
	{
		if (TestMode)
		{
			return new ApiRepositoryMock();
		}
		return null;
	}
}
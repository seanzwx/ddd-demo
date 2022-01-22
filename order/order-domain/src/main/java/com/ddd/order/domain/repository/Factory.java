package com.ddd.order.domain.repository;

public class Factory
{
	private static ApiRepository apiRepository = new ApiRepositoryMock();
	private static OrderRepository orderRepository = new OrderRepositoryMock();

	public static void setRepository(ApiRepository apiRepository, OrderRepository orderRepository)
	{
		Factory.apiRepository = apiRepository;
		Factory.orderRepository = orderRepository;
	}

	public static OrderRepository getOrderRepository()
	{
		return orderRepository;
	}

	public static ApiRepository getApiRepository()
	{
		return apiRepository;
	}
}
package com.ddd.order.repository;

import com.alibaba.fastjson.JSON;
import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.repository.OrderRepository;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderRepositoryTest
{
	@Test
	public void getOrder()
	{
		Order order = getOrderRepository().getOrder(1);
		System.out.println(JSON.toJSONString(order, true));
	}

	private OrderRepository getOrderRepository()
	{
		return new OrderRepositoryImpl(() ->
		{
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("");
			dataSource.setUrl("");
			dataSource.setUsername("");
			dataSource.setPassword("");
			return new JdbcTemplate(dataSource);
		});
	}
}

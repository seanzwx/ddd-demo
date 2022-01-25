package com.ddd.order.repository;

import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.model.OrderProduct;
import com.ddd.order.domain.repository.OrderRepository;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class OrderRepositoryImpl implements OrderRepository
{
	private Supplier<JdbcTemplate> jdbcTemplateSupplier;

	public OrderRepositoryImpl(Supplier<JdbcTemplate> jdbcTemplateSupplier)
	{
		this.jdbcTemplateSupplier = jdbcTemplateSupplier;
	}

	@Override
	public Order getOrder(long orderId)
	{
		JdbcTemplate jdbcTemplate = jdbcTemplateSupplier.get();
		System.out.println("jdbctemplate: " + jdbcTemplate);

		// TODO 从mysql获取订单信息
		return new Order();
	}

	@Override
	public void saveOrder(Order order)
	{
		JdbcTemplate jdbcTemplate = jdbcTemplateSupplier.get();
		System.out.println("jdbctemplate: " + jdbcTemplate);

		// TODO 拆分order对象保存到mysql
	}

	@Override
	public List<OrderProduct> getOrderProduct(long orderId)
	{
		return new LinkedList<>();
	}

	@Override
	public void saveOrderProduct(long orderId, OrderProduct product)
	{
	}
}
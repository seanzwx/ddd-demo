package com.ddd.order;

import com.ddd.order.app.util.BeanUtil;
import com.ddd.order.domain.repository.ApiRepository;
import com.ddd.order.domain.repository.Factory;
import com.ddd.order.domain.repository.OrderRepository;
import com.ddd.order.repository.ApiRepositoryImpl;
import com.ddd.order.repository.OrderRepositoryImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.function.Supplier;

@SpringBootApplication
@EnableTransactionManagement
public class Main
{
	public static void main(String[] args) throws Exception
	{
		// 预加载
		prepare();

		// 启动spring
		SpringApplication.run(Main.class, args);
	}

	protected static void prepare()
	{
		Supplier<JdbcTemplate> jdbcTemplateSupplier = () ->
		{
			return BeanUtil.getBean(JdbcTemplate.class);
		};

		// 装配数据仓库
		ApiRepository apiRepository = new ApiRepositoryImpl();
		OrderRepository orderRepository = new OrderRepositoryImpl(jdbcTemplateSupplier);
		Factory.setRepository(apiRepository, orderRepository);
	}
}
package com.ddd.order;

import com.ddd.order.domain.repository.ApiRepository;
import com.ddd.order.domain.repository.Factory;
import com.ddd.order.domain.repository.OrderRepository;
import com.ddd.order.repository.ApiRepositoryImpl;
import com.ddd.order.repository.OrderRepositoryImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Main
{
	public static void main(String[] args) throws Exception
	{
		// 装配数据仓库
		ApiRepository apiRepository = new ApiRepositoryImpl();
		OrderRepository orderRepository = new OrderRepositoryImpl();
		Factory.setRepository(apiRepository, orderRepository);

		// 启动spring
		SpringApplication.run(Main.class, args);
	}
}
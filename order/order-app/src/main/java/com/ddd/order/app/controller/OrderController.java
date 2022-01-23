package com.ddd.order.app.controller;

import com.ddd.order.app.service.OrderService;
import com.ddd.order.app.vo.OrderProductVO;
import com.ddd.order.app.vo.OrderVO;
import com.ddd.order.domain.dto.AddressDTO;
import com.ddd.order.domain.dto.CartProductDTO;
import com.ddd.order.domain.dto.ProductDTO;
import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.model.OrderProduct;
import com.ddd.order.domain.repository.Factory;
import com.netsky.ddd.common.DtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.Data;

@RestController
public class OrderController
{
	@Autowired
	private OrderService orderService;

	@Data
	private static class Product
	{
		long productId;
		int num;
	}

	@Data
	private static class CreateV1P
	{
		List<Product> productList;
		String phone;
		String name;
		String address;
	}

	@Data
	private static class CreateV1R
	{
		long orderId;
	}

	@PostMapping("/order/create/v1")
	public CreateV1R createV1(@RequestBody CreateV1P param) throws Exception
	{
		long userId = 1L;
		List<CartProductDTO> productList = DtoUtil.copyArray(param.productList, CartProductDTO.class);
		AddressDTO address = DtoUtil.copyObject(param, AddressDTO.class);

		long orderId = orderService.create(userId, productList, address);

		CreateV1R data = new CreateV1R();
		data.orderId = orderId;
		return data;
	}

	@Data
	private static class InfoV1P
	{
		long orderId;
	}

	@Data
	private static class InfoV1R
	{
		OrderVO order;
	}

	@PostMapping("/order/info/v1")
	public InfoV1R infoV1(@RequestBody InfoV1P param) throws Exception
	{
		Order order = Order.get(param.orderId);

		InfoV1R data = new InfoV1R();
		data.order = DtoUtil.copyObject(order, OrderVO.class);
		data.order.address = order.buyer.addressInfo.address;
		data.order.productList.clear();
		for (OrderProduct it : order.productList)
		{
			ProductDTO productDTO = Factory.getApiRepository().getProductInfo(it.productId);
			OrderProductVO productVO = DtoUtil.copyObject(productDTO, OrderProductVO.class);
			productVO.num = it.num;
			data.order.productList.add(productVO);
		}
		return data;
	}
}

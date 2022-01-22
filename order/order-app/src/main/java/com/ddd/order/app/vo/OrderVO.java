package com.ddd.order.app.vo;

import java.util.List;

import lombok.Data;

@Data
public class OrderVO
{
	public long orderId;

	public String name;
	public String address;
	public String phone;

	public List<OrderProductVO> productList;
	public String status;
}

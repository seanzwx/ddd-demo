package com.ddd.order.vo;

import lombok.Data;

@Data
public class OrderProductVO
{
	public long productId;
	public String name;
	public String attribute;
	public String unit;
	public int num;
}

package com.ddd.product.dto;

import lombok.Data;

@Data
public class Product
{
	public long productId;
	public String name;
	public String attribute;
	public String unit;
}

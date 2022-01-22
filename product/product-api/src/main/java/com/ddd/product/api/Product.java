package com.ddd.product.api;

import lombok.Data;

@Data
public class Product
{
	public long productId;
	public String name;
	public String attribute;
	public String unit;
}
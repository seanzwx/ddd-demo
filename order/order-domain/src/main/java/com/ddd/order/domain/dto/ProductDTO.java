package com.ddd.order.domain.dto;

import lombok.Data;

@Data
public class ProductDTO
{
	public long productId;
	public String name;
	public String attribute;
	public String unit;
}

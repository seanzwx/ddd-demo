package com.ddd.order.domain.dto;

import lombok.Data;

@Data
public class CartProductDTO
{
	public long productId;
	public long salerId;
	public int num;
}

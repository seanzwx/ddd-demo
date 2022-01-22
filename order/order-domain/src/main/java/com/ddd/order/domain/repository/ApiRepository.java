package com.ddd.order.domain.repository;

import com.ddd.order.domain.dto.ProductDTO;

public interface ApiRepository
{
	int getWarehouseProductNum(long productId);

	ProductDTO getProductInfo(long productId);
}
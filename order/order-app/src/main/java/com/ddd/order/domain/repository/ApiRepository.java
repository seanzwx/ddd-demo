package com.ddd.order.domain.repository;

import com.ddd.product.dto.ProductDTO;

public interface ApiRepository
{
	int getWarehouseProductNum(long productId);

	ProductDTO getProductInfo(long productId);
}
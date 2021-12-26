package com.ddd.order.domain.repository;

import com.ddd.product.api.ProductApi;
import com.ddd.product.dto.ProductDTO;
import com.ddd.warehouse.api.WarehouseApi;

public class ApiRepositoryImpl implements ApiRepository
{
	@Override
	public int getWarehouseProductNum(long productId)
	{
		return WarehouseApi.getProductNum(productId);
	}

	@Override
	public ProductDTO getProductInfo(long productId)
	{
		return ProductApi.getProduct(productId);
	}
}
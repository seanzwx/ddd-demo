package com.ddd.order.domain.repository;

import com.ddd.order.domain.dto.ProductDTO;

public class ApiRepositoryMock implements ApiRepository
{
	@Override
	public int getWarehouseProductNum(long productId)
	{
		return 5;
	}

	@Override
	public ProductDTO getProductInfo(long productId)
	{
		ProductDTO product = new ProductDTO();
		product.productId = productId;
		product.name = "éįŽ";
		product.attribute = "2B";
		product.unit = "į";
		return product;
	}
}
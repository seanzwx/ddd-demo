package com.ddd.order.repository;

import com.ddd.order.domain.dto.ProductDTO;
import com.ddd.order.domain.repository.ApiRepository;
import com.ddd.product.api.ProductApi;
import com.ddd.warehouse.api.WarehouseApi;
import com.netsky.ddd.common.DtoUtil;

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
		return DtoUtil.copyObject(ProductApi.getProduct(productId), ProductDTO.class);
	}
}
package com.ddd.order.domain.repository;

import com.ddd.order.domain.dto.ProductDTO;

public interface ApiRepository
{
	/**
	 * 获取商品库存
	 * @param productId
	 * @return
	 */
	int getWarehouseProductNum(long productId);

	/**
	 * 获取商品详情
	 * @param productId
	 * @return
	 */
	ProductDTO getProductInfo(long productId);
}
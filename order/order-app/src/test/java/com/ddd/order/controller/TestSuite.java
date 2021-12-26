package com.ddd.order.controller;

import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

public class TestSuite extends BaseTest
{
	@Test
	public void orderInfo() throws Exception
	{
		JSONObject param = new JSONObject();
		param.put("orderId", "1");
		test("/order/info/v1", param);
	}
}
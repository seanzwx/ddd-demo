package com.ddd.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddd.order.Main;
import com.ddd.order.domain.factory.Factory;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class BaseTest
{
	@Autowired
	protected MockMvc mvc;

	@Before
	public void before()
	{
		Factory.TestMode = true;
	}

	protected void test(String url, JSONObject param) throws Exception
	{
		if (param == null)
		{
			param = new JSONObject();
		}

		// mock请求
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url);
		builder.content(param.toJSONString());
		builder.contentType("application/json");

		// 注入用户信息
		//		AuthInfo authInfo = new AuthInfo();
		//		authInfo.userId = 100000000;
		//		authInfo.account = "zwish163@gmail.com";
		//		builder.header("session", JSON.toJSONString(authInfo));

		mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(mvcResult ->
		{
			JSONObject data = new JSONObject();
			JSONObject request = new JSONObject();
			request.put("url", mvcResult.getRequest().getRequestURL().toString());
			request.put("params", JSON.parseObject(mvcResult.getRequest().getContentAsString()));

			data.put("request", request);
			JSONObject response = JSON.parseObject(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
			if (response == null)
			{
				response = new JSONObject();
			}
			data.put("response", response);
			System.out.println(JSON.toJSONString(data, true));
		});
	}
}

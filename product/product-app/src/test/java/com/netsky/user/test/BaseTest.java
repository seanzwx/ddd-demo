package com.netsky.user.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netsky.soul.restful.AuthInfo;
import com.netsky.soul.restful.RequestFilter;
import com.netsky.user.main.MainUser;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainUser.class)
public class BaseTest
{
	@Autowired
	protected WebApplicationContext context;
	protected MockMvc mvc;

	@Before
	public void setupMockMvc()
	{
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(context);
		builder.addFilter(new RequestFilter(), "/*");
		mvc = builder.build();
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
		AuthInfo authInfo = new AuthInfo();
		authInfo.userId = 100000000;
		authInfo.account = "zwish163@gmail.com";
		authInfo.sessionType = "android";
		authInfo.name = "WishZ";
		authInfo.hasLicense = true;
		builder.header("session", JSON.toJSONString(authInfo));

		mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(new ResultHandler()
		{
			@Override
			public void handle(MvcResult mvcResult) throws Exception
			{
				JSONObject data = new JSONObject();
				JSONObject request = new JSONObject();
				request.put("url", mvcResult.getRequest().getRequestURL().toString());
				request.put("params", JSON.parseObject(mvcResult.getRequest().getContentAsString()));

				data.put("request", request);
				JSONObject response = JSON.parseObject(mvcResult.getResponse().getContentAsString());
				if (response == null)
				{
					response = new JSONObject();
				}
				data.put("response", response);
				System.out.println(JSON.toJSONString(data, true));
			}
		});
	}
}

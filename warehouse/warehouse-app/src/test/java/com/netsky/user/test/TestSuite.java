package com.netsky.user.test;

import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

public class TestSuite extends BaseTest
{
	@Test
	public void auth() throws Exception
	{
		JSONObject param = new JSONObject();
		param.put("sessionId", "sean");
		test("/account/auth/v1", param);
	}

	@Test
	public void signinGoogle() throws Exception
	{
		JSONObject param = new JSONObject();
		param.put("systemUserId", "23433423425346345345");
		param.put("name", "Sean");
		param.put("account", "seanzwx@gmail.com");
		param.put("photoUrl", "http://www.bing.com");
		param.put("app", "tincat");
		param.put("googleSignature", "sdfsdfsdf");
		param.put("googleSignedData", "sdfsdfsdf");
		test("/account/signinGoogle/v1", param);
	}

	@Test
	public void getToken() throws Exception
	{
		JSONObject param = new JSONObject();
		param.put("app", "tincat");
		test("/account/getToken/v1", param);
	}

	@Test
	public void checkToken() throws Exception
	{
		JSONObject param = new JSONObject();
		param.put("token", "4bdd60e9f8ed409bbbcdb6792cbf2855");
		test("/account/checkToken/v1", param);
	}

	@Test
	public void allowToken() throws Exception
	{
		JSONObject param = new JSONObject();
		param.put("token", "4bdd60e9f8ed409bbbcdb6792cbf2855");
		test("/account/allowToken/v1", param);
	}

	@Test
	public void signout() throws Exception
	{
		JSONObject param = new JSONObject();
		test("/account/signout/v1", param);
	}
}
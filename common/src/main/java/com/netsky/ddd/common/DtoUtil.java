package com.netsky.ddd.common;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class DtoUtil
{
	/**
	 * 拷贝对象
	 *
	 * @param from
	 * @param to
	 */
	public static <E> E copyObject(Object from, Class<E> targetClass)
	{
		String json = JSON.toJSONString(from);
		return JSON.parseObject(json, targetClass);
	}

	/**
	 * 拷贝数组
	 *
	 * @param from
	 * @param to
	 */
	public static <E> List<E> copyArray(Object from, Class<E> targetClass)
	{
		String json = JSON.toJSONString(from);
		return JSON.parseArray(json, targetClass);
	}
}

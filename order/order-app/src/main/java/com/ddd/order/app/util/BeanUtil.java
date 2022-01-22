package com.ddd.order.app.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil implements ApplicationContextAware
{
	private static ApplicationContext applicationContext;

	public BeanUtil()
	{
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		BeanUtil.applicationContext = applicationContext;
	}

	public static <E> E getBean(Class<E> clazz)
	{
		return applicationContext != null ? applicationContext.getBean(clazz) : null;
	}
}

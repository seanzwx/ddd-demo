package com.netsky.ddd.common;

import lombok.Data;

@Data
public class BusinessException extends Exception
{
	public int code;
	public String msg;

	public BusinessException(String msg)
	{
		this.code = 1000;
		this.msg = msg;
	}
}

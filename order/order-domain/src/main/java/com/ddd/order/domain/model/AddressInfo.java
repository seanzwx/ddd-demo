package com.ddd.order.domain.model;

import com.ddd.order.domain.dto.AddressDTO;

public class AddressInfo
{
	public long addressId;
	public String name;
	public String address;
	public String phone;

	public static void addAddress(long userId, AddressDTO addressDTO)
	{
	}

	public void update(String name, String address, String phone)
	{
	}
}

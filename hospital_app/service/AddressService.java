package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.AddressDaoImp;
import com.ty.hospital_app.dto.Address;

public class AddressService 
{
	public void saveAddress(int aid, Address address) 
	{
		AddressDaoImp addressdaoimp = new AddressDaoImp();
		Address address2 = addressdaoimp.saveAddress(aid, address);
		if(address2 != null)
		{
			System.out.println("Address saved");
		}
		else {
			System.out.println("Unfortunately address not saved");
		}
	}
	public Address getAddressId(int aid)
	{
		AddressDaoImp addressdaoimp = new AddressDaoImp();
		Address address = addressdaoimp.getAddressById(aid);
		if(address!=null)
		{
			return address;
		}
		else {
			return null;
		}
	}
	public void deleteAddressId(int aid)
	{
		AddressDaoImp daoimp = new AddressDaoImp();
		Address address = daoimp.getAddressById(aid);
		boolean flag = daoimp.deleteAddress(aid);
		if(flag)
		{
			System.out.println("Address deleted");
		}
		else {
			System.out.println("Address not found");
		}
	}
	public Address updateAddress(int aid, Address address)
	{
		AddressDaoImp daoimp = new AddressDaoImp();
		Address address1 = daoimp.updateAddressById(aid, address);
		if(address1 != null)
		{
			return address1;
		}
		else {
			return null;
		}
	}
	

}

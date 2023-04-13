package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Address;

public interface AddressDao {
	
	public Address saveAddress(int bId, Address address);
	public boolean deleteAddress(int aId);
	public Address getAddressById(int aId);
	public Address updateAddressById(int aId, Address address);
	public List<Address> getAllAddress();
	
}

package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.MedOrder;

public interface MedOrderDao {
	
	public MedOrder saveMedOrder(int eId, MedOrder medOrder);
	public boolean deleteMedOrder(int mId);
	public MedOrder getMedOrderById(int mId);
	public MedOrder updateMedOrderById(int mId, MedOrder medOrder);
	public List<MedOrder> getAllMedOrders();
	public List<MedOrder> getMedOrderByDoctorName(String doctorName);
	
}

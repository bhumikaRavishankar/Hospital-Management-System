package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.MedOrderDaoImp;
import com.ty.hospital_app.dto.MedOrder;

public class MedOrderService 
{
	public void saveMedorder(int eid, MedOrder medorder) 
	{
		MedOrderDaoImp medorderdaoimp = new MedOrderDaoImp();
		MedOrder medorder2 = medorderdaoimp.saveMedOrder(eid, medorder);
		if(medorder2 != null)
		{
			System.out.println("Medorder saved");
		}
		else {
			System.out.println("Unfortunately medorder not saved");
		}
	}
	public MedOrder getMedorderId(int mid)
	{
		MedOrderDaoImp medorderdaoimp = new MedOrderDaoImp();
		MedOrder medorder = medorderdaoimp.getMedOrderById(mid);
		if(medorder!=null)
		{
			return medorder;
		}
		else {
			return null;
		}
	}
	public void deleteMedorderId(int mid)
	{
		MedOrderDaoImp daoimp = new MedOrderDaoImp();
		MedOrder medorder = daoimp.getMedOrderById(mid);
		boolean flag = daoimp.deleteMedOrder(mid);
		if(flag)
		{
			System.out.println("Medorder deleted");
		}
		else {
			System.out.println("Medorder not found");
		}
	}
	public MedOrder updateMedorder(int mid, MedOrder medorder)
	{
		MedOrderDaoImp daoimp = new MedOrderDaoImp();
		MedOrder medorder1 = daoimp.updateMedOrderById(mid, medorder);
		if(medorder1 != null)
		{
			return medorder1;
		}
		else {
			return null;
		}
	}

}

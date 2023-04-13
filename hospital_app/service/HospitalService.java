package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService 
{
	public void saveHospital(Hospital hospital)
	{
		HospitalDaoImp daoimp = new HospitalDaoImp();
		Hospital hospital1 = daoimp.saveHospital(hospital);
		if(hospital1!=null)
		{
			System.out.println("Hospital saved");
		}
		else {
			System.out.println("Unfortunatly hospital not saved");
		}
	}
	public Hospital getHospitalId(int hid) 
	{
		HospitalDaoImp daoimp = new HospitalDaoImp();
		Hospital hospital = daoimp.getHospitalById(hid);
		if(hospital!=null)
		{
			return hospital;
		}
		else {
			return null;
		}
	}
	public void deleteHospitalId(int hid) 
	{
		HospitalDaoImp daoimp = new HospitalDaoImp();
		Hospital hospital = daoimp.getHospitalById(hid);
		boolean flag = daoimp.deleteHospital(hid);
		if(flag)
		{
			System.out.println("Hospital deleted");
		}
		else {
			System.out.println("Hospital not found");
		}
	}
	public Hospital updateHospital(int hid, Hospital hospital)
	{
		HospitalDaoImp daoimp = new HospitalDaoImp();
		Hospital hospital1 = daoimp.updateHospitalById(hid, hospital);
		if(hospital1 != null)
		{
			return hospital1;
		}
		else {
			return null;
		}
	}

}

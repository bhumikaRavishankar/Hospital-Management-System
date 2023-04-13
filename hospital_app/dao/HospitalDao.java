package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.Hospital;

public interface HospitalDao {
	
	public Hospital saveHospital(Hospital hospital);
	public boolean deleteHospital(int hId);
	public Hospital getHospitalById(int hId);
	public Hospital updateHospitalById(int hId, Hospital hospital);
	
}

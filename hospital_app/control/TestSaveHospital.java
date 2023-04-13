package com.ty.hospital_app.control;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestSaveHospital {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		HospitalService hospitalService = new HospitalService();
		hospital.sethName("Victoria");
		hospital.setWebsite("www.victoriahospital.com");
		hospitalService.saveHospital(hospital);
	}

}

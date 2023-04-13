package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Observation;

public interface ObservationDao {
	
	public Observation saveObservation(int eId, Observation observation);
	public boolean deleteObservation(int oId);
	public Observation getObservationById(int oId);
	public Observation updateObservationById(int oId, Observation observation);
	public List<Observation> getAllObservations();
	public List<Observation> getObservationByDoctorName(String doctorName);
	
}

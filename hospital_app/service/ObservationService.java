package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.ObservationDaoImp;
import com.ty.hospital_app.dto.Observation;

public class ObservationService {
	
	public void saveObservation(int eId, Observation observation) 
	{
		ObservationDaoImp observationdaoimp = new ObservationDaoImp();
		Observation observation2 = observationdaoimp.saveObservation(eId, observation);
		if(observation2 != null)
		{
			System.out.println("Observation saved");
		}
		else {
			System.out.println("Unfortunately observation not saved");
		}
	}
	public Observation getObservationId(int oId)
	{
		ObservationDaoImp observationdaoimp = new ObservationDaoImp();
		Observation observation = observationdaoimp.getObservationById(oId);
		if(observation!=null)
		{
			return observation;
		}
		else {
			return null;
		}
	}
	public void deleteObservationId(int oId)
	{
		ObservationDaoImp daoimp = new ObservationDaoImp();
		Observation observation = daoimp.getObservationById(oId);
		boolean flag = daoimp.deleteObservation(oId);
		if(flag)
		{
			System.out.println("Observation deleted");
		}
		else {
			System.out.println("Observation not found");
		}
	}
	public Observation updateObservation(int oId, Observation observation)
	{
		ObservationDaoImp daoimp = new ObservationDaoImp();
		Observation observation1 = daoimp.updateObservationById(oId, observation);
		if(observation1!= null)
		{
			return observation1;
		}
		else {
			return null;
		}
	}
	
}

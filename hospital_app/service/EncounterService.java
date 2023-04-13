package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.EncounterDaoImp;
import com.ty.hospital_app.dto.Encounter;

public class EncounterService 
{
	public void saveEncounter(int bid, Encounter encounter)
	{
		EncounterDaoImp encounterdaoimp = new EncounterDaoImp();
		Encounter encounter2 = encounterdaoimp.saveEncounter(bid, encounter);
		if(encounter2 != null)
		{
			System.out.println("Encounter saved");
		}
		else {
			System.out.println("Unfortunately encounter not saved");
		}
	}
	public Encounter getEncounterId(int eid)
	{
		EncounterDaoImp encounterdaoimp = new EncounterDaoImp();
		Encounter encounter = encounterdaoimp.getEncounterById(eid);
		if(encounter!=null)
		{
			return encounter;
		}
		else {
			return null;
		}
	}
	public void deleteEncounterId(int eid)
	{
		EncounterDaoImp daoimp = new EncounterDaoImp();
		Encounter encounter = daoimp.getEncounterById(eid);
		boolean flag = daoimp.deleteEncounter(eid);
		if(flag)
		{
			System.out.println("Encounter deleted");
		}
		else {
			System.out.println("Encounter not found");
		}
	}
	public Encounter updateEncounter(int eid, Encounter encounter)
	{
		EncounterDaoImp daoimp = new EncounterDaoImp();
		Encounter encounter1 = daoimp.updateEncounterById(eid, encounter);
		if(encounter1 != null)
		{
			return encounter1;
		}
		else {
			return null;
		}
	}

}

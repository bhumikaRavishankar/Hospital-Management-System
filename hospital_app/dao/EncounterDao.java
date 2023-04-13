package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Encounter;

public interface EncounterDao {
	
	public Encounter saveEncounter(int bId, Encounter encounter);
	public boolean deleteEncounter(int eId);
	public Encounter getEncounterById(int eId);
	public Encounter updateEncounterById(int eId, Encounter encounter);
	public List<Encounter> getAllEncounter();
	
}

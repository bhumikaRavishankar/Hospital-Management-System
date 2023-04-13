package com.ty.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Observation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oId;
	private String dName;
	private String rObservation;
	@ManyToOne
	@JoinColumn
	private Encounter encounter;
	
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getrObservation() {
		return rObservation;
	}
	public void setrObservation(String rObservation) {
		this.rObservation = rObservation;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
}

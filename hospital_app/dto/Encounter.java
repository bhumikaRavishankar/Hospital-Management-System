package com.ty.hospital_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eId;
	private String reason;
	private String dateOfJoining;
	private String dateOfDischarge;
	@JoinColumn
	@ManyToOne
	private Branch branch;
	@JoinColumn
	@ManyToOne
	private Person persons;
	@OneToMany(mappedBy="encounter")
	private List<Observation> observation;
	@OneToMany(mappedBy="encounter")
	private List<MedOrder> order;
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDateOfDischarge() {
		return dateOfDischarge;
	}
	public void setDateOfDischarge(String dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Person getPersons() {
		return persons;
	}
	public void setPersons(Person persons) {
		this.persons = persons;
	}
	public List<Observation> getObservation() {
		return observation;
	}
	public void setObservation(List<Observation> observation) {
		this.observation = observation;
	}
	public List<MedOrder> getOrder() {
		return order;
	}
	public void setOrder(List<MedOrder> order) {
		this.order = order;
	}
		
}

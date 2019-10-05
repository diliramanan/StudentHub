package com.student.StudentHub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddressTable {
	
	
	@Id
	@Column(name="ROLLNO")
	private long rollno;
	@Column(name="PERMANENTADDRESS")
	private String permanentAddress;
	@Column(name="TEMPORARYTADDRESS ")
	private String temporarytAddress ;
	
	public AddressTable() {
	}

	public AddressTable(long rollno,String permanentAddress, String temporarytAddress) {
		super();
		this.rollno = rollno;
		this.permanentAddress = permanentAddress;
		this.temporarytAddress = temporarytAddress;
	}
	
	
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getTemporarytAddress() {
		return temporarytAddress;
	}
	public void setTemporarytAddress(String temporarytAddress) {
		this.temporarytAddress = temporarytAddress;
	} 

}

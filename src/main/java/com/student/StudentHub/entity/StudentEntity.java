package com.student.StudentHub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=50)
public class StudentEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Column(name="ROLLNO")
	private long rollno;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address; 
	@Column(name="phone_no")
	private long phoneNo;

	public StudentEntity() {
	}

	public StudentEntity(long rollno,String name, String address, long phoneNo) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


}

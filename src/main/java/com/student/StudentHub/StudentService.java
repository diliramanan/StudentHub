package com.student.StudentHub;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.StudentHub.entity.AddressTable;
import com.student.StudentHub.entity.StudentAddressRepository;
import com.student.StudentHub.entity.StudentEntity;
import com.student.StudentHub.entity.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private StudentAddressRepository addressRepo;

	public List<StudentEntity> getAllDetails()
	{
		return (List<StudentEntity>) studentRepo.findAll();
	}

	public void addStudent(StudentEntity studentEntity) {
		studentRepo.save(studentEntity);
	}

	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}

	public boolean updateStudent(StudentEntity detailsToBeUpdated, long id) {
		boolean flg = false;
		Optional<StudentEntity> studentIdDetail = studentRepo.findById(id);
		if(studentRepo.findById(id).isPresent()) {
			studentRepo.save(new StudentEntity(studentIdDetail.get().getRollno(), detailsToBeUpdated.getName(), detailsToBeUpdated.getAddress(), detailsToBeUpdated.getPhoneNo()));
			flg = true;
		}
		return flg;
	}
	
	
	public List<AddressTable> getAllAddressDetails()
	{
		return (List<AddressTable>) addressRepo.findAll();
	}

	public void addStudentAddress(AddressTable address) {
		System.out.println("service"+address);
		addressRepo.save(address);
	}

	public void deleteStudentAddress(long id) {
		addressRepo.deleteById(id);
	}

	public boolean updateStudentAddress(AddressTable address, long id) {
		boolean flg = false;
		Optional<AddressTable> studentAddressId = addressRepo.findById(id);
		if(addressRepo.findById(id).isPresent()) {
			addressRepo.save(new AddressTable(studentAddressId.get().getRollno(), address.getPermanentAddress(), address.getTemporarytAddress()));
			flg = true;
		}
		return flg;
	}



}


	
	
	


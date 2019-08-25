package com.student.StudentHub;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

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
}

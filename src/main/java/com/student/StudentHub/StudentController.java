package com.student.StudentHub;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.student.StudentHub.entity.AddressTable;
import com.student.StudentHub.entity.StudentEntity;

@RestController
@RequestMapping("/studentDetails")
public class StudentController {

	@Autowired
	private StudentService studentService; 

	@GetMapping("/fetch") 
	public ResponseEntity<List<StudentEntity>> studentDetails() {
		List<StudentEntity> studentDetails = studentService.getAllDetails();
		return new ResponseEntity<List<StudentEntity>>(studentDetails, HttpStatus.OK); 
	}
	
	@GetMapping("/fetchAddress") 
	public ResponseEntity<List<AddressTable>> studentAddressDetails() {
		List<AddressTable> studentDetails = studentService.getAllAddressDetails();
		return new ResponseEntity<List<AddressTable>>(studentDetails, HttpStatus.OK); 
	}

	@PostMapping("/insertAddress")
	public void addStudentAddress(@RequestBody AddressTable address) {
		System.out.println("controller "+address);
		studentService.addStudentAddress(address);
	} 
	
	@PostMapping("/insert")
	public void addStudentDetails(@RequestBody StudentEntity details) {
		studentService.addStudent(details);
	} 

	@DeleteMapping("/delete/{id}")
	public void deleteStudentDetails(@PathVariable long id){
		studentService.deleteStudent(id);
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	public void deleteStudentAddress(@PathVariable long id){
		studentService.deleteStudentAddress(id);
	}

	@PutMapping("/update/{id}")
	public  ResponseEntity<?> putStudentDetails(@RequestBody StudentEntity details,@PathVariable long id) {	
		boolean updateFlag = studentService.updateStudent(details,id);
		return updateFlag ?  new ResponseEntity<>(HttpStatus.OK): new ResponseEntity<>("Your request is bad",HttpStatus.BAD_REQUEST) ;
	}
	
	@PutMapping("/updateAddress/{id}")
	public  ResponseEntity<?> putStudentAddress(@RequestBody AddressTable address,@PathVariable long id) {	
		boolean updateFlag = studentService.updateStudentAddress(address,id);
		return updateFlag ?  new ResponseEntity<>(HttpStatus.OK): new ResponseEntity<>("Your request is bad",HttpStatus.BAD_REQUEST) ;
	}



}

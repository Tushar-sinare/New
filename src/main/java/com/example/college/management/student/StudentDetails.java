package com.example.college.management.student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.address.Address;
import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.record.Colleges;
import com.example.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class StudentDetails extends Colleges{
	private static final Logger logger = LoggerFactory.getLogger(StudentDetails.class);
		String branches;
	String depts;
	String specifications;
	List<Student> studentDetails;
	public StudentDetails(Branch.Engineering branch, College dept, Specification specification){
		super(branch,dept,specification);		
		this.branches = branch.name();
		this.depts = dept.name();
		this.specifications=specification.name();
		List<Student> studentList = addStudentDetails();
		writeStudentDetailsFile(studentList);
	}
	public StudentDetails(Branch.Graduation branch, College dept, Specification specification){
		super(branch,dept,specification);	
		this.branches = branch.name();
		this.depts = dept.name();
		this.specifications=specification.name();
		List<Student> studentList = addStudentDetails();
		writeStudentDetailsFile(studentList);
	}
	public List<Student> addStudentDetails(){
		studentDetails=new ArrayList<>();
		logger.info("\nPlease Fill Student Details\n");
		Scanner sc = new Scanner(System.in);
		logger.info("Enter Your RollNo : ");
		int rollNo = sc.nextInt();
		sc.nextLine();
		logger.info("Enter Your Name : ");
		String name = sc.nextLine();
		logger.info("Enter Your Mobile No : ");
		Long mobileNo = sc.nextLong();
		sc.nextLine();
		logger.info("Enter Your Email Id : ");
		String emailId = sc.nextLine();
		logger.info("Enter Your Current Address : ");
		String cAddress = sc.nextLine();
		logger.info("Enter Your Permanent Address : ");
		String pAddress = sc.nextLine();
		Address address = new Address(cAddress,pAddress);
		studentDetails.add(new Student(rollNo,name,mobileNo,emailId,address,specifications,branches));

		return studentDetails;
	}
	
	
}

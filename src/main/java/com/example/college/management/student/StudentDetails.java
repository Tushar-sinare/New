package com.example.college.management.student;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.address.Address;
import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.record.Colleges;
import com.example.specification.Specification;
public class StudentDetails extends Colleges{
	Student student;
	String branches;
	String depts;
	String specifications;
	List<Student> studentDetils;
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
		studentDetils=new ArrayList<>();
		System.out.println("\nPlease Fill Student Details\n");
		try(Scanner sc = new Scanner(System.in)){
		System.out.print("Enter Your RollNo : ");
		int rollNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Your Name : ");
		String name = sc.nextLine();
		System.out.print("Enter Your Mobile No : ");
		Long mobileNo = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter Your Email Id : ");
		String emailId = sc.nextLine();
		System.out.print("Enter Your Current Address : ");
		String cAddress = sc.nextLine();
		System.out.print("Enter Your Permanent Address : ");
		String pAddress = sc.nextLine();
		
		Address address = new Address(cAddress,pAddress);
		studentDetils.add(new Student(rollNo,name,mobileNo,emailId,address,specifications,branches));
		}
		return studentDetils;
	}
	
	
}

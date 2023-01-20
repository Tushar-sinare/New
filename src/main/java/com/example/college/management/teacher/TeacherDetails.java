package com.example.college.management.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.address.Address;
import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.record.Colleges;
import com.example.specification.Specification;

public class TeacherDetails extends Colleges {
	Teacher teacher;
	String branch;
	String dept;
	String specification;
	List<Teacher> teacherDetils;
	public TeacherDetails(Branch.Engineering branch, College dept, Specification specification) {
		super(branch,dept,specification);	
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification = specification.name();
		List<Teacher> teacherList = addTeacherDetails();
		writeTeacherDetailsFile(teacherList);
	}

	public TeacherDetails(Branch.Graduation branch, College dept, Specification specification) {
		super(branch,dept,specification);	
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification = specification.name();
		List<Teacher> teacherList = addTeacherDetails();
		writeTeacherDetailsFile(teacherList);
	}

	public List<Teacher> addTeacherDetails() {
		teacherDetils = new ArrayList<>();
		System.out.println("\nPlease Fill Teacher Details\n");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Your Emp ID : ");
			int rollNo = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Your Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Your Mobile No : ");
			Long mobileNo = sc.nextLong();
			sc.nextLine();
			System.out.print("Enter Your Email Id : ");
			String emailId = sc.nextLine();
			System.out.print("Enter Your Subject : ");
			String subSpecific = sc.nextLine();
			System.out.print("Enter Your Current Address : ");
			String cAddress = sc.nextLine();
			System.out.print("Enter Your Permanent Address : ");
			String pAddress = sc.nextLine();
			
			Address address = new Address(cAddress,pAddress);

			teacherDetils.add(new Teacher(rollNo, name, mobileNo, emailId, subSpecific, address, specification, branch));
		}
		return teacherDetils;
	}

	


}
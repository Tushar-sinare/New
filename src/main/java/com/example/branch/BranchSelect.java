package com.example.branch;

import java.util.Scanner;

import com.example.colleagestaff.College;
import com.example.college.management.student.StudentDetails;
import com.example.college.management.teacher.TeacherDetails;
import com.example.record.CollegeRecord;
import com.example.specification.Specification;

public class BranchSelect {
	public void engineeringBranch(String branch, College dept, Specification specification) {
		switch (branch.toUpperCase()) {
		case "CL":
			addDetailSpecific(Branch.Engineering.CIVIL, dept, specification);
			break;
		case "MECH":
			addDetailSpecific(Branch.Engineering.MECHANICAL, dept, specification);
			break;
		case "IT":
				addDetailSpecific(Branch.Engineering.IT, dept, specification);
			break;
		case "COMP":
				addDetailSpecific(Branch.Engineering.COMPUTER, dept, specification);
			break;
		case "E&T":
				addDetailSpecific(Branch.Engineering.ENTC, dept, specification);
			break;
		default:
			System.out.println("Invalid Key Input");
		}
	}
	public void graduationBranch(String branch, College dept, Specification specification) {
		switch (branch.toUpperCase()) {
		case "BCA":
			addDetailSpecific(Branch.Graduation.BCA, dept, specification);
			break;
		case "BBA":
			addDetailSpecific(Branch.Graduation.BBA, dept, specification);
			break;
		case "BCOM":
			addDetailSpecific(Branch.Graduation.BCOM, dept, specification);
			break;
		case "BSC":
			addDetailSpecific(Branch.Graduation.BSC, dept, specification);
			break;
		case "BCS":
			addDetailSpecific(Branch.Graduation.BCS, dept, specification);
			break;
		default:
			System.out.println("Invalid Key Input");
		}

	}

	public void addDetailSpecific(Branch.Engineering branch, College dept, Specification specification) {
		if("STUDENT".equals(dept.name())) {
			new StudentDetails(branch,dept,specification);
		}else if("TEACHER".equals(dept.name())) {
			new TeacherDetails(branch,dept,specification);
		}else if("PRINCIPLE".equals(dept.name())) {
			principleDetails(branch,dept,specification);
		}else {
			System.out.println("Invalid Key Input");
		}
	}
	public void addDetailSpecific(Branch.Graduation branch, College dept, Specification specification) {
		if("STUDENT".equals(dept.name())) {
			new StudentDetails(branch,dept,specification);
		}else if("TEACHER".equals(dept.name())) {
			new TeacherDetails(branch,dept,specification);
		}else if("PRINCIPLE".equals(dept.name())) {
			principleDetails(branch,dept,specification);
		}else {
			System.out.println("Invalid Key Input");
		}
	}
	public void principleDetails(Branch.Engineering branch, College dept, Specification specification) {
		CollegeRecord collegeRecord =new CollegeRecord();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a Key For Details :\n S:Student\n T:Teacher \n ");
			String deptartment = sc.nextLine(); 
			collegeRecord.collegeRecordDetails(deptartment,branch,dept,specification);
		}
	}
public void principleDetails(Branch.Graduation branch, College dept, Specification specification) {
	CollegeRecord collegeRecord =new CollegeRecord();
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Enter a Key For Details :\n S:Student\n T:Teacher \n ");
		String recordGraduation = sc.nextLine(); 
		collegeRecord.collegeRecordDetails(recordGraduation,branch,dept,specification);
	}	
	}
}

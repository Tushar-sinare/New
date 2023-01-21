package com.example.branch;


import com.example.colleagestaff.College;
import com.example.college.management.student.StudentDetails;
import com.example.college.management.teacher.TeacherDetails;
import com.example.record.CollegeRecord;
import com.example.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
public class BranchSelect {
	 private static final Logger logger = LoggerFactory.getLogger(BranchSelect.class);
	static final String show = "Invalid Key Input";
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
			logger.info(show);
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
			logger.info(show);
		}

	}

	public void addDetailSpecific(Branch.Engineering branch, College dept, Specification specification) {
		switch(dept.name()) {
					case "STUDENT" :
										new StudentDetails(branch,dept,specification);
											break;
			case "TEACHER":
			new TeacherDetails(branch,dept,specification);
			break;
			case "PRINCIPLE":
			principleDetails(branch,dept,specification);
			break;
			 default:
			System.out.println(show);
		}
	}
	public void addDetailSpecific(Branch.Graduation branch, College dept, Specification specification) {
		switch(dept.name()) {
			case "STUDENT" :
				new StudentDetails(branch,dept,specification);
				break;
			case "TEACHER":
				new TeacherDetails(branch,dept,specification);
				break;
			case "PRINCIPLE":
				principleDetails(branch,dept,specification);
				break;
			default:
				logger.info(show);
		}
	}
	public void principleDetails(Branch.Engineering branch, College dept, Specification specification) {
		CollegeRecord collegeRecord =new CollegeRecord();
		Scanner sc = new Scanner(System.in);
			logger.info("Enter a Key For Details :\n S:Student\n T:Teacher \n ");
			String deptName = sc.nextLine();
			collegeRecord.collegeRecordDetails(deptName,branch,dept,specification);

	}
public void principleDetails(Branch.Graduation branch, College dept, Specification specification) {
	CollegeRecord collegeRecord =new CollegeRecord();
	Scanner sc = new Scanner(System.in);
		logger.info("Enter a Key For Details :\n S:Student\n T:Teacher \n ");
		String recordGraduation = sc.nextLine(); 
		collegeRecord.collegeRecordDetails(recordGraduation,branch,dept,specification);
	}	
	}


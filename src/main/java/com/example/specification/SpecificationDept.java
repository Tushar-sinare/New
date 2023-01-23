package com.example.specification;
import java.util.Scanner;

import com.example.branch.BranchSelect;
import com.example.colleagestaff.College;
import com.example.college.principle.StudentAndTeacherRecordThroughPrinciple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecificationDept {
	private static final Logger logger = LoggerFactory.getLogger(SpecificationDept.class);
	Specification specification;
	College category;
	public SpecificationDept(College category){
		 this.category =category;
	}
public void specificationDetails(String spec) {
	
	switch(spec.toUpperCase()) {
	case "E" :
	
		callToBranch(Specification.ENGINEERING,category );
		
		break;
	case "G" :
	
		callToBranch(Specification.GRADUATION,category);
		
		break;
	
		default: 
			logger.info("Invalid Key");
		
	}
	
	}

public void callToBranch(Specification str,College category) {
	BranchSelect branchSelect =new BranchSelect();
	StudentAndTeacherRecordThroughPrinciple studentAndTeacherRecordThroughPrinciple =new StudentAndTeacherRecordThroughPrinciple();
	if(Specification.ENGINEERING == str) {
	if(College.STUDENT == category || College.TEACHER==category) {
	logger.info("Enter a Key For Engieeniring :\n CL:Civil\n MECH:Mechanical \n IT:It \n COMP: Computer \n E&T: ENTC \n ");
	
	try(Scanner sc = new Scanner(System.in)){
	String spec = sc.next();
	branchSelect.engineeringBranch(spec,category,str);
	}
	}else {
		logger.info("Enter a Key For Engieeniring Record Details :\n S:STUDENT\n T:TEACHER \n ");
		try(Scanner sc = new Scanner(System.in)){
		String department = sc.next();
		studentAndTeacherRecordThroughPrinciple.studentDetailsRecord(department,str);
		}
	}
	}
	else if(Specification.GRADUATION == str) {
		if(College.STUDENT == category || College.TEACHER==category) {
		logger.info("Enter a Key For Graguation :\n BCA:BCA \n BBA:BBA \n BCOM:BCOM \n BSC:BSC \n BCS:BCS \n ");
		try(Scanner sc = new Scanner(System.in)){
		String spec = sc.next();
		branchSelect.graduationBranch(spec,category,str);
		}
		}else {
			logger.info("Enter a Key For Graguation Record Details :\n S:STUDENT\n T:TEACHER \n ");
			try(Scanner sc = new Scanner(System.in)){
			String spec = sc.next();
			studentAndTeacherRecordThroughPrinciple.studentDetailsRecord(spec,str);
			}
	}
}
}
}


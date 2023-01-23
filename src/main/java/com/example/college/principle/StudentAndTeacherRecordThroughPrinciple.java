package com.example.college.principle;

import com.example.colleagestaff.College;
import com.example.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
public class StudentAndTeacherRecordThroughPrinciple {
	private static final Logger logger = LoggerFactory.getLogger(StudentAndTeacherRecordThroughPrinciple.class);
public void studentDetailsRecord(String spec, Specification specification) {
	if(spec!=null && !spec.isEmpty()) {
		switch(spec.toUpperCase()) {
		case "S":
			recordDetails(College.STUDENT,specification);
		break;
		case "T":
			recordDetails(College.TEACHER,specification);
		break;
		default:
			logger.info("Invalid Input Press");
		}
	}
}
public void recordDetails(College dept, Specification specification) {
	EngineeringBranchRecord engineeringBranchRecord =new EngineeringBranchRecord();
	if(Specification.ENGINEERING==specification) {
		logger.info("Enter a Key For Engineering :\n All: All Branch \n CL:Civil\n MECH:Mechanical \n IT:It \n COMP: Computer \n E&T: ENTC \n ");
		Scanner sc = new Scanner(System.in);
		String spec = sc.next();
		engineeringBranchRecord.detailsRecord(spec,dept,specification);

		
	}else if(Specification.GRADUATION==specification) {
		logger.info("Enter a Key For Graduation :\n All: All Branch\n BCA:BCA \n BBA:BBA \n BCOM : BCOM \n BSC:BSC \n BCS:BCS \n ");
		Scanner sc = new Scanner(System.in);
		String spec = sc.next();
		engineeringBranchRecord.detailsRecord(spec,dept,specification);

	}
	
}
}
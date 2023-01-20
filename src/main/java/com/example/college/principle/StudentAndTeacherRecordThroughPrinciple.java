package com.example.college.principle;

import java.util.Scanner;

import com.example.colleagestaff.College;
import com.example.specification.Specification;

public class StudentAndTeacherRecordThroughPrinciple {
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
			System.out.println("Invalid Input Press");
		}
	}
}

public void recordDetails(College dept, Specification specification) {
	EngineeringBranchRecord engineeringBranchRecord =new EngineeringBranchRecord();
	if(Specification.ENGINEERING==specification) {
		System.out.println("Enter a Key For Engieeniring :\n All: All Branch \n CL:Civil\n MECH:Mechanical \n IT:It \n COMP: Computer \n E&T: ENTC \n ");
		try(Scanner sc = new Scanner(System.in)){
		String spec = sc.next();
		engineeringBranchRecord.detailsRecord(spec,dept,specification);
		}
		
	}else if(Specification.GRADUATION==specification) {
		System.out.println("Enter a Key For Graguation :\n All: All Branch\n BCA:BCA \n BBA:BBA \n BCOM:BCOM \n BSC:BSC \n BCS:BCS \n ");
		try(Scanner sc = new Scanner(System.in)){
		String spec = sc.next();
		engineeringBranchRecord.detailsRecord(spec,dept,specification);
		}
	}
	
}
}